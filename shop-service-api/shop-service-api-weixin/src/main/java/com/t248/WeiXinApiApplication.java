package com.t248;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WeiXinApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeiXinApiApplication.class,args);
    }

}
