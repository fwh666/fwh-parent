# fwh-parent
spring-cloud-demo    
## Reason: 
- 一直想着整一套cloud全家桶模块.
- 在码云上已经创建了一大部分代码,但相比GitHub的知名度还是转移过来.
- 本打算全部import过来,想着熟悉的角度还是重新review一遍.
- 之前是用的spring-boot1.x版本。现在使用2.x版本重新开发
## 分支介绍：
- dev-20210110:
    - 此分支综合所有继续开始的。之前没做分支，现在开始按日期迭代内容。
    - 当前版本：JDK8、springboot2.0.0.RELEASE、springCloud:Hoxton.SR1、
    - 后续迭代高版本
## 版本介绍:
- 一套： 
    - springboot: 2.0.6.RELEASE   
    - springCloud:Finchley.SR4
- 二套：
    - springboot: 2.2.0.RELEASE
    - springCloud:Hoxton.SR1
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