# helloSpringCloud
全局项目设置免密提交git库
git config --global credential.helper store
单个项目设置
git config credential.helper store

项目
<groupId>com.xjch.test.springcloud</groupId>
<artifactId>helloSpringCloud</artifactId>
com.xjch.test.springcloud.hello

模块
<groupId>com.xjch.test.springcloud</groupId>
<artifactId>eureka-server</artifactId>
com.xjch.test.springcloud.hello.eureka.server
http://localhost:8761/

<groupId>com.xjch.test.springcloud</groupId>
<artifactId>eureka-server2</artifactId>
com.xjch.test.springcloud.hello.eureka.server
http://localhost:8759/
两个服务端互相注册，做高可用


<groupId>com.xjch.test.springcloud</groupId>
<artifactId>eureka-provider1</artifactId>
com.xjch.test.springcloud.hello.eureka.provider1
ProviderRunApp
UserController 
http://localhost:8763/hio?name=xujiangchuan1
http://localhost:8763/hi?name=xujiangchuan1
http://localhost:8763/user/findById?id=123

<groupId>com.xjch.test.springcloud</groupId>
<artifactId>eureka-provider2</artifactId>
com.xjch.test.springcloud.hello.eureka.provider2
ProviderRunApp
UserController 
http://localhost:8765/hi?name=xujiangchuan2
http://localhost:8765/user/findById?id=123

<groupId>com.xjch.test.springcloud</groupId>
<artifactId>eureka-consumer</artifactId>
com.xjch.test.springcloud.hello.eureka.consumer
ConsumerRunApp
http://localhost:8764/hi/1?name=xujiangchuan1
http://localhost:8764/hi/2?name=xujiangchuan2
http://localhost:8764/sayhi/1?name=xujiangchuan1
http://localhost:8764/sayhi/2?name=xujiangchuan2

<groupId>com.xjch.test.springcloud</groupId>
<artifactId>eureka-discovery-client</artifactId>
com.xjch.test.springcloud.hello.eureka.client
ConsumerRunApp
http://localhost:8766/hi/1?name=xujiangchuan1
http://localhost:8766/hi/2?name=xujiangchuan2

<groupId>com.xjch.test.springcloud</groupId>
<artifactId>eureka-feign-client</artifactId>
com.xjch.test.springcloud.hello.eureka.client.feign
ClientFeignRunApp
http://localhost:8768/hi/1?name=xujiangchuan1
http://localhost:8768/hi/2?name=xujiangchuan2
http://localhost:8768/hi?name=xujiangchuan

<groupId>com.xjch.test.springcloud</groupId>
<artifactId>eureka-feign-client-retry</artifactId>
com.xjch.test.springcloud.hello.eureka.client.feign
ClientFeignRunApp
http://localhost:8770/hi/1?name=xujiangchuan1
http://localhost:8770/hi/2?name=xujiangchuan2
http://localhost:8770/hi?name=xujiangchuan
http://localhost:8770/user/findById?id=123


<groupId>com.xjch.test.springcloud</groupId>
<artifactId>eureka-config-server</artifactId>
com.xjch.test.springcloud.hello.eureka.config.server
ConfigServerRunApp

http://localhost:8888/application/dev/master
http://localhost:8888/application-dev/config-client
http://localhost:8888/config-client/application-dev
http://localhost:8888/config-client/application-dev2/master

http://localhost:8888/config-client/
http://localhost:8888/actuator/bus-refresh
http请求地址和资源文件映射如下: 
* /{application}/{profile}[/{label}] 
* /{application}-{profile}.yml 
* /{label}/{application}-{profile}.yml 
* /{application}-{profile}.properties 
* /{label}/{application}-{profile}.properties


<groupId>com.xjch.test.springcloud</groupId>
<artifactId>eureka-config-client</artifactId>
com.xjch.test.springcloud.hello.eureka.config.client
ConfigClientRunApp

http://localhost:8887/user 
http://localhost:8887/getInfo 
手动刷新配置
http://localhost:8887/actuator/bus-refresh

<groupId>com.xjch.test.springcloud</groupId>
<artifactId>eureka-config-client-bus</artifactId>
com.xjch.test.springcloud.hello.eureka.config.client.bus
ConfigBusClientRunApp

http://localhost:8887/user 
http://localhost:8887/getInfo 
手动刷新配置
post json方式请求 http://localhost:8887/actuator/bus-refresh

基于eureka-config-server-jks加入kafka
<groupId>com.xjch.test.springcloud</groupId>
<artifactId>eureka-config-server-kafka</artifactId>
com.xjch.test.springcloud.hello.eureka.config.server.kafka
ConfigKafkaServerRunApp
http://localhost:8886/config-client/dev/master
http://localhost:8886/encrypt/status

<groupId>com.xjch.test.springcloud</groupId>
<artifactId>eureka-config-client-kafka</artifactId>
com.xjch.test.springcloud.hello.eureka.config.client.kafka
ConfigKafkaClientRunApp

http://localhost:8887/user 
http://localhost:8887/getInfo 
手动刷新配置
post json方式请求 http://localhost:8887/actuator/bus-refresh
http://localhost:8887/actuator/beans

