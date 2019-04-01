package com.xjch.test.springcloud.hello.eureka.config.client.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
// tells spring cloud bus to scan for custom events in the current package and subpackages
@RemoteApplicationEventScan(basePackages = "com.xjch.test.springcloud.hello.eureka.config.client.kafka")
public class ConfigKafkaClientRunApp {

    public static void main(String[] args) {
        SpringApplication.run(ConfigKafkaClientRunApp.class, args);
    }

}
