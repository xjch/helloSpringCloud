package com.xjch.test.springcloud.hello.eureka.provider2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class UserController {

    @RequestMapping("/user/findById")
    public String findById(@RequestParam("id")String id){
        int i = new Random().nextInt(3000);
        try {
            System.out.println("client线程休眠时间："+i);
            Thread.sleep(i);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        return "这个是springcloud的客户端service-provider2----"+id;
    }


}
