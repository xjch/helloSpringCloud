package com.xjch.test.springcloud.hello.client.stream.event.listener;

import com.xjch.test.springcloud.hello.client.stream.event.myevent.FeeResponseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

//@Component
public class AnnotationListener {
    @Autowired
    private MessageChannel output;

    /**
     * 注册监听实现方法
     * 发送事件消息到消息队列中
     * @param event 费用事件
     */
//    @EventListener
    private void sendMessageToWorker(FeeResponseEvent event){
        output.send(MessageBuilder.withPayload(event.getSource()).build());
        System.out.println("发送成功："+event.getSource());

    }
}
