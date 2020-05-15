package com.t248.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class App {
    private String appId;
    private String appName;

    public App(String appId, String appName) {
        this.appId = appId;
        this.appName = appName;
    }
}
