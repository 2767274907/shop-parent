package com.t248.impl;

import com.alibaba.fastjson.JSONObject;
import com.t248.cure.base.BaseApiService;
import com.t248.cure.base.BaseResponse;
import com.t248.cure.constants.Constants;
import com.t248.cure.utils.RedisUtil;
import com.t248.service.VerificaCodeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificaCodeServiceImpl extends BaseApiService<JSONObject> implements VerificaCodeService {

    @Autowired
    RedisUtil redisUtis;

    @Override
    public BaseResponse<JSONObject> verificaWeixinCode(String phone, String weixinCode) {
        //判断验证码不为空
        if (StringUtils.isEmpty(phone)){
            return setResultError("手机号码不能为空");
        }
        if (StringUtils.isEmpty(weixinCode)){
            return setResultError("注册码不能为空");
        }
        //根据手机号从redis中获取注册码
        String weiXinCode = Constants.WEIXINCODE_KEY + phone;
        String redisCode = redisUtis.getString(weiXinCode);
        //将redis中的注册码与weixinCode中传过来的参数
        if(StringUtils.isEmpty(redisCode)){
            return setResultError("注册码可能已经过期了");
        }
        if (!redisCode.equals(weixinCode)) {
            return setResultError("注册码不正确");
        }
        //移除对应注册码
        redisUtis.delKey(weiXinCode);
        return setResultSuccess("验证成功");
    }
}
