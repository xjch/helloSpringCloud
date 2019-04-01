package com.xjch.test.springcloud.hello.client.hystrix.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.xjch.test.springcloud.hello.client.hystrix.model.User;
import com.xjch.test.springcloud.hello.client.hystrix.service.UserService;

import java.util.ArrayList;
import java.util.List;


public class UserBatchCacheCommand extends HystrixCommand<List<User>> {
    private UserService userService;
    private List<Integer> ids;

    public UserBatchCacheCommand(UserService userService, List<Integer> ids) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("CollapsingGroup"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("CollapsingKey")));
        this.userService = userService;
        this.ids = ids;
    }

    @Override
    protected List<User> getFallback() {
        Throwable executionException = getExecutionException();
        System.out.println("executionException getMessage"+executionException.getMessage());
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("张三1", "男1", 11));
        users.add(new User("李四2", "男2", 22));
        users.add(new User("王五3", "女3", 33));
        users.add(new User("ids4", "man4", 104));
        return users;
    }

    @Override
    protected List<User> run() throws Exception {
        return userService.getUsers(ids);
    }

}
