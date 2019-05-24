# 目录

* [简介](README.md)
* [目录](CONTENT.md)

## PRAT-I 基础
* JavaSE语法
    * [语言基础](part-1-base/java-base/java-base-lang/java-lang.md)
    * [面向对象](part-1-base/java-base/java-base-lang/面向对象.md)
* 集合与泛型
    * [集合与泛型](part-1-base/java-base/java-base-collection-generic/java-collection-generic.md)
    * [集合源码分析](part-1-base/java-base/java-base-collection-generic/java-collection-source-analysis.md)
* 注解、反射与工具包
    * [注解基础](part-1-base/java-base/java-base-annotation/java-annotation.md)
    * [lombok使用与实现原理](part-1-base/java-base/java-base-annotation/lombok使用与实现原理.md)
    * [反射基础](part-1-base/java-base/java-base-reflect/java-reflect.md)
    * apache-beanutil
    * reflectasm
    * javassist
* 多线程与并发编程
    * [多线程与并发编程基础](part-1-base/java-base/java-base-multithread-concurrency/java-multithread-concurrency.md)
    * [生产者消费者与有界队列](part-1-base/java-base/java-base-multithread-concurrency/生产者消费者与有界队列.md)
    * [简单的线程池实现](part-1-base/java-base/java-base-multithread-concurrency/简单的线程池实现.md)
    * [Reactor模型](part-1-base/java-base/java-base-multithread-concurrency/Reactor模型.md)
    * [Future原理](part-1-base/java-base/java-base-multithread-concurrency/Future原理.md)
    * [缓存一致性问题](part-1-base/java-base/java-base-multithread-concurrency/缓存一致性.md)
    * [volatile关键字](part-1-base/java-base/java-base-multithread-concurrency/volatile关键字.md)
    * [ThreadLocal分析](part-1-base/java-base/java-base-multithread-concurrency/ThreadLocal分析.md)
