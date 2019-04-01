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
post http://localhost:8887/actuator/bus-refresh


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

<groupId>com.xjch.test.springcloud</groupId>
<artifactId>zookeeper-client</artifactId>
com.xjch.test.springcloud.hello.zookeeper.client
ZKClientRunApp

http://localhost:8769/
秘钥生成命令
keytool -genkeypair -alias xjchtestkey -keyalg RSA -dname "CN=Web Server,OU=Xjch,O=Organization,L=City,S=province,C=china" -keypass xjchgithub -keystore server.jks -storepass cloudstudy

