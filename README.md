# Java-Core

> 作者：liyazhou <br/>
> 邮件：xcliyazhou@gmail.com/xcliyazhou@163.com <br/>
> github：li-yazhou


---


# 简介

java-core 记录 CS 开发的中高级部分的内容，没有对所涉及到的技术进行细致入微地讨论，旨在建立技术知识的索引，并逐渐形成体系。

其中各个模块保存着源代码，note 目录下保存着md格式的笔记。

本仓库参考大量纸质和网络材料，在此向原作者表示感谢。

GitHub 地址是 <https://github.com/li-yazhou/java-core>。

GitBook 地址是 <https://li-yazhou.github.io/java-core/CONTENT.html>。


---

    
# 目录

* [简介](note/README.md)
* [目录](note/CONTENT.md)


## 算法基础
* [算法基础](note/cs-algorithm/algorithm.md)
* 数据结构与算法基础
    * [排序算法](note/cs-algorithm/排序算法.md)
    * [查询算法](note/cs-algorithm/查询算法.md)
    * [树的前中后序递归与非递归遍历](note/cs-algorithm/树的递归与非递归遍历.md)
    * [树的层次遍历](note/cs-algorithm/树的层次遍历.md)
    * [图的深搜与广搜](note/cs-algorithm/图的深搜与广搜.md)
* [剑指offer编程汇总](note/cs-algorithm/剑指offer.md)
* [Leetcode编程](note/cs-algorithm/leetcode.md)
* [限流算法之漏斗算法与令牌桶算法](note/cs-algorithm/限流算法之漏斗算法与令牌桶算法.md)
* [LRU算法与实现](note/cs-algorithm/LRU算法与实现.md)    


## 计算机网络  
* TCP/IP协议
* HTTP协议
* 自定义协议基础


## 操作系统    
* [命令行](note/cs-linux/linux-command-list.md)
* [Shell基础](note/cs-linux/bash-cheat-sheet.md)
   

## MySQL   
* [MySQL](note/cs-mysql/README.md)
* [索引原理](note/cs-mysql/索引原理.md)
* [事务机制](note/cs-mysql/事务机制.md)
* [数据库锁](note/cs-mysql/数据库锁.md)
* [跨库分页查询](note/cs-mysql/跨库分页查询.md)
* [SQL优化](note/cs-mysql/SQL优化.md)  
     
    
## Java基础
* [JavaSE语法基础](note/java-base/java-lang.md)
* [Object](note/java-base/java-object.md)
* [面向对象编程](note/java-base/java-oop.md)
* [接口](note/java-base/java-interface.md)
* [内部类](note/java-base/java-inner-class.md)
* [枚举](note/java-base/java-enum.md)
* [异常](note/java-base/java-exception.md)
* [字符串](note/java-base/java-string.md)
* [数组](note/java-base/java-array.md)
* 集合
    * [集合](note/java-base/java-collection.md)
    * [集合源码分析](note/java-base/java-collection-source-analysis.md)
* [泛型](note/java-base/java-generic.md)
* 注解
    * [注解基础](note/java-base/java-annotation.md)
    * [lombok使用与实现原理](note/java-base/java-annotation-lombok使用与实现原理.md)
* 反射
    * [反射基础](note/java-base/java-reflect.md)
    * apache-beanutil
    * reflectasm
    * javassist
* 多线程与并发编程
    * [多线程与并发编程基础](note/java-base/java-thread-concurrency.md)
    * [生产者消费者与有界队列](note/java-base/java-thread-生产者消费者与有界队列.md)
    * [简单的线程池实现](note/java-base/java-thread-简单的线程池实现.md)
    * [Reactor模型](note/java-base/java-thread-Reactor模型.md)
    * [Future原理](note/java-base/java-thread-Future原理.md)
    * [缓存一致性问题](note/java-base/java-thread-缓存一致性.md)
    * [volatile关键字](note/java-base/java-thread-volatile关键字.md)
    * [ThreadLocal分析](note/java-base/java-thread-ThreadLocal分析.md)
* Java IO、NIO与Socket
    * Java Read
    * Java Write
    * [Java NIO](note/java-base/java-nio.md)
* 序列化
    * JDK序列化
    * JSON序列化
    * Protocol序列化
    * Avro序列化
* 动态代理
    * [动态代理与AOP](note/java-base/java-proxy-动态代理与AOP.md)
    * cglib
    * asm
* Java8编程
    * Stream
    * Lambda表达式
* [JVM](note/java-base/java-jvm-java-virtual-machine.md)
    * [JVM 内存模型](note/java-base/java-jvm-内存模型.md)
    * [JVM 垃圾回收算法与垃圾回收器]()
    * [JVM 类加载机制](note/java-base/java-jvm-类加载机制.md)
    * [JVM 内存分析工具](note/java-base/java-jvm-内存分析工具.md)
    * [JVM 性能参数调优](note/java-base/java-jvm-参数调优.md)
