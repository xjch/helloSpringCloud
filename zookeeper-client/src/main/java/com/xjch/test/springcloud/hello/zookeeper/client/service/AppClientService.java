package com.xjch.test.springcloud.hello.zookeeper.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AppClientService {
    @Autowired
    RestTemplate restTemplate;

    public String hiService()
    {
        String url="http://zookeeper-client/hi";
        return restTemplate.getForObject(url, String.class);
    }

    public String rt(String appName) {
        return this.restTemplate.getForObject("http://" + appName + "/hi", String.class);
    }
}
