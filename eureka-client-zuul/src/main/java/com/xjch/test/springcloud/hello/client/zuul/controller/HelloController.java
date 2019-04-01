package com.xjch.test.springcloud.hello.client.zuul.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/local")
    public String hello() {
        return "hello zuul api gateway";
    }
}
