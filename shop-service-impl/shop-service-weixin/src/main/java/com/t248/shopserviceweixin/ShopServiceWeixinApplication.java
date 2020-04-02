package com.t248.shopserviceweixin;

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
public class ShopServiceWeixinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopServiceWeixinApplication.class,args);
    }

}
