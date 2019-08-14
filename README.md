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


---


## PRAT-I CS基础
* [PRAT-I CS基础](note/part-1-cs-base/README.md)
* [算法基础](note/part-1-cs-base/algorithm/algorithm.md)
    * 数据结构与算法基础
        * [排序算法](note/part-1-cs-base/algorithm/classic-base/排序算法.md)
        * [查询算法](note/part-1-cs-base/algorithm/classic-base/查询算法.md)
        * [树的前中后序递归与非递归遍历](note/part-1-cs-base/algorithm/classic-base/树的递归与非递归遍历.md)
        * [树的层次遍历](note/part-1-cs-base/algorithm/classic-base/树的层次遍历.md)
        * [图的深搜与广搜](note/part-1-cs-base/algorithm/classic-base/图的深搜与广搜.md)
    * [剑指offer编程汇总](note/part-1-cs-base/algorithm/剑指offer.md)
    * [Leetcode编程](note/part-1-cs-base/algorithm/leetcode.md)
    * [限流算法之漏斗算法与令牌桶算法](note/part-1-cs-base/algorithm/限流算法之漏斗算法与令牌桶算法.md)
    * [LRU算法与实现](note/part-1-cs-base/algorithm/LRU算法与实现.md)    
* 计算机网络
    * TCP/IP协议
        * [三次握手与四次挥手](note/part-1-cs-base/network/三次握手与四次挥手.md)
    * HTTP协议
    * 自定义协议基础
* 操作系统
    * [命令行](note/part-1-cs-base/linux/linux-command-list.md)
    * [Shell基础](note/part-1-cs-base/linux/bash-cheat-sheet.md)
    

---


## PRAT-II Java基础
* [PRAT-II 基础](note/part-2-java-base/README.md)
* [JavaSE语法基础](note/part-2-java-base/java-base/java-base-lang/java-lang.md)
* [Object](note/part-2-java-base/java-base/java-base-lang/java-object.md)
* [面向对象编程](note/part-2-java-base/java-base/java-base-lang/java-oop.md)
* [接口](note/part-2-java-base/java-base/java-base-interface/java-interface.md)
* [内部类](note/part-2-java-base/java-base/java-base-inner-class/java-inner-class.md)
* [枚举](note/part-2-java-base/java-base/java-base-enum/java-enum.md)
* [异常](note/part-2-java-base/java-base/java-base-exception/java-exception.md)
* [字符串](note/part-2-java-base/java-base/java-base-string/java-string.md)
* [数组](note/part-2-java-base/java-base/java-base-array/java-array.md)
* 集合
    * [集合](note/part-2-java-base/java-base/java-base-collection/java-collection.md)
    * [集合源码分析](note/part-2-java-base/java-base/java-base-collection/java-collection-source-analysis.md)
* [泛型](note/part-2-java-base/java-base/java-base-generic/java-generic.md)
* 注解
    * [注解基础](note/part-2-java-base/java-base/java-base-annotation/java-annotation.md)
    * [lombok使用与实现原理](note/part-2-java-base/java-base/java-base-annotation/lombok使用与实现原理.md)
* 反射
    * [反射基础](note/part-2-java-base/java-base/java-base-reflect/java-reflect.md)
    * apache-beanutil
    * reflectasm
    * javassist
* 多线程与并发编程
    * [多线程与并发编程基础](note/part-2-java-base/java-base/java-base-multithread-concurrency/java-multithread-concurrency.md)
    * [生产者消费者与有界队列](note/part-2-java-base/java-base/java-base-multithread-concurrency/生产者消费者与有界队列.md)
    * [简单的线程池实现](note/part-2-java-base/java-base/java-base-multithread-concurrency/简单的线程池实现.md)
    * [Reactor模型](note/part-2-java-base/java-base/java-base-multithread-concurrency/Reactor模型.md)
    * [Future原理](note/part-2-java-base/java-base/java-base-multithread-concurrency/Future原理.md)
    * [缓存一致性问题](note/part-2-java-base/java-base/java-base-multithread-concurrency/缓存一致性.md)
    * [volatile关键字](note/part-2-java-base/java-base/java-base-multithread-concurrency/volatile关键字.md)
    * [ThreadLocal分析](note/part-2-java-base/java-base/java-base-multithread-concurrency/ThreadLocal分析.md)
* Java IO、NIO与Socket
    * Java Read
    * Java Write
    * [Java NIO](note/part-2-java-base/java-base/java-base-nio/java-nio.md)
