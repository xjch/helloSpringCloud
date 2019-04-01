package com.xjch.test.springcloud.hello.client.hystrix.controller;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.xjch.test.springcloud.hello.client.hystrix.command.UserCollapseCommand;
import com.xjch.test.springcloud.hello.client.hystrix.model.User;
import com.xjch.test.springcloud.hello.client.hystrix.service.HelloService;
import com.xjch.test.springcloud.hello.client.hystrix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/getusers")
    public List<User> getUsers(@RequestParam String ids) {
        System.out.println("ids>>>>>>>>>>>>>>>>>>>>>" + ids);
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("张三", "男", 1));
        users.add(new User("李四", "男", 2));
        users.add(new User("王五", "女", 3));
        users.add(new User("ids", "man", 100));
        return users;
    }

    @RequestMapping("/getusers/batch")
    @ResponseBody
    public String test7() throws ExecutionException, InterruptedException {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        UserCollapseCommand bc1 = new UserCollapseCommand(userService, 1);
        UserCollapseCommand bc2 = new UserCollapseCommand(userService, 2);
        UserCollapseCommand bc3 = new UserCollapseCommand(userService, 3);
        UserCollapseCommand bc4 = new UserCollapseCommand(userService, 4);
        Future<User> q1 = bc1.queue();
        Future<User> q2 = bc2.queue();
        Future<User> q3 = bc3.queue();
        User user1 = q1.get();
        User user2 = q2.get();
        User user3 = q3.get();
        Thread.sleep(3000);
        Future<User> q4 = bc4.queue();
        User user4 = q4.get();
        System.out.println("book1>>>"+user1);
        System.out.println("book2>>>"+user2);
        System.out.println("book3>>>"+user3);
        System.out.println("book4>>>"+user4);
        context.close();
        return "ok";
    }
}