* Java IO、NIO与Socket
    * Java Read
    * Java Write
    * [Java NIO 简明教程-EN](http://tutorials.jenkov.com/java-nio/index.html)
    * [Java NIO 简明教程-ZH](http://ifeve.com/overview/)
* 序列化
    * JDK序列化
    * JSON序列化
    * Protocol序列化
    * Avro序列化
* 动态代理
    * jdk proxy
    * cglib
    * asm
    * 实现 AOP
* [Java8编程](part-1-base/java8/README.md)
    * Stream
    * Lambda表达式
* [JVM](part-1-base/java-jvm/README.md)
    * JVM 内存模型
    * JVM 垃圾回收算法与垃圾回收器
    * JVM 类加载机制
    * JVM 分析工具
    * Java 性能调优
* [Netty](part-1-base/netty/README.md)
* [算法基础](part-1-base/algorithm/algorithm.md)
    * 数据结构与算法基础
        * [排序算法](part-1-base/algorithm/classic-base/排序算法.md)
        * [查询算法](part-1-base/algorithm/classic-base/查询算法.md)
        * [树的递归与非递归遍历](part-1-base/algorithm/classic-base/树的递归与非递归遍历.md)
        * [树的层次遍历](part-1-base/algorithm/classic-base/树的层次遍历.md)
        * [图的深搜与广搜](part-1-base/algorithm/classic-base/图的深搜与广搜.md)
    * [剑指offer编程汇总](https://github.com/li-yazhou/algorithm-primer/blob/master/interview-for-offer/md/%E5%89%91%E6%8C%87offer%E9%9D%A2%E8%AF%95%E9%A2%98%E6%B1%87%E6%80%BB.md)
    * [Leetcode编程](https://github.com/li-yazhou/algorithm-primer/blob/master/leetcode/README.md)
    * [一致性Hash算法介绍与实现](part-1-base/algorithm/一致性Hash算法介绍与实现.md)
    * [限流算法之漏斗算法与令牌桶算法](part-1-base/algorithm/限流算法之漏斗算法与令牌桶算法.md)
    * [LRU算法与实现](part-1-base/algorithm/LRU算法与实现.md)    
* 计算机网络
    * TCP/IP协议
        * [三次握手与四次挥手](part-1-base/network/三次握手与四次挥手.md)
    * HTTP协议
    * 自定义协议基础
* 操作系统
    * [命令行](part-1-base/linux/linux-command-list.md)
    * [Shell基础](part-1-base/linux/bash-cheat-sheet.md)
* [MySQL](part-1-base/mysql/README.md)
    * [索引原理](part-1-base/mysql/索引原理.md)
    * [事务机制](part-1-base/mysql/事务机制.md)
    * [数据库锁](part-1-base/mysql/数据库锁.md)
    * [跨库分页查询](part-1-base/mysql/跨库分页查询.md)
    * [SQL优化](part-1-base/mysql/SQL优化.md)


---


## PART-II 进阶
* [Spring](part-2-advanced/spring/spring.md)
    * [SpringIOC](part-2-advanced/spring/spring-core-ioc.md)
    * [SpringAOP](part-2-advanced/spring/spring-core-aop.md)
    * [SpringMVC](part-2-advanced/springmvc/springmvc.md)
    * [SpringBoot](part-2-advanced/springboot/springboot.md)
    * [Spring事务](part-2-advanced/spring/spring-transaction.md)
    * [Spring定时任务](part-2-advanced/spring/spring-task-schedule.md)
    * [Spring的线程安全性](part-2-advanced/spring/spring-thread-safety.md)
* [MyBatis](part-2-advanced/mybatis/README.md)
    * MyBatis CURD基本操作与工作原理
    * MyBatis 事务机制
* [日志](part-2-advanced/log/README.md)
* [测试](part-2-advanced/test/README.md)  
* [设计模式](part-2-advanced/design-pattern/README.md)
    * [工厂方法模式](part-2-advanced/design-pattern/工厂方法模式.md)
    * [自动装箱与享元模式](part-2-advanced/design-pattern/自动装箱与享元模式.md)
    * 单例模式
    * 模板方法模式
    * 构建者模式
* [第三方组件](part-2-advanced/3rd-component/README.md)
    * [apache-commons](part-2-advanced/3rd-component/apache-commons/apache-commons.md)
    * [google-guava](part-2-advanced/3rd-component/google-guava/google-guava.md)
    * fastjson
* 容器
    * Tomcat调参
    * Tomcat的架构与原理
    * Jetty
   

---


## PART-III 分布式
* [Kafka](part-3-distribution-base/kafka/kafka-primer.md)
* [Flink](part-3-distribution-base/flink/flink-primer.md)
* [Spark](part-3-distribution-base/spark/spark-primer.md)
* Hadoop
    * [Hadoop-MR Primer](part-3-distribution-base/hadoop/hadoop-mr-primer.md)
    * [HDFS Primer](part-3-distribution-base/hadoop/hdfs-primer.md)
* 缓存
    * [Redis Primer](part-3-distribution-base/cache/redis-primer.md)
    * [Memcached Primer](part-3-distribution-base/cache/memcached-primer.md)
    * [Guava Primer](part-3-distribution-base/cache/guava-cache.md)
* 分布式基础
    * [分布式协调服务ZooKeeper](part-3-distribution-base/distribution-base/分布式协调服务ZooKeeper.md)    
    * [熔断机制](part-3-distribution-base/distribution-base/熔断机制.md)    
    * [分布式锁](part-3-distribution-base/distribution-base/分布式锁.md)    
    * [分布式限流](part-3-distribution-base/distribution-base/分布式限流.md)    
    * [分布式ID](part-3-distribution-base/distribution-base/分布式ID.md)    
* 扩展
    * [Nginx Primer](part-3-distribution-base/primer/nginx-primer.md)
    * [Openresty Primer](part-3-distribution-base/primer/openresty-primer.md)
    * [ES Primer](part-3-distribution-base/primer/es-primer.md)
    * [HBase Primer](part-3-distribution-base/primer/hbase-primer.md)
    * [K8S Primer](part-3-distribution-base/primer/kubernetes-primer.md)
    * [Docker Primer](part-3-distribution-base/primer/docker-primer.md) 


---
 

## PART-IV 其他 
* 程序设计  
    * [Java编码规约](part-4-other/columns/awesome-coding-style-guide.md)   
* Columns
    * [Java编程资料](part-4-other/columns/awesome-book.md)
    * [Java优良仓库](part-4-other/columns/awesome-github.md)
    * [Git commit规范](part-4-other/effective-tool/git-commit-guide.md)
    * [开发工具](part-4-other/effective-tool/awesome-dev-tool.md)
        * [Git](part-4-other/effective-tool/git-usage.md)
        * [Git-Cheat-Sheet](part-4-other/effective-tool/git-cheat-sheet.md)
        * [Maven](part-4-other/effective-tool/maven-usage.md)
        * [Idea](part-4-other/effective-tool/idea-usage.md)
        * [压测工具](part-4-other/effective-tool/wrk-benchmark-usage.md)
* Simple系列
    * [Simple ORM](part-4-other/simple/simple-orm.md)
    * Simple Spring
    * Simple RPC
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

