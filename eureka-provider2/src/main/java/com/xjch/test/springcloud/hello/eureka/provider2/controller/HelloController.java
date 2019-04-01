package com.xjch.test.springcloud.hello.eureka.provider2.controller;

import com.xjch.test.springcloud.hello.eureka.provider2.Provider2RunApp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController extends SpringBootServletInitializer {

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String sayHi(String name) {
        return "hi "+name+",i am provider2 from port:" +port;
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Provider2RunApp.class);
    }
}