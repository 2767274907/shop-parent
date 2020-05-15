package com.t248;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: shop-parent
 * @description:
 * @author: 水向南
 * @create: 2020-05-14 20:37
 **/
@SpringBootApplication
@EnableEurekaClient
public class WeiXinEntityApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeiXinEntityApplication.class,args);
    }
}
