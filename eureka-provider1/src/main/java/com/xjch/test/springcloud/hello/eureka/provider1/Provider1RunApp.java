package com.xjch.test.springcloud.hello.eureka.provider1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Provider1RunApp {

    public static void main(String[] args) {
        SpringApplication.run(Provider1RunApp.class, args);
    }

}
