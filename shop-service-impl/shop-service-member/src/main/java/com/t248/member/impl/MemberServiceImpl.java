package com.t248.member.impl;

import com.t248.cure.base.BaseApiService;
import com.t248.cure.base.BaseResponse;
import com.t248.cure.constants.Constants;
import com.t248.cure.type.TypeCastHelper;
import com.t248.cure.utils.MiteBeanUtils;
import com.t248.member.mapper.UserMapper;
import com.t248.member.mapper.entity.UserDo;
import com.t248.member.output.dto.UserOutDTO;
import com.t248.service.MemberService;
import com.t248.token.GenerateToken;
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

    @Autowired
    private GenerateToken generateToken;

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

    @Override
    public BaseResponse<UserOutDTO> getInfo(String token) {
        //验证token参数
        if(org.apache.commons.lang3.StringUtils.isEmpty(token)){
            return setResultError("token参数不能为空");
        }
        //根据token获得userid
        String tokenId = generateToken.getToken(token);
        if (StringUtils.isEmpty(tokenId)){
            return setResultError("token已经失效");
        }
        //根据userid查询数据库
        Long userId = TypeCastHelper.toLong(tokenId);
        UserDo userDo = userMapper.findByUserId(userId);
        if (userDo == null){
            return setResultError("用户不存在");
        }
        return setResultSuccess(MiteBeanUtils.doToDto(userDo,UserOutDTO.class));
    }

}
