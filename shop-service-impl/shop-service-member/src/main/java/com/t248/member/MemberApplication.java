package com.t248.member;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
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
@EnableSwagger2Doc
@EnableFeignClients(basePackages = {"com.t248.service"})
@MapperScan(basePackages = "com.t248.member.mapper")
public class MemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class,args);
    }


}
