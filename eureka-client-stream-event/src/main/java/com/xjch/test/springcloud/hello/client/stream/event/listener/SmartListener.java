package com.xjch.test.springcloud.hello.client.stream.event.listener;

import com.xjch.test.springcloud.hello.client.stream.event.myevent.FeeResponseEvent;
import com.xjch.test.springcloud.hello.client.stream.event.service.FeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

//@Component
public class SmartListener implements SmartApplicationListener {

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

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        //只有UserRegisterEvent监听类型才会执行下面逻辑
        return aClass == FeeResponseEvent.class;
    }

    @Override
    public boolean supportsSourceType(Class<?> aClass) {
        //只有在UserService内发布的UserRegisterEvent事件时才会执行下面逻辑
        return aClass == FeeServiceImpl.class;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        //转换事件类型
        if (applicationEvent instanceof FeeResponseEvent) {
            this.sendMessageToWorker((FeeResponseEvent) applicationEvent);
        }
    }

    /**
     * 解决执行监听的顺序问题，return的数值越小证明优先级越高，执行顺序越靠前
     * @return 优先级
     */
    @Override
    public int getOrder() {
        return 10;
    }
}