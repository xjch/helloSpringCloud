package com.xjch.test.springcloud.hello.client.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class StreamClientRunApp {

    public static void main(String[] args) {
        SpringApplication.run(StreamClientRunApp.class, args);
    }

}
