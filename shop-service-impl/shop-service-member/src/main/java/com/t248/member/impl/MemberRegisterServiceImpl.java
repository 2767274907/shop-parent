package com.t248.member.impl;

import com.alibaba.fastjson.JSONObject;
import com.t248.cure.base.BaseApiService;
import com.t248.cure.base.BaseResponse;
import com.t248.cure.constants.Constants;
import com.t248.cure.utils.MD5Util;
import com.t248.cure.utils.MiteBeanUtils;
import com.t248.member.fegin.VerificaCodeServiceFeign;
import com.t248.member.input.dto.UserInpDTO;
import com.t248.member.mapper.UserMapper;
import com.t248.member.mapper.entity.UserDo;
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

    @Autowired
    private VerificaCodeServiceFeign verificaCodeServiceFeign;


    /**
     * 注册接口
     * @param userInpDTO
     * @param registCode
     * @return
     */
    @Override
    @Transactional
    public BaseResponse<JSONObject> register(UserInpDTO userInpDTO, String registCode) {
        //简单验证
        String userName = userInpDTO.getUserName();
        if(StringUtils.isEmpty(userName)){
            return setResultError("用户名不能为空");
        }
        String mobile = userInpDTO.getMobile();
        if(StringUtils.isEmpty(mobile)){
            return setResultError("手机号不能为空");
        }
        String pwd = userInpDTO.getPassword();
        if(StringUtils.isEmpty(pwd)){
            return setResultError("密码不能为空");
        }

        //验证注册码是否正确
        BaseResponse<JSONObject> verificaWeixinCode = verificaCodeServiceFeign.verificaWeixinCode(mobile, registCode);
        if (!verificaWeixinCode.getCode().equals(Constants.HTTP_RES_CODE_200)){
            return setResultError(verificaWeixinCode.getMsg());
        }
        //对密码进行MD5加密
        userInpDTO.setPassword(MD5Util.MD5(pwd));
        //存入数据库
        UserDo userDo = MiteBeanUtils.doToDto(userInpDTO, UserDo.class);
        return userMapper.register(userDo)>0?setResultSuccess("注册成功"):setResultError("注册失败");
    }
}
