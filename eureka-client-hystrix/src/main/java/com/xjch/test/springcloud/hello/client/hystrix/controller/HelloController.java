package com.xjch.test.springcloud.hello.client.hystrix.controller;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.xjch.test.springcloud.hello.client.hystrix.model.User;
import com.xjch.test.springcloud.hello.client.hystrix.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@RestController
public class HelloController{
    @Autowired
    HelloService helloService;

    @RequestMapping("/hi/{path}")
    public String sayHi(@PathVariable String path, @RequestParam String name) {
        return helloService.hiService(path, name);
    }

    @RequestMapping("/getuser")
    public User getUser() {
        return new User("张三", "男", 1);
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

    @RequestMapping("/getuser/catch/{id}")
    public User getUserCatch(@PathVariable("id") Integer id){
        User user=null;
        try {
            user = helloService.getUserCatch(id);
        }catch (Exception e){

        }
        return user;
    }

    @RequestMapping("/getuser/bycatch/{id}")
    public User getUserByCatch(@PathVariable("id") Integer id){
        HystrixRequestContext.initializeContext();
        //第一次发起请求
        User user1 = helloService.getUserByCatch(id);
        //参数和上次一致，使用缓存数据
        User user2 = helloService.getUserByCatch(id);
        //参数不一致，发起新请求
        User user3 = helloService.getUserByCatch(id+1);
        return user1;
    }

    @RequestMapping("/getuser/catch/remove/{id}")
    public User getUserByCatchAndRemove(@PathVariable("id") Integer id){
        HystrixRequestContext.initializeContext();
        //第一次发起请求
        User user1 = helloService.getUserByCatchKey(id);
        //清除缓存
        User userClear = helloService.getUserCacheRemove(id);
        //缓存被清除，重新发起请求
        User user2 = helloService.getUserByCatchKey(id);
        //参数一致，使用缓存数据
        User user3 = helloService.getUserByCatchKey(id);
        return user1;
    }

    @RequestMapping("/getuser/test")
    public User getUserTest(){
        User user=null;
        try {
            user = helloService.getUserTest();
        }catch (Exception e){

        }
        return user;
    }

    @RequestMapping("/getuser/async")
    public User getUserAsync(){
        User user=null;
        try {
            Future<User> userFuture = helloService.getUserAsync();
            user = userFuture.get();
        }catch (Exception e){

        }
        return user;
    }

    @RequestMapping("/sayhi/{path}")
    public String sayHiHystrix(@PathVariable String path, @RequestParam String name) {
        return helloService.hiHystrixService(path, name);
    }
}