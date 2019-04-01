package com.xjch.test.springcloud.hello.client.stream.event.controller;

import com.xjch.test.springcloud.hello.client.stream.event.service.FeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HelloController {
    private Random random = new Random(10);
    @Autowired
    FeeServiceImpl feeService;

    @RequestMapping("/hi")
    public String sayHi(@RequestParam String name) {
        String hiName = name+ random.nextInt(1000);
        feeService.feeMessage(hiName);
        return "hi "+hiName+",i am stream-client-event ";
    }
}
