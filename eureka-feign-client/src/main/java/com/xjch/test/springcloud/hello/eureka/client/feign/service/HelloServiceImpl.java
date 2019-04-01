package com.xjch.test.springcloud.hello.eureka.client.feign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("helloService")
public class HelloServiceImpl {
    @Autowired
    RestTemplate restTemplate;

    public String hiService(String provider,String name)
    {
        String url="http://service-provider"+provider+"/hi?name="+name;
        return restTemplate.getForObject(url, String.class);
    }
}
