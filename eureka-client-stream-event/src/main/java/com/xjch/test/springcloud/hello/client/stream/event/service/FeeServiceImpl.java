package com.xjch.test.springcloud.hello.client.stream.event.service;

import com.xjch.test.springcloud.hello.client.stream.event.myevent.FeeResponseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class FeeServiceImpl {
    @Autowired
    ApplicationContext applicationContext;
    /**
     * 发布事件
     */
    public void feeMessage(String name) {
        FeeResponseEvent event = new FeeResponseEvent(name);
        applicationContext.publishEvent(event);
    }
}