* 序列化
    * JDK序列化
    * JSON序列化
    * Protocol序列化
    * Avro序列化
* 动态代理
    * [动态代理与AOP](note/part-2-java-base/java-base/java-base-proxy/动态代理与AOP.md)
    * cglib
    * asm
* [Java8编程](note/part-2-java-base/java8/README.md)
    * Stream
    * Lambda表达式
* [JVM](note/part-2-java-base/java-jvm/java-virtual-machine.md)
    * [JVM 内存模型](note/part-2-java-base/java-jvm/JVM内存模型.md)
    * [JVM 垃圾回收算法与垃圾回收器](note/part-2-java-base/java-jvm/JVM GC算法与垃圾回收器.md)
    * [JVM 类加载机制](note/part-2-java-base/java-jvm/JVM类加载机制.md)
    * [JVM 内存分析工具](note/part-2-java-base/java-jvm/JVM-内存分析工具.md)
    * [JVM 性能参数调优](note/part-2-java-base/java-jvm/JVM参数调优.md)
* Java Columns
    * [HashMap源码分析](note/part-2-java-base/java-base/java-base-columns/HashMap源码分析.md)
    * [LikedHashMap实现LRU缓存](note/part-2-java-base/java-base/java-base-columns/LinkedHashMap实现LRU缓存.md)
    * [优雅的遍历](note/part-2-java-base/java-base/java-base-columns/优雅的遍历.md)
    * [自动装箱拆箱AutoBox和享元模式flyweight](note/part-2-java-base/java-base/java-base-columns/自动装箱拆箱AutoBox和享元模式flyweight.md)
* Simple系列
    * [Simple ORM](note/part-2-java-base/simple/simple-orm.md)
    * Simple Spring
    * Simple RPC
    

---


## PART-III Java进阶
* [PART-III 进阶](note/part-3-java-advanced/README.md)
* [Spring](note/part-3-java-advanced/spring/spring.md)
    * [SpringIOC](note/part-3-java-advanced/spring/spring-core-ioc.md)
    * [SpringAOP](note/part-3-java-advanced/spring/spring-core-aop.md)
    * [Spring注解](note/part-3-java-advanced/spring/spring-annotations.md)
    * [Spring事务](note/part-3-java-advanced/spring/spring-transaction.md)
    * [Spring定时任务](note/part-3-java-advanced/spring/spring-task-schedule.md)
    * [Spring的线程安全性](note/part-3-java-advanced/spring/spring-thread-safety.md)
    * [SpringMVC](note/part-3-java-advanced/spring/springmvc.md)
    * [SpringMVC拦截器](note/part-3-java-advanced/spring/springmvc-interceptor.md)
    * [SpringBoot](note/part-3-java-advanced/spring/springboot.md)
* [MyBatis](note/part-3-java-advanced/mybatis/mybatis.md)
    * MyBatis CURD基本操作与工作原理
    * MyBatis 事务机制
    * MyBatis 缓存
* [MySQL](note/part-3-java-advanced/mysql/README.md)
    * [索引原理](note/part-3-java-advanced/mysql/索引原理.md)
    * [事务机制](note/part-3-java-advanced/mysql/事务机制.md)
    * [数据库锁](note/part-3-java-advanced/mysql/数据库锁.md)
    * [跨库分页查询](note/part-3-java-advanced/mysql/跨库分页查询.md)
    * [SQL优化](note/part-3-java-advanced/mysql/SQL优化.md)  
* [第三方组件](note/part-3-java-advanced/3rd-component/README.md)
    * [apache-commons](note/part-3-java-advanced/3rd-component/apache-commons/apache-commons.md)
    * [google-guava](note/part-3-java-advanced/3rd-component/google-guava/google-guava.md)
    * jodd
    * fastjson
    * snakeYaml
* Java-Web
    * Web容器
        * Tomcat调参
        * Tomcat的架构与原理
        * Jetty
    * [Cookie、Session与单点登录](note/part-3-java-advanced/java-web/Cookie与Session.md)
    * [velocity primer](note/part-3-java-advanced/java-web/velocity-primer.md)

    
---


