package com.xjch.test.springcloud.hello.eureka.client.feign.controller;

import com.xjch.test.springcloud.hello.eureka.client.feign.ClientFeignRunApp;
import com.xjch.test.springcloud.hello.eureka.client.feign.api.HelloService;
import com.xjch.test.springcloud.hello.eureka.client.feign.service.HelloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings({"SpringJavaAutowiringInspection", "SpringAutowiredFieldsWarningInspection"})
@RestController
public class HelloController extends SpringBootServletInitializer {
    @Autowired
    HelloService helloService;

    @Autowired
    HelloServiceImpl helloServiceImpl;

    @RequestMapping("/hi/{path}")
    public String sayHi(@PathVariable String path, @RequestParam String name) {
        return helloServiceImpl.hiService(path, name);
    }

    @RequestMapping("/hi")
    public String sayHi(@RequestParam String name) {
        return helloService.sayHi(name);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ClientFeignRunApp.class);
    }
}