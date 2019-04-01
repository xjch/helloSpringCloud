package com.xjch.test.springcloud.hello.eureka.config.server.jks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class JKSConfigServerRunApp {

    public static void main(String[] args) {
        SpringApplication.run(JKSConfigServerRunApp.class, args);
    }

}
