package com.t248.impl;

import com.t248.entity.App;
import com.t248.service.WeiXinService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeiXinServiceImpl implements WeiXinService {
    @Override
    @GetMapping("/getApp")
    public App getApp() {
        return new App("1","appinda");
    }
}
