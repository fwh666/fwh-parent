# 关于fwh-parent：
## 背景：
- 开始只是重写spring-cloud2.0版本的组件功能。
- 在码云上已经创建了一大部分代码,但相比GitHub的知名度还是转移过来.
- 本打算全部import过来,想着熟悉的角度还是重新review一遍.
- 之前是用的spring-boot1.x版本。现在使用2.x版本重新开发
- 后续衍生思想把所有的Java技术案例整合一起。

## 分支介绍：
- dev-20210110:
    - 此分支综合所有继续开始的。之前没做分支，现在开始按日期迭代内容。
    - 当前版本：JDK8、springboot2.0.0.RELEASE、springCloud:Hoxton.SR1、
    - 后续迭代高版本

## 模块介绍：
- fwh-algorithm     算法
- fwh-base
  - fwh-annotation  自定义注解
  - fwh-collection  集合
  - fwh-designPattern 设计模式
  - fwh-encryption  加解密
  - fwh-exception   异常
  - fwh-lock        锁
  - fwh-reflection  反射
  - fwh-thread      线程
- fwh-cloud         spring-cloud组件
  - fwh-feign
  - fwh-gateway
  - fwh-nacos
  - fwh-oauth
  - fwh-ribbon
  - fwh-seata
  - fwh-sentinel
  - fwh-swagger
  - fwh-web
- fwh-common      基础工具类等
- fwh-db
  - fwh-elasticsearch 搜索
  - fwh-mongodb     文档模式存储
  - fwh-mybatis
  - fwh-mysql
  - fwh-sharding    分库分表
- fwh-distributed   分布式
  - fwh-dubbo       分布式RPC框架
  - fwh-mq          分布式消息中间件
  - fwh-netty       高性能通信框架
  - fwh-redis       分布式缓存
  - fwh-zookeeper   分布式注册中心
- fwh-spring        spring框架
  - fwh-aop
  - fwh-ioc
  - fwh-mvc
  - fwh-transaction
- fwh-test          单元测试功能
- fwh-websocket

## 版本介绍:
- 一套： 
    - springboot: 2.0.6.RELEASE   
    - springCloud:Finchley.SR4
- 二套：
    - springboot: 2.2.0.RELEASE
    - springCloud:Hoxton.SR1
- 三套：
    - springboot：2.4.1
    - springcloud:2020.0.0-RC1
## 模块介绍：
- fwh-base:
    - 自定义注解
    - 集合
    - 锁机制
    - 反射
    - 线程
    
## 端口号：
- web:  8080/9090
- mongodb: 8180
- gateway: 8010
- ribbon: 8181
- feign: 8182
- nacos-config: 8183
- annotation: 8184
- sentinel: 8185
- seata: 8186

- oauth: 独立的模块-整合密码模式、授权码模式、JWT存储 

## 问题记录：
- 网关请求一直报错404？
    - 试错原因：boot和cloud的版本导致
    - 问题版本：
        - boot: 2.2.0.RELEASE
        - cloud：Hoxton.SR1
    - 正常版本：
        - boot: 2.1.6.RELEASE 
        - cloud: Greenwich.SR3