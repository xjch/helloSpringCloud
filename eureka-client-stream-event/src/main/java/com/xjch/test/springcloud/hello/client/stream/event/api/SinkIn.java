package com.xjch.test.springcloud.hello.client.stream.event.api;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;


public interface SinkIn {
    String INPUT = "feein";

    @Input("feein")
    SubscribableChannel feein();
}

