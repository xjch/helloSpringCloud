package com.xjch.test.springcloud.hello.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@EnableEurekaClient只能用于Eureka，@EnableDiscoveryClient能用于zookeeper等其他注册组件。
@EnableDiscoveryClient
@SpringBootApplication
public class ClientRunApp {

    public static void main(String[] args) {
        SpringApplication.run(ClientRunApp.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate()
    {
        return new RestTemplate();
    }

}
