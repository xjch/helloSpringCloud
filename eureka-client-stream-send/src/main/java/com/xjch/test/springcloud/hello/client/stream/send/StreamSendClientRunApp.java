package com.xjch.test.springcloud.hello.client.stream.send;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class StreamSendClientRunApp {

    public static void main(String[] args) {
        SpringApplication.run(StreamSendClientRunApp.class, args);
    }

}
