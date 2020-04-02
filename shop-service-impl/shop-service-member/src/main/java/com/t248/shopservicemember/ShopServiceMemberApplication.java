package com.t248.shopservicemember;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * ClassName ShopServiceMemberApplication
 * Description TODO
 * Author 水向南
 * Date 2020/4/1 16:58
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ShopServiceMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopServiceMemberApplication.class,args);
    }

}
