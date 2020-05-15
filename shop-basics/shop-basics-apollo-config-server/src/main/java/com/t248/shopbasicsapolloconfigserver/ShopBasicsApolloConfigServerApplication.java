package com.t248.shopbasicsapolloconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * ClassName ShopBasicsApolloConfigServerApplication
 * Description TODO
 * Author 水向南
 * Date 2020/4/1 16:28
 */
@SpringBootApplication
@EnableEurekaServer
public class ShopBasicsApolloConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopBasicsApolloConfigServerApplication.class,args);
    }

}
