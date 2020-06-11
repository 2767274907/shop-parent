package com.t248.weixin.mp.handler;

import com.t248.cure.base.BaseResponse;
import com.t248.cure.constants.Constants;
import com.t248.cure.utils.RedisUtil;
import com.t248.cure.utils.RegexUtils;
import com.t248.member.output.dto.UserOutDTO;
import com.t248.weixin.feign.MemberServiceFeign;
import com.t248.weixin.mp.builder.TextBuilder;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

import static me.chanjar.weixin.common.api.WxConsts.XmlMsgType;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class MsgHandler extends AbstractHandler {

    // 用户发送手机验证码提示
    @Value("${mayikt.weixin.registration.code.message}")
    private String registrationCodeMessage;
    // 默认用户发送验证码提示
    @Value("${mayikt.weixin.default.registration.code.message}")
    private String defaultRegistrationCodeMessage;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private MemberServiceFeign memberFeign;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) {

        if (!wxMessage.getMsgType().equals(XmlMsgType.EVENT)) {
            //TODO 可以选择将消息保存到本地
        }

        //当用户输入关键词如“你好”，“客服”等，并且有客服在线时，把消息转发给在线客服
        try {
            if (StringUtils.startsWithAny(wxMessage.getContent(), "你好", "客服")
                && weixinService.getKefuService().kfOnlineList()
                .getKfOnlineList().size() > 0) {
                return WxMpXmlOutMessage.TRANSFER_CUSTOMER_SERVICE()
                    .fromUser(wxMessage.getToUser())
                    .toUser(wxMessage.getFromUser()).build();
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
        }

        //TODO 组装回复消息
//        String content = "收到信息内容：" + JsonUtils.toJson(wxMessage);
        //获取微信发送的消息
        String fromContent = wxMessage.getContent();
        //使用正则表达式判断是否符合规范，此处为手机号
        if (RegexUtils.checkMobile(fromContent)) {
            //如果是手机格式则发送注册码
            BaseResponse<UserOutDTO> resultUserInfo = memberFeign.existMobile(fromContent);
            if (resultUserInfo.getCode().equals(Constants.HTTP_RES_CODE_200)){
                return new TextBuilder().build("该手机号"+fromContent+"已注册", wxMessage, weixinService);
            }
            // 用户存在就进入
            if (!resultUserInfo.getCode().equals(Constants.HTTP_RES_CODE_EXISTMOBILE_203)){
                return new TextBuilder().build(resultUserInfo.getMsg(), wxMessage, weixinService);
            }

            int code = registCode();
            String content = String.format(registrationCodeMessage, code);
            redisUtil.setString(Constants.WEIXINCODE_KEY+fromContent,code+"",Constants.WEIXINCODE_TIMEOUT);
            return new TextBuilder().build(content, wxMessage, weixinService);
        }
        //如果是其他的就返回默认的
        return new TextBuilder().build(defaultRegistrationCodeMessage, wxMessage, weixinService);

    }

    // 获取注册码
    private int registCode() {
        int registCode = (int) (Math.random() * 9000 + 1000);
        return registCode;
    }

}
