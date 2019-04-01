package com.xjch.test.springcloud.hello.eureka.provider1.controller;

import com.xjch.test.springcloud.hello.eureka.provider1.Provider1RunApp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController extends SpringBootServletInitializer {

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String sayHi(String name) {
        return "hi "+name+",i am provider1 from port:" +port;
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Provider1RunApp.class);
    }
}