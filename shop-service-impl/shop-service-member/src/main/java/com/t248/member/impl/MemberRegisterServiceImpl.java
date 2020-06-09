package com.t248.member.impl;

import com.alibaba.fastjson.JSONObject;
import com.t248.cure.base.BaseApiService;
import com.t248.cure.base.BaseResponse;
import com.t248.cure.utils.MD5Util;
import com.t248.member.entity.UserEntity;
import com.t248.member.mapper.UserMapper;
import com.t248.service.MemberRegisterService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MemberRegisterServiceImpl extends BaseApiService<JSONObject> implements MemberRegisterService {

    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional
    public BaseResponse<JSONObject> register(UserEntity userEntity, String registCode) {
        //简单验证
        String userName = userEntity.getUserName();
        if(StringUtils.isEmpty(userName)){
            return setResultError("用户名不能为空");
        }
        String mobile = userEntity.getMobile();
        if(StringUtils.isEmpty(mobile)){
            return setResultError("手机号不能为空");
        }
        String pwd = userEntity.getPassword();
        if(StringUtils.isEmpty(pwd)){
            return setResultError("密码不能为空");
        }

        //验证注册码是否正确

        //对密码进行MD5加密
        userEntity.setPassword(MD5Util.MD5(pwd));
        //存入数据库

        return userMapper.register(userEntity)>0?setResultSuccess("注册成功"):setResultError("注册失败");
    }
}
