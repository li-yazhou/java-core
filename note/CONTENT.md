# 目录

* [简介](README.md)
* [目录](CONTENT.md)


## 算法基础
* [算法基础](https://github.com/li-yazhou/algorithm-primer)


## 计算机网络  
* TCP/IP协议
* HTTP协议
* 自定义协议基础


## 操作系统    
* [命令行](cs-linux/linux-command-list.md)
* [Shell基础](cs-linux/bash-cheat-sheet.md)
   

## MySQL   
* [MySQL](cs-mysql/README.md)
* [索引原理](cs-mysql/索引原理.md)
* [事务机制](cs-mysql/事务机制.md)
* [数据库锁](cs-mysql/数据库锁.md)
* [跨库分页查询](cs-mysql/跨库分页查询.md)
* [SQL优化](cs-mysql/SQL优化.md)  
     
    
## Java基础
* [JavaSE语法基础](java-base/java-lang.md)
* [Object](java-base/java-object.md)
* [面向对象编程](java-base/java-oop.md)
* [接口](java-base/java-interface.md)
* [内部类](java-base/java-inner-class.md)
* [枚举](java-base/java-enum.md)
* [异常](java-base/java-exception.md)
* [字符串](java-base/java-string.md)
* [数组](java-base/java-array.md)
* 集合
    * [集合](java-base/java-collection.md)
    * [集合源码分析](java-base/java-collection-source-analysis.md)
* [泛型](java-base/java-generic.md)
* 注解
    * [注解基础](java-base/java-annotation.md)
    * [lombok使用与实现原理](java-base/java-annotation-lombok使用与实现原理.md)
* 反射
    * [反射基础](java-base/java-reflect.md)
    * apache-beanutil
    * reflectasm
    * javassist
* 多线程与并发编程
    * [多线程与并发编程基础](java-base/java-thread-concurrency.md)
    * [生产者消费者与有界队列](java-base/java-thread-生产者消费者与有界队列.md)
    * [简单的线程池实现](java-base/java-thread-简单的线程池实现.md)
    * [Reactor模型](java-base/java-thread-Reactor模型.md)
    * [Future原理](java-base/java-thread-Future原理.md)
    * [缓存一致性问题](java-base/java-thread-缓存一致性.md)
    * [volatile关键字](java-base/java-thread-volatile关键字.md)
    * [ThreadLocal分析](java-base/java-thread-ThreadLocal分析.md)
* Java IO、NIO与Socket
    * Java Read
    * Java Write
    * [Java NIO](java-base/java-nio.md)
* 序列化
    * JDK序列化
    * JSON序列化
    * Protocol序列化
    * Avro序列化
* 动态代理
    * [动态代理与AOP](java-base/java-proxy-动态代理与AOP.md)
    * cglib
    * asm
* Java8编程
    * Stream
    * Lambda表达式
* [JVM](java-base/java-jvm-java-virtual-machine.md)
    * [JVM 内存模型](java-base/java-jvm-内存模型.md)
    * [JVM 垃圾回收算法与垃圾回收器]()
    * [JVM 类加载机制](java-base/java-jvm-类加载机制.md)
    * [JVM 内存分析工具](java-base/java-jvm-内存分析工具.md)
    * [JVM 性能参数调优](java-base/java-jvm-参数调优.md)
* Java Columns
    * [优雅的遍历](java-base/java-article-优雅的遍历.md)
    * [自动装箱拆箱AutoBox和享元模式flyweight](java-base/java-article-自动装箱拆箱AutoBox和享元模式flyweight.md)
* Simple系列
    * [Simple ORM](java-base/java-article-simple-orm.md)
    

## Spring
* [Spring](spring/spring.md)
* [SpringIOC](spring/spring-core-ioc.md)
* [SpringAOP](spring/spring-core-aop.md)
* [Spring注解](spring/spring-annotations.md)
* [Spring事务](spring/spring-transaction.md)
* [Spring定时任务](spring/spring-task-schedule.md)
* [Spring的线程安全性](spring/spring-thread-safety.md)
* [SpringMVC](spring/springmvc.md)
* [SpringMVC拦截器](spring/springmvc-interceptor.md)
* [SpringBoot](spring/springboot.md)
    
    
## Mybatis
* [MyBatis](java-web/mybatis-base.md)
* MyBatis CURD基本操作与工作原理
* MyBatis 事务机制
* MyBatis 缓存
    
      
## Java组件
* [Netty](java-component/java-component-netty.md)
* [apache-commons](java-component/java-component-apache-commons.md)
* [google-guava](java-component/java-component-google-guava.md)
* [Dubbo](java-component/java-component-dubbo-primer.md)
* jodd
* fastjson
* snake-yaml


## Java-Web
* Tomcat调参
* Tomcat的架构与原理
* Jetty
* [Cookie、Session与单点登录](java-web/Cookie与Session.md)
* [velocity primer](java-web/velocity-primer.md)

    
## 程序设计
* [日志](program-guide/log.md)
* [调试](program-guide/debug.md)
* [测试](program-guide/TEST.md) 
* [Java编码规约](program-guide/awesome-coding-style-guide.md)   


## 设计模式 
* [设计模式](design-pattern/README.md)
* 6大设计原则
* 5个创建类模式
    * [工厂方法模式](design-pattern/creational5-工厂方法模式.md)
* 7个结构类模式
    * [自动装箱与享元模式](design-pattern/structural7-自动装箱与享元模式.md)
    * [装饰者模式](design-pattern/structural7-装饰者模式.md)
    * [适配器模式](design-pattern/structural7-适配器模式.md)
* 11个行为类模式
    * [策略模式](design-pattern/behavioral11-策略模式.md)
    * [模板方法模式](design-pattern/behavioral-11-模板方法模式.md)


## 分布式基础
* [一致性Hash算法介绍与实现](cs-algorithm/一致性Hash算法介绍与实现.md)
* [分布式协调服务ZooKeeper](distribution-base/分布式协调服务ZooKeeper.md)    
* [熔断机制与Sentinel](distribution-base/熔断机制.md)    
* [分布式锁](distribution-base/分布式锁.md)    
* [分布式限流](distribution-base/分布式限流.md)    
* [分布式ID](distribution-base/分布式ID.md)    
* [分布式CAP理论](distribution-base/分布式CAP理论.md) 

 
## 分布式计算
* [Flink](distribution-engine/flink-primer.md)
* [Spark](distribution-engine/spark-primer.md)
* [Hadoop-MR Primer](distribution-engine/hadoop-mr-primer.md)
* [HDFS Primer](distribution-engine/hdfs-primer.md)
    
    
## 消息队列    
* [Pulsar](distribution-mq/pulsar-primer.md)
* [Pulsar生产者](distribution-mq/pulsar-producer.md)
* [Kafka](distribution-mq/kafka-primer.md)
* [Kafka生产者](distribution-mq/kafka-producer.md)
   
  
## 分布式扩展
* [Nginx Primer](distribution-extension/nginx-primer.md)
* [Openresty Primer](distribution-extension/openresty-primer.md)
* [ES Primer](distribution-extension/es-primer.md)
* [Redis Primer](distribution-extension/redis-primer.md)
* [HBase Primer](distribution-extension/hbase-primer.md)
* [Memcached Primer](distribution-extension/memcached-primer.md)
* K8S Primer
* Docker Primer

 
## 开发工具    
* [开发工具](dev-tool/README.md)
* [Git](dev-tool/git.md)
* [Git commit规范](dev-tool/git-commit-guide.md)
* [Maven](dev-tool/maven.md)
* [Idea](dev-tool/idea.md)
* [压测工具](dev-tool/压测工具.md)
* [Mac](dev-tool/mac.md)
* [GitBook](dev-tool/gitbook.md)


## 学习资源
* [技术资料](learning-resource/Java技术资料.md)
* [Java优秀仓库](learning-resource/Github优秀仓库.md)
* [Java面试题目](learning-resource/Java面试题目.md)
* [Java核心知识点](learning-resource/Java核心知识点.md)


  
    
    
    
    
    
    
    
    
    
    
    
    
    
    