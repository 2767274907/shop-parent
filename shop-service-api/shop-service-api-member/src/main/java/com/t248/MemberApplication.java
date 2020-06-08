package com.t248;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: shop-parent
 * @author: 水向南
 * @create: 2020-05-16 14:30
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class,args);
    }

}
