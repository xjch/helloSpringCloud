package com.xjch.test.springcloud.hello.eureka.provider2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Provider2RunApp {

    public static void main(String[] args) {
        SpringApplication.run(Provider2RunApp.class, args);
    }

}