## PART-IV 程序设计
* [日志](note/part-4-programming-design/log/log.md)
* [调试](note/part-4-programming-design/debug/debug.md)
* [测试](note/part-4-programming-design/test/TEST.md)  
* [设计模式](note/part-4-programming-design/design-pattern/design-pattern.md)
    * 6大设计原则
    * 5个创建类模式
        * [工厂方法模式](note/part-4-programming-design/design-pattern/creational5/工厂方法模式.md)
    * 7个结构类模式
        * [自动装箱与享元模式](note/part-4-programming-design/design-pattern/structural7/自动装箱与享元模式.md)
        * [装饰者模式](note/part-4-programming-design/design-pattern/structural7/装饰者模式.md)
        * [适配器模式](note/part-4-programming-design/design-pattern/structural7/适配器模式.md)
    * 11个行为类模式
        * [策略模式](note/part-4-programming-design/design-pattern/behavioral11/策略模式.md)
        * [模板方法模式](note/part-4-programming-design/design-pattern/behavioral11/模板方法模式.md)


---


## PART-V 分布式
* [PART-V 分布式](note/part-5-distribution-base/README.md)
* [Flink](note/part-5-distribution-base/flink/flink-primer.md)
* [Spark](note/part-5-distribution-base/spark/spark-primer.md)
* [Netty](note/part-5-distribution-base/netty/netty-primer.md)
* [Dubbo](note/part-5-distribution-base/dubbo/dubbo-primer.md)
* Hadoop
    * [Hadoop-MR Primer](note/part-5-distribution-base/hadoop/hadoop-mr-primer.md)
    * [HDFS Primer](note/part-5-distribution-base/hadoop/hdfs-primer.md)
* 缓存
    * [Redis Primer](note/part-5-distribution-base/cache/redis-primer.md)
    * [Memcached Primer](note/part-5-distribution-base/cache/memcached-primer.md)
    * [Guava Cache Primer](note/part-5-distribution-base/cache/guava-cache.md)
* 分布式基础
    * [一致性Hash算法介绍与实现](note/part-5-distribution-base/distribution-base/一致性Hash算法介绍与实现.md)
    * [分布式协调服务ZooKeeper](note/part-5-distribution-base/distribution-base/分布式协调服务ZooKeeper.md)    
    * [熔断机制与Sentinel](note/part-5-distribution-base/distribution-base/熔断机制.md)    
    * [分布式锁](note/part-5-distribution-base/distribution-base/分布式锁.md)    
    * [分布式限流](note/part-5-distribution-base/distribution-base/分布式限流.md)    
    * [分布式ID](note/part-5-distribution-base/distribution-base/分布式ID.md)    
    * [分布式CAP理论](note/part-5-distribution-base/distribution-base/分布式CAP理论.md)    
* 扩展
    * [Nginx Primer](note/part-5-distribution-base/primer/nginx-primer.md)
    * [Openresty Primer](note/part-5-distribution-base/primer/openresty-primer.md)
    * [ES Primer](note/part-5-distribution-base/primer/es-primer.md)
    * [HBase Primer](note/part-5-distribution-base/primer/hbase-primer.md)
    * K8S Primer
    * Docker Primer


---


## PART-VI 消息队列与流
* [消息队列与流](note/part-6-message-queue/message-queue.md)
* [Pulsar](note/part-6-message-queue/pulsar/pulsar-primer.md)
    * [Pulsar生产者](note/part-6-message-queue/pulsar/pulsar-producer.md)
* [Kafka](note/part-6-message-queue/kafka/kafka-primer.md)
    * [Kafka生产者](note/part-6-message-queue/kafka/kafka-producer.md)


---
 

## PART-VII 其他
* [PART-VII 其他](note/part-7-other/README.md) 
* 程序设计  
* Columns
    * [程序设计资料](note/part-7-other/columns/awesome-book.md)
    * [Java优秀仓库](note/part-7-other/columns/awesome-github.md)
    * [Java编码规约](note/part-7-other/columns/awesome-coding-style-guide.md)   
    * [Git commit规范](note/part-7-other/columns/git-commit-guide.md)
    * [Mac下安装多版本JDK](note/part-7-other/columns/mac-JDKs-install.md)
* [开发工具](note/part-7-other/effective-tool/awesome-dev-tool.md)
    * [Git](note/part-7-other/effective-tool/git-usage.md)
    * [Git-Cheat-Sheet](note/part-7-other/effective-tool/git-cheat-sheet.md)
    * [Maven](note/part-7-other/effective-tool/maven-usage.md)
    * [Idea](note/part-7-other/effective-tool/idea-usage.md)
    * [压测工具](note/part-7-other/effective-tool/pressure-measure-usage.md)
    * [Mac](note/part-7-other/effective-tool/mac-usage.md)
    * [GitBook](note/part-7-other/effective-tool/gitbook-usage.md)


---

  
## PART-VIII Summary
* [PART-VIII Summary](note/part-8-summary/java-summary.md)




































