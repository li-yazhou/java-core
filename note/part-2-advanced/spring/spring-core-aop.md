# spring-core-aop


## AOP 概念

AOP，Aspect-Oriented Programming，面向切面编程。

AOP 是一种通过**预编译方式**和**运行期动态代理**实现在不修改源代码的情况下给程序动态添加功能的技术。


---


## AspectJ

使用aspect关键字定义了一个类，这个类就是一个切面，它可以是单独的日志切面(功能)，也可以是权限切面或者其他，
在切面内部使用了pointcut定义了两个切点，一个用于权限验证，一个用于日志记录，
而所谓的切点就是那些需要应用切面的方法，如需要在sayHello方法执行前后进行权限验证和日志记录，那么就需要捕捉该方法，
而pointcut就是定义这些需要捕捉的方法（常常是不止一个方法的），这些方法也称为目标方法，
最后还定义了两个通知，通知就是那些需要在目标方法前后执行的函数，如before()即前置通知在目标方法之前执行，
即在sayHello()方法执行前进行权限验证，另一个是after()即后置通知，在sayHello()之后执行，如进行日志记录。
到这里也就可以确定，切面就是切点和通知的组合体，组成一个单独的结构供后续使用。


连接点 joinPoint，指哪些目标函数可以被拦截
切入点 pointcut，指对连接点joinPoint中的哪些目标函数进行切入
通知  advice，在某个特定的切入点pointcut上需要执行的动作（代码），如日志记录、鉴权等具体要应用到切入点的代码
切面  aspect，由切点和通知相结合而成，定义通知应用到哪些切入点上
织入  weaving，把切面的代码织入（应用）到目标函数的过程


### AspectJ的织入方式及其原理概要

AspectJ应用到java代码的过程（这个过程称为织入），对于织入这个概念，可以简单理解为aspect(切面)应用到目标函数(类)的过程。
对于这个过程，一般分为动态织入和静态织入，动态织入的方式是在运行时动态将要增强的代码织入到目标类中，
这样往往是通过动态代理技术完成的，如Java JDK的动态代理(Proxy，底层通过反射实现)或者CGLIB的动态代理(底层通过继承实现)，
Spring AOP采用的就是基于运行时增强的代理技术，这点后面会分析，这里主要重点分析一下静态织入，ApectJ采用的就是静态织入的方式。
ApectJ主要采用的是编译期织入，在这个期间使用AspectJ的acj编译器(类似javac)把aspect类编译成class字节码后，
在java目标类编译时织入，即先编译aspect类再编译目标类。


关于ajc编译器，是一种能够识别aspect语法的编译器，它是采用java语言编写的，
由于javac并不能识别aspect语法，便有了ajc编译器，注意ajc编译器也可编译java文件。


### Spring AOP 术语

Spring AOP 的实现是遵循AOP规范的，特别是以AspectJ（与java无缝整合）为参考，只不过Spring AOP底层是通过动态代理技术实现罢了。

不过在AOP的术语概念上与前面分析的AspectJ的AOP术语是一样的。
* 连接点 jointPoint，可以被拦截的目标函数
* 切点 pointcut，定义需要应用通知的目标函数
* 通知 advice，则是那些需要应用到目标函数而编写的函数体
* 切面 Aspect，则是通知与切点的结合
* 织入 weaving，将aspect类应用到目标函数(类)的过程


---


## 基于注解的Spring AOP开发

### 定义切入点函数

### 切入点指示符
为了方法通知应用到相应过滤的目标方法上，SpringAOP提供了**匹配表达式**，这些表达式也叫**切入点指示符**。

### 通知函数以及传递参数

### Aspect优先级

### 基于XML的开发

### Spring AOP 简单应用场景


---


## Spring AOP 的实现原理

### JDK动态代理

### CGLIB动态代理


---


## 参考
* [1] [Spring4: Aspect Oriented Programming with Spring](https://docs.spring.io/spring/docs/4.3.24.RELEASE/spring-framework-reference/htmlsingle/#aop)
* [2] [Spring4: Spring AOP APIs](https://docs.spring.io/spring/docs/4.3.24.RELEASE/spring-framework-reference/htmlsingle/#aop)
* [3] [AOP的经典用法](https://lfvepclr.gitbooks.io/spring-framework-5-doc-cn/content/37-Spring_AOP_Usage.html)
* [4] [关于 Spring AOP (AspectJ) 你该知晓的一切](https://blog.csdn.net/javazejian/article/details/56267036)
* [5] 其他


























































