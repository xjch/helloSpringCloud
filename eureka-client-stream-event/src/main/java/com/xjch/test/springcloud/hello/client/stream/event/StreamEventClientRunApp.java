package com.xjch.test.springcloud.hello.client.stream.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableDiscoveryClient
@SpringBootApplication
@EnableAsync
public class StreamEventClientRunApp {

    public static void main(String[] args) {
        SpringApplication.run(StreamEventClientRunApp.class, args);
    }

}
