package com.xjch.test.springcloud.hello.eureka.config.client.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ConfigBusClientRunApp {

    public static void main(String[] args) {
        SpringApplication.run(ConfigBusClientRunApp.class, args);
    }

}
