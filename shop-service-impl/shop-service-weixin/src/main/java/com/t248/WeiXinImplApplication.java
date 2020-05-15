package com.t248;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * ClassName ShopServiceWeixinApplication
 * Description TODO
 * Author 水向南
 * Date 2020/4/1 16:55
 */
@SpringBootApplication
@EnableEurekaClient
public class WeiXinImplApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeiXinApiApplication.class,args);
    }

}