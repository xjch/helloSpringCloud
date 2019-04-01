package com.xjch.test.springcloud.hello.zookeeper.client.controller;

import com.xjch.test.springcloud.hello.zookeeper.client.service.AppClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.core.env.Environment;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SuppressWarnings("SpringJavaAutowiringInspection")
@RestController
public class HelloController{
    @Value("${spring.application.name:zookeeper-client}")
    private String appName;
    @Autowired
    private LoadBalancerClient loadBalancer;
    @Autowired
    private DiscoveryClient discovery;
    @Autowired
    private Environment env;
    @Autowired(required = false)
    private Registration registration;
    @Autowired
    private AppClientService appClientService;

    @RequestMapping("/hi")
    public String hi() {
        return "Hello World! from " + this.registration;
    }

    @RequestMapping("/")
    public ServiceInstance lb() {
        return this.loadBalancer.choose(this.appName);
    }

    @RequestMapping("/self")
    public String hiSelf() {
        return this.appClientService.hiService();
    }

    @RequestMapping("/myenv")
    public String env(@RequestParam("prop") String prop) {
        return this.env.getProperty(prop, "Not Found");
    }

    @RequestMapping("/getServices")
    public String discoveryClent() {
        List<String> serviceList = discovery.getServices();
        System.out.println("注册服务的数量>>>>>>>>>>>>>>>>>" + serviceList.size());
        for (String service : serviceList) {
            System.out.println("注册的服务>>>>>>" + service);
        }
        return "info";
    }

    @RequestMapping("/env")
    public String test() {
        String[] profiles = env.getActiveProfiles();
        System.out.println("profiles>>>>>>>" + profiles.length);
        for (String item : profiles) {
            System.out.println("item>>>>>>>>>>>>>>>" + item);
        }
        String name = env.getProperty("name");
        System.out.println(name);
        return "Hello," + name;
    }
}