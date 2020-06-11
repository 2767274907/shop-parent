package com.t248;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName ShopServiceWeixinApplication
 * Description TODO
 * Author 水向南
 * Date 2020/4/1 16:55
 */
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2Doc
@EnableFeignClients
public class WeiXinImplApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeiXinApiApplication.class,args);
    }

}
