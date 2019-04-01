package com.xjch.test.springcloud.hello.eureka.client.feign.controller;

import com.xjch.test.springcloud.hello.eureka.client.ClientRunApp;
import com.xjch.test.springcloud.hello.eureka.client.feign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController extends SpringBootServletInitializer {
    @Autowired
    HelloService helloService;

    @RequestMapping("/hi/{path}")
    public String sayHi(@PathVariable String path, @RequestParam String name) {
        return helloService.hiService(path, name);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ClientRunApp.class);
    }
}