安全config-server
https://www.cnblogs.com/leeSmall/p/8878091.html
<groupId>com.xjch.test.springcloud</groupId>
<artifactId>eureka-config-server-jks</artifactId>
com.xjch.test.springcloud.hello.eureka.config.server.jks
JKSConfigServerRunApp

参考样例
keytool -genkeypair -alias mytestkey -keyalg RSA -dname "CN=Web Server,OU=Unit,O=Organization,L=City,S=State,C=US" -keypass changeit -keystore server.jks -storepass studyjava
执行命令
keytool -genkeypair -alias xjchtestkey -keyalg RSA -dname "CN=Web Server,OU=Xjch,O=Organization,L=City,S=province,C=china" -keypass xjchgithub -keystore server.jks -storepass cloudstudy

http://localhost:8886/config-client/dev/master
http://localhost:8886/encrypt/status
http://localhost:8886/encrypt
http://localhost:8886/decrypt
使用postman等工具，用post方式请求http://localhost:9999/encrypt接口，参数类型选择raw
(如果名文中含有特殊字符，则还需要将text这里选择为 plain/text ),输入要加密的明文，得到的结果就是加密后的密文：
用post方式请求http://localhost:9999/decrypt 接口,参数类型选择raw,输入密文，得到的结果就是解密后的明文：

基于rabbitmq
<groupId>com.xjch.test.springcloud</groupId>
<artifactId>eureka-client-stream</artifactId>
com.xjch.test.springcloud.hello.client.stream
StreamClientRunApp

http://localhost:8769/

基于rabbitmq
<groupId>com.xjch.test.springcloud</groupId>
<artifactId>eureka-client-stream-send</artifactId>
com.xjch.test.springcloud.hello.client.stream.send
StreamSendClientRunApp

http://localhost:8771/

基于rabbitmq
<groupId>com.xjch.test.springcloud</groupId>
<artifactId>eureka-client-stream-event</artifactId>
com.xjch.test.springcloud.hello.client.stream.event
StreamEventClientRunApp

http://localhost:8773/hi

/actuator/beans
使用ApplicationEvent和Listener快速实现业务解耦
https://www.jianshu.com/p/ef2cee8c5dd1
https://blog.csdn.net/kisscatforever/article/details/80366727

<groupId>com.xjch.test.springcloud</groupId>
<artifactId>zookeeper-client</artifactId>
com.xjch.test.springcloud.hello.zookeeper.client
ZKClientRunApp

http://localhost:8769/

<groupId>com.xjch.test.springcloud</groupId>
<artifactId>eureka-client-zuul</artifactId>
com.xjch.test.springcloud.hello.client.zuul
ClientZuulRunApp

http://localhost:8769/

http://localhost:8750/service-provider1/hi?name=xujiangchuan1
http://localhost:8750/service-provider2/hi?name=xujiangchuan2


<groupId>com.xjch.test.springcloud</groupId>
<artifactId>eureka-client-hystrix</artifactId>
com.xjch.test.springcloud.hello.client.hystrix
ClientHystrixRunApp

http://localhost:8768/getuser
http://localhost:8768/getuser/test
http://localhost:8768/getuser/async

springcloud（一）---快速搭建入门级demo
https://blog.csdn.net/weixin_38023579/article/details/81328524
https://blog.csdn.net/zhou199252/article/details/80745151
https://blog.csdn.net/kisscatforever/article/details/80045521

https://blog.csdn.net/forezp/article/details/70148833

springcloud 全流程入门教程
https://blog.csdn.net/kisscatforever/article/list/2?t=1&
https://blog.csdn.net/kisscatforever/article/details/80045521

https://segmentfault.com/a/1190000011752466

ZooKeeper 入门
https://www.cnblogs.com/powercto/p/6844798.html

双击bin/zkServer.cmd启动ZooKeeper启动服务端。
bin\zkCli.cmd -server 127.0.0.1:2181启动客户端操作。
使用zkCli创建配置信息
https://blog.csdn.net/liusanchun/article/details/78597644
create /config ""
create /config/xjch ""
create /config/xjch/name "default"
create /config/xjch-dev ""
create /config/xjch-dev/name "dev"
create /config/xjch-test ""
create /config/xjch-test/name "test"

set /config/xjch/name "default1"
set /config/xjch-dev/name "dev1"

@EnableEurekaClient只能用于Eureka，@EnableDiscoveryClient能用于zookeeper等其他注册组件。


搭建集群式架构
前端选型
	两个选择：
	1、	WebAPI + Dapper + Vue2.0 + Element-UI
		Vue（国内开发者尤雨溪） + element（饿了么组件库） + webpack + nodejs
	2、react + redux +react-router +es6 +webpack3+axios+eslint
		React(facebook) + ant design(蚂蚁金服组件库) + webpack + nodej
后端选型
springBoot +	springCloud + 
Spring Cloud Zookeeper + zokeerper + 
Ribbon + spring-cloud-openfeign + 
Hystrix + 
SpringCloud config + 
Spring Cloud Bus + kafka + SpringCloud Stream + 
SpringCloud Gateway  + 
Spring Data LDAP + openLDAP or ad（微软）
Spring Data Redis + redis + 
Spring Data Elasticsearch + Elasticsearch
spring-cloud-security + 
spring integration + 


spring-cloud-cluster?
spring-cloud-commons?
dubbo