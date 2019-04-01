package com.xjch.test.springcloud.hello.client.stream.event.myevent;

import org.springframework.context.ApplicationEvent;

/**
 * 异步通知事件
 */
public class FeeResponseEvent extends ApplicationEvent {

    public FeeResponseEvent(Object source) {
        super(source);
    }
}
