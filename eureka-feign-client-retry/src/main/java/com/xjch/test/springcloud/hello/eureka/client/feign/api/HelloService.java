package com.xjch.test.springcloud.hello.eureka.client.feign.api;

import com.xjch.test.springcloud.hello.eureka.client.feign.service.ClientFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-provider1",fallback = ClientFeignFallback.class)
public interface HelloService {

    @RequestMapping(method = RequestMethod.GET, value = "/hi")
    String sayHi(@RequestParam("name") String name);

    @RequestMapping(method = RequestMethod.GET, value = "/user/findById")
    String findById(@RequestParam("id")String id);

}
