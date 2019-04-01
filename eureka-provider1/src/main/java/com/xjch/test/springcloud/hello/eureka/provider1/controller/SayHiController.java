package com.xjch.test.springcloud.hello.eureka.provider1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SayHiController{
    @Value("${server.port}")
    String port;

    @RequestMapping("/hio")
    public Object sayHiObject(String name) {
        Map<String,Object> map = new HashMap<>();
        String hi = "hi "+name+",i am provider1 from port:" +port;
        map.put("name",name);
        map.put("hi",hi);
        return map;
    }
}