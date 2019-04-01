package com.xjch.test.springcloud.hello.client.hystrix.command;

import com.netflix.hystrix.HystrixCollapser;
import com.netflix.hystrix.HystrixCollapserKey;
import com.netflix.hystrix.HystrixCollapserProperties;
import com.netflix.hystrix.HystrixCommand;
import com.xjch.test.springcloud.hello.client.hystrix.model.User;
import com.xjch.test.springcloud.hello.client.hystrix.service.UserService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserCollapseCommand extends HystrixCollapser<List<User>,User,Integer> {
    private UserService userService;
    private List<Integer> ids;
    private Integer id;

    public UserCollapseCommand(UserService userService, Integer id) {
        super(Setter.withCollapserKey(HystrixCollapserKey.Factory.asKey("bookCollapseCommand")).andCollapserPropertiesDefaults(HystrixCollapserProperties.Setter().withTimerDelayInMilliseconds(100)));
        this.userService = userService;
        this.id = id;
    }

    @Override
    public Integer getRequestArgument() {
        return id;
    }

    @Override
    protected HystrixCommand<List<User>> createCommand(Collection<CollapsedRequest<User, Integer>> collapsedRequests) {
        List<Integer> ids = new ArrayList<>(collapsedRequests.size());
        ids.addAll(collapsedRequests.stream().map(CollapsedRequest::getArgument).collect(Collectors.toList()));
        UserBatchCacheCommand userBatchCacheCommand = new UserBatchCacheCommand(userService,ids);
        return userBatchCacheCommand;
    }

    @Override
    protected void mapResponseToRequests(List<User> batchResponse, Collection<CollapsedRequest<User, Integer>> collapsedRequests) {
        System.out.println("mapResponseToRequests");
        int count = 0;
        for (CollapsedRequest<User, Integer> collapsedRequest : collapsedRequests) {
            User book = batchResponse.get(count++);
            collapsedRequest.setResponse(book);
        }
    }


}
