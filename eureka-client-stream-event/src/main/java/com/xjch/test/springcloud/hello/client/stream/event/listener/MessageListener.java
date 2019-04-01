package com.xjch.test.springcloud.hello.client.stream.event.listener;

import com.xjch.test.springcloud.hello.client.stream.event.myevent.FeeResponseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

//@Component
public class MessageListener implements ApplicationListener {
    @Autowired
    private MessageChannel output;
    /**
     * 发送事件消息到消息队列中
     * @param event 费用事件
     */
    private void sendMessageToWorker(FeeResponseEvent event){
        output.send(MessageBuilder.withPayload(event.getSource()).build());
        System.out.println("发送成功："+event.getSource());

    }
//    @Async
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof FeeResponseEvent) {
            //做处理
            this.sendMessageToWorker((FeeResponseEvent)applicationEvent);
        }
    }
}
