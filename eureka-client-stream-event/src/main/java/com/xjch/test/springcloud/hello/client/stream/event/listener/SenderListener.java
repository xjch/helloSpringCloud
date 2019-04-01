package com.xjch.test.springcloud.hello.client.stream.event.listener;

import com.xjch.test.springcloud.hello.client.stream.event.myevent.FeeResponseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Source.class)
public class SenderListener implements ApplicationListener<FeeResponseEvent> {

    @Autowired
    private MessageChannel output;

    /**
     * 发送事件消息到消息队列中
     * @param event 费用事件
     */
    @StreamListener(Source.OUTPUT)
    private void sendMessageToWorker(FeeResponseEvent event){
        output.send(MessageBuilder.withPayload(event.getSource()).build());
        System.out.println("发送成功："+event.getSource());

    }

    /**
     * 当有发布事件发生时，执行此方法
     * @param feeResponseEvent 费用自定义事件
     */
    @Async
    @Override
    public void onApplicationEvent(FeeResponseEvent feeResponseEvent) {
        this.sendMessageToWorker(feeResponseEvent);
    }
}