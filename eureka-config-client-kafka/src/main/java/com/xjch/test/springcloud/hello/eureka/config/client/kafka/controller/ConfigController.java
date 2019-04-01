package com.xjch.test.springcloud.hello.eureka.config.client.kafka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {
    @Value("${shoujin}")
    private String shoujin="default";

    @Value("${password}")
    private String password="defaultPassword";

    @Value("${user.userName}")
    private String userName="default_test";
    @Value("${user.sex}")
    private String sex="default_man";
    @Value("${user.age}")
    private Integer age=0;

    @RequestMapping("/getInfo")
    public String getInfo(){
        return  "shoujin:"+shoujin+" password:"+password;
    }
    @RequestMapping(value = "/user")
    public String getUserInfo(){
        return "userName:"+userName+" sex:"+sex+" age:"+age;
    }
}