package com.xjch.test.springcloud.hello.client.hystrix.service;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.xjch.test.springcloud.hello.client.hystrix.command.UserCacheCommand;
import com.xjch.test.springcloud.hello.client.hystrix.command.UserCommand;
import com.xjch.test.springcloud.hello.client.hystrix.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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

    public User getUserTest()  throws ExecutionException, InterruptedException {
        UserCommand userCommand = new UserCommand(com.netflix.hystrix.HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("")), restTemplate);
        //同步调用
//        User user1 = userCommand.execute();
//        return user1;
        //异步调用
        Future<User> queue = userCommand.queue();
        User user = queue.get();
        return user;
    }

    public User getUserCatch(Integer id)  throws ExecutionException, InterruptedException {
        HystrixCommandKey commandKey = HystrixCommandKey.Factory.asKey("commandKey");
        HystrixRequestContext.initializeContext();

        UserCacheCommand userCommand1 = new UserCacheCommand(
                com.netflix.hystrix.HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("")),
                restTemplate,
                id);
        //同步调用
        User user1 = userCommand1.execute();

        UserCacheCommand userCommand2 = new UserCacheCommand(
                com.netflix.hystrix.HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("")),
                restTemplate,
                id);
        //同步调用
        User user2 = userCommand2.execute();
//
//        UserCacheCommand userCommand3 = new UserCacheCommand(
//                com.netflix.hystrix.HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("")),
//                restTemplate,
//                id);
//        //同步调用
//        User user3 = userCommand3.execute();

        return user1;
        //异步调用
//        Future<User> queue = userCommand.queue();
//        User user = queue.get();
//        return user;
    }

    //异步调用
    @HystrixCommand(fallbackMethod = "hiError")
    public Future<User> getUserAsync() {
        return new AsyncResult<User>() {
            @Override
            public User invoke() {
                return restTemplate.getForObject("http://client-hystrix/getuser", User.class);
            }
        };
    }

    @CacheResult(cacheKeyMethod = "getCacheKey2")
    @HystrixCommand
    public User getUserByCatch(Integer id) {
        String url = "http://client-hystrix/getuser/"+id;
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }

    public String getCacheKey2(Integer id) {
        return String.valueOf(id);
    }

    @CacheResult
    @HystrixCommand
    public User getUserByCatchKey(@CacheKey Integer id) {
        String url = "http://client-hystrix/getuser/"+id;
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }

    @CacheRemove(commandKey = "test6")
    @HystrixCommand
    public User getUserCacheRemove(@CacheKey Integer id) {
        return null;
    }
}
