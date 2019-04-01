package com.xjch.test.springcloud.hello.eureka.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    public String hiService(String provider,String name)
    {
        String url="http://service-provider"+provider+"/hi?name="+name;
        return restTemplate.getForObject(url, String.class);
    }

    @HystrixCommand(fallbackMethod = "hiError")// 断路器配置，当无法调用如下方法时，就会调用自定的hiError方法。
    public String hiHystrixService(String provider,String name)
    {
        String url="http://service-provider"+provider+"/hi?name="+name;
        String forString = restTemplate.getForObject(url, String.class);
        //下面的调用，如果服务费没有提供返回对象的服务，则服务调用的时候失败，进入断路器。
        String url2="http://service-provider"+provider+"/hio?name="+name;
        //ResponseEntity<Object> forEntity = restTemplate.getForEntity(url2, Object.class);
        Object forObject = restTemplate.getForObject(url2, Object.class);
        return forObject.toString();
    }
    public String hiError(String provider,String name)
    {
        return "hey " +name + ", there is some problem with hi page";
    }
}
