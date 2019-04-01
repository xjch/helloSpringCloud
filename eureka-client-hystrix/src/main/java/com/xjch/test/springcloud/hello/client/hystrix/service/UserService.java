package com.xjch.test.springcloud.hello.client.hystrix.service;

import com.xjch.test.springcloud.hello.client.hystrix.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    @Autowired
    RestTemplate restTemplate;

    public User getUser(Integer id){
        String url = "http://client-hystrix/getuser/"+id;
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }

    public List<User> getUsers(List<Integer> ids) {
        System.out.println("getUsers---------"+ids+"Thread.currentThread().getName():" + Thread.currentThread().getName());
        String idsStr = listToString(ids);
        String url = "http://client-hystrix/getusers?ids="+idsStr;
        User[] users = restTemplate.getForObject(url, User[].class);
        return Arrays.asList(users);
    }

    private static  <T extends  Object>  String listToString(List<T> list){
        StringBuilder sb=new StringBuilder();
        for(T item : list){
            if(sb.length()==0) {
                sb.append(item.toString());
            } else {
                sb.append(","+item.toString());
            }
        }
        return sb.toString();
    }
}