* Java Columns
    * [优雅的遍历](note/java-base/java-article-优雅的遍历.md)
    * [自动装箱拆箱AutoBox和享元模式flyweight](note/java-base/java-article-自动装箱拆箱AutoBox和享元模式flyweight.md)
* Simple系列
    * [Simple ORM](note/java-base/java-article-simple-orm.md)
    

## Spring
* [Spring](note/spring/spring.md)
* [SpringIOC](note/spring/spring-core-ioc.md)
* [SpringAOP](note/spring/spring-core-aop.md)
* [Spring注解](note/spring/spring-annotations.md)
* [Spring事务](note/spring/spring-transaction.md)
* [Spring定时任务](note/spring/spring-task-schedule.md)
* [Spring的线程安全性](note/spring/spring-thread-safety.md)
* [SpringMVC](note/spring/springmvc.md)
* [SpringMVC拦截器](note/spring/springmvc-interceptor.md)
* [SpringBoot](note/spring/springboot.md)
    
    
## Mybatis
* [MyBatis](note/java-web/mybatis-base.md)
* MyBatis CURD基本操作与工作原理
* MyBatis 事务机制
* MyBatis 缓存
    
      
## Java组件
* [Netty](note/java-component/java-component-netty.md)
* [apache-commons](note/java-component/java-component-apache-commons.md)
* [google-guava](note/java-component/java-component-google-guava.md)
* [Dubbo](note/java-component/java-component-dubbo-primer.md)
* jodd
* fastjson
* snake-yaml


## Java-Web
* Tomcat调参
* Tomcat的架构与原理
* Jetty
* [Cookie、Session与单点登录](note/java-web/Cookie与Session.md)
* [velocity primer](note/java-web/velocity-primer.md)

    
## 程序设计
* [日志](note/program-guide/log.md)
* [调试](note/program-guide/debug.md)
* [测试](note/program-guide/TEST.md) 
* [Java编码规约](note/program-guide/awesome-coding-style-guide.md)   


## 设计模式 
* [设计模式](note/design-pattern/README.md)
* 6大设计原则
* 5个创建类模式
    * [工厂方法模式](note/design-pattern/creational5-工厂方法模式.md)
* 7个结构类模式
    * [自动装箱与享元模式](note/design-pattern/structural7-自动装箱与享元模式.md)
    * [装饰者模式](note/design-pattern/structural7-装饰者模式.md)
    * [适配器模式](note/design-pattern/structural7-适配器模式.md)
* 11个行为类模式
    * [策略模式](note/design-pattern/behavioral11-策略模式.md)
    * [模板方法模式](note/design-pattern/behavioral-11-模板方法模式.md)


## 分布式基础
* [一致性Hash算法介绍与实现](note/cs-algorithm/一致性Hash算法介绍与实现.md)
* [分布式协调服务ZooKeeper](note/distribution-base/分布式协调服务ZooKeeper.md)    
* [熔断机制与Sentinel](note/distribution-base/熔断机制.md)    
* [分布式锁](note/distribution-base/分布式锁.md)    
* [分布式限流](note/distribution-base/分布式限流.md)    
* [分布式ID](note/distribution-base/分布式ID.md)    
* [分布式CAP理论](note/distribution-base/分布式CAP理论.md) 

 
## 分布式计算
* [Flink](note/distribution-engine/flink-primer.md)
* [Spark](note/distribution-engine/spark-primer.md)
* [Hadoop-MR Primer](note/distribution-engine/hadoop-mr-primer.md)
* [HDFS Primer](note/distribution-engine/hdfs-primer.md)
    
    
## 消息队列    
* [Pulsar](note/distribution-mq/pulsar-primer.md)
* [Pulsar生产者](note/distribution-mq/pulsar-producer.md)
* [Kafka](note/distribution-mq/kafka-primer.md)
* [Kafka生产者](note/distribution-mq/kafka-producer.md)
   
  
## 分布式扩展
* [Nginx Primer](note/distribution-extension/nginx-primer.md)
* [Openresty Primer](note/distribution-extension/openresty-primer.md)
* [ES Primer](note/distribution-extension/es-primer.md)
* [Redis Primer](note/distribution-extension/redis-primer.md)
* [HBase Primer](note/distribution-extension/hbase-primer.md)
* [Memcached Primer](note/distribution-extension/memcached-primer.md)
* K8S Primer
* Docker Primer

 
## 开发工具    
* [开发工具](note/dev-tool/README.md)
* [Git](note/dev-tool/git.md)
* [Git commit规范](note/dev-tool/git-commit-guide.md)
* [Maven](note/dev-tool/maven.md)
* [Idea](note/dev-tool/idea.md)
* [压测工具](note/dev-tool/压测工具.md)
* [Mac](note/dev-tool/mac.md)
* [GitBook](note/dev-tool/gitbook.md)


## 阅读记录
* [技术资料](note/learning-resource/Java技术资料.md)
* [优秀仓库](note/learning-resource/Github优秀仓库.md)
* [面试题目](note/learning-resource/Java面试题目.md)
* [核心知识点](note/learning-resource/Java核心知识点.md)


  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
