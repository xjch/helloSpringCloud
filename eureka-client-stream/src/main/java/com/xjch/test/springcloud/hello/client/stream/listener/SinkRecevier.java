package com.xjch.test.springcloud.hello.client.stream.listener;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class SinkRecevier {
    @StreamListener(Sink.INPUT)
    public void receive(Object payload){
        System.out.println("接收到消息:"+payload);
    }
}
