package com.t248.service;

import com.t248.cure.base.BaseResponse;
import com.t248.entity.App;
import org.springframework.web.bind.annotation.GetMapping;

public interface WeiXinService {

    @GetMapping("/getApp")
    public BaseResponse<App> getApp();
}
