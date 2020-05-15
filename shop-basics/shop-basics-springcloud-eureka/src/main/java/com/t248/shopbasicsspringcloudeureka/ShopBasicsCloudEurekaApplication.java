package com.t248.shopbasicsspringcloudeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * ClassName ShopBasicsCloudEurekaApplication
 * Description TODO
 * Author 水向南
 * Date 2020/4/1 16:20
 */
@SpringBootApplication
@EnableEurekaServer
public class ShopBasicsCloudEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopBasicsCloudEurekaApplication.class,args);
    }
}
