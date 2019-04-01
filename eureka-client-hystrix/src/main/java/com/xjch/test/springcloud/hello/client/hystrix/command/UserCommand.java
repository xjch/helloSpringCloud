package com.xjch.test.springcloud.hello.client.hystrix.command;

import com.netflix.hystrix.HystrixCommand;
import com.xjch.test.springcloud.hello.client.hystrix.model.User;
import org.springframework.web.client.RestTemplate;


public class UserCommand extends HystrixCommand<User> {
    private RestTemplate restTemplate;

    public UserCommand(Setter setter, RestTemplate restTemplate) {
        super(setter);
        this.restTemplate = restTemplate;
    }

    @Override
    protected User getFallback() {
        return new User("张三", "男", 18);
    }

    @Override
    protected User run() throws Exception {
        return restTemplate.getForObject("http://client-hystrix/getuser", User.class);
    }

}
