package com.xjch.test.springcloud.hello.client.hystrix.command;

import com.netflix.hystrix.HystrixCommand;
import com.xjch.test.springcloud.hello.client.hystrix.model.User;
import org.springframework.web.client.RestTemplate;


public class UserCacheCommand extends HystrixCommand<User> {
    private RestTemplate restTemplate;
    private Integer id;

    public UserCacheCommand(Setter setter, RestTemplate restTemplate, Integer id) {
        super(setter);
        this.restTemplate = restTemplate;
        this.id = id;
    }

    @Override
    protected String getCacheKey() {
        return String.valueOf(id);
    }

    @Override
    protected User getFallback() {
        Throwable executionException = getExecutionException();
        System.out.println("executionException getMessage"+executionException.getMessage());
        return new User("张三", "男", 16);
    }

    @Override
    protected User run() throws Exception {
        String url = "http://client-hystrix/getuser/"+id;
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }

}
