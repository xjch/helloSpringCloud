package com.xjch.test.springcloud.hello.client.stream.event.api;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 费用事件发送器
 */
public interface SinkSender {
    String FEE="feeout";

    @Output("feeout")
    MessageChannel feeout();
}
