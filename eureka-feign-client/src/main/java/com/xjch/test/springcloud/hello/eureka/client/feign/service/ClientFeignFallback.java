package com.xjch.test.springcloud.hello.eureka.client.feign.service;

import com.xjch.test.springcloud.hello.eureka.client.feign.api.HelloService;
import org.springframework.stereotype.Component;

@Component
public class ClientFeignFallback implements HelloService{

    @Override
    public String sayHi(String name){
        return "调用service-provider服务超时，调用方法 sayHi(name)-name值为"+name;
    }
}
