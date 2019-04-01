package com.xjch.test.springcloud.hello.client.zuul;

import com.xjch.test.springcloud.hello.client.zuul.filter.PermisFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
@EnableZuulProxy //开启Zuul的API网关服务功能
public class ClientZuulRunApp {

    public static void main(String[] args) {
        SpringApplication.run(ClientZuulRunApp.class, args);
    }

    @Bean
    PermisFilter permisFilter() {
        return new PermisFilter();
    }
}
