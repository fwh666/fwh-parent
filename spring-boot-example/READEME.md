# 记录：

springboot1.0版本和springboot2.0版本比对，以及相关依赖引用，方法使用。

## 模块记录	
### Redis
   - redisTemplate的增删改查、失效时间、选择库    
    1.数据类型：
        - string
        - map
        - hash
        - set
        - list  
    2.session存储 
        - 使用spring-session
        - 设置失效时间    
        - 确认存储的sessionId与redis中一致,达到共享session的效果    
    3.多环境管理：
        profiles配置
        
### rabbitMq
- rabbitmq的概念
- 交换机
- rabbit的使用：
	-  简单使用
	    - 注意，发送者和接收者的 queue name 必须一致，不然不能接收
	-  多对多使用/一对多使用
	    - 结论：和一对多一样，接收端仍然会均匀接收到消息
	-  高级使用

### OAuth
   - 认证
   - 权限
   
## TODO-开发
   - shiro
   - mybatis-plus
   - docker
   - rabbitmq
   - swagger
   - mail
   - fastDfs
   - mongodb
