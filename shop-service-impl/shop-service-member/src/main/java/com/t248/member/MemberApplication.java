package com.t248.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName ShopServiceMemberApplication
 * Description TODO
 * Author 水向南
 * Date 2020/4/1 16:58
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.t248.service"})
public class MemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class,args);
    }


}
