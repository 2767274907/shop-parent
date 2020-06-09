package com.t248.impl;

import com.t248.cure.base.BaseApiService;
import com.t248.cure.base.BaseResponse;
import com.t248.weixin.entity.App;
import com.t248.service.WeiXinService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeiXinServiceImpl extends BaseApiService<App> implements WeiXinService {
    @Override
    public BaseResponse<App> getApp() {
        return setResultSuccess(new App("1","appinda"));
    }
}
