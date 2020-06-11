package com.t248.member.impl;

import com.t248.cure.base.BaseApiService;
import com.t248.cure.base.BaseResponse;
import com.t248.cure.constants.Constants;
import com.t248.cure.utils.MiteBeanUtils;
import com.t248.member.mapper.UserMapper;
import com.t248.member.mapper.entity.UserDo;
import com.t248.member.output.dto.UserOutDTO;
import com.t248.service.MemberService;
import com.t248.weixin.entity.App;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: shop-parent
 * @author: 水向南
 * @create: 2020-05-18 08:35
 **/
@RestController
public class  MemberServiceImpl extends BaseApiService<UserOutDTO> implements MemberService {


    @Resource
    private UserMapper userMapper;

    @Override
    public BaseResponse<UserOutDTO> existMobile(String mobile) {
        // 1.验证参数
        if (StringUtils.isEmpty(mobile)) {
            return setResultError("手机号码不能为空!");
        }
        UserDo userEntity = userMapper.existMobile(mobile);
        if (userEntity == null) {
            return setResultError(Constants.HTTP_RES_CODE_EXISTMOBILE_203, "用户不存在");
        }
        // 注意需要将敏感数据进行脱敏 DO转DTO
        return setResultSuccess(MiteBeanUtils.doToDto(userEntity,UserOutDTO.class));
    }

}
