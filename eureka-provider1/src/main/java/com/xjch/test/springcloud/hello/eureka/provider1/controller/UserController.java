package com.xjch.test.springcloud.hello.eureka.provider1.controller;

import com.xjch.test.springcloud.hello.eureka.provider1.model.User;
import org.springframework.web.bind.annotation.PathVariable;
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
        return "这个是springcloud的客户端service-provider1----"+id;
    }

    @RequestMapping(value = "/getuser/{id}")
    public User getUserId(@PathVariable("id") Integer id) {
        System.out.println(">>>>>>>>/getuser/{id}"+id);
        if (id == 1) {
            return new User("张三", "男", 1);
        }else if (id ==2){
            return new User("李四", "男", 2);
        }
        return new User("王五", "男", 3);
    }

}
