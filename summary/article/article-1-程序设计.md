# 程序设计

## Java编程规范 java-coding-style-guide

* [甲骨文Java编码规约](https://wiki.sei.cmu.edu/confluence/display/java/SEI+CERT+Oracle+Coding+Standard+for+Java)
* [谷歌Java编码规约](https://google.github.io/styleguide/javaguide.html)
* [阿里巴巴Java编码规约](https://github.com/alibaba/p3c)
* [唯品会Java编码规约](https://vipshop.github.io/vjtools/#/standard/)
* [晓风轻技术小站编程规范](https://xwjie.github.io/rule/)



## 测试与调试


# 测试

* 测试方法
* Debug方法
* 测试工具
    * Junit
    * TestNG
    
## 测试方法


## DEBUG方法


## 测试工具

### Junit
### TestNG

trouble-shooting




## 日志



---


## 日志级别

**4种日志级别**
* Debug
* Info
* Warn
* Error

4种日志级别从上到下的级别依次升高，系统中会设置一种日志级别，则该日志级别以及高于该日志级别的日志均会被记录。

Log4j建议只使用四个级别，优先级从高到低分别是ERROR、WARN、INFO、DEBUG。

Log4j默认的优先级为ERROR或者WARN（实际上是ERROR）。

Log4j定义了8个日志级别，优先级从高到低依次为：OFF、FATAL、ERROR、WARN、INFO、DEBUG、TRACE、 ALL。


### DEBUG
DEBUG 指出细粒度信息事件对调试应用程序是非常有帮助的，主要用于开发过程中打印一些运行信息。


### INFO
INFO 日志在粗粒度级别上突出强调应用程序的运行过程。打印一些你感兴趣的或者重要的信息，这个可以用于生产环境中输出程序运行的一些重要信息，但是不能滥用，避免打印过多的日志。

从某种角度上说，INFO 输出的信息可以看作是软件产品的一部分（就像那些交互界面上的文字一样），所以需要谨慎对待，不可随便。


### WARN
WARN 表明会出现潜在错误的情形，有些信息不是错误信息，但是也要给程序员的一些提示。


### Error
ERROR 指出虽然发生错误事件，但仍然不影响系统的继续运行。打印错误和异常信息，如果不想输出太多的日志，可以使用这个级别。


### Fatal
FATAL level指出每个严重的错误事件将会导致应用程序的退出。


---


## Slf4J

slf4与log4j、logback关系

SLF4，The Simple Logging Facade for Java是什么？

笼统的讲就是slf4j是一系列的日志接口，而log4j和logback是具体实现了的日志框架。

> The Simple Logging Facade for Java (SLF4J) serves as a simple facade or abstraction for various logging frameworks, such as java.util.logging, logback and log4j. SLF4J allows the end-user to plug in the desired logging framework at deployment time. Note that SLF4J-enabling your library/application implies the addition of only a single mandatory dependency, namely slf4j-api-1.7.21.jar.

官方文档明确描述了三者的关系。slf4j译为简单日志门面，是日志框架的抽象。而log4j和logback是众多日志框架中的几种。

应用程序调用slf4j api，而日志的输出最终是由底层的日志框架来实现的。

logback是直接实现了slf4j的接口，是不消耗内存和计算开销的。而log4j不是对slf4j的原生实现，所以slf4j api在调用log4j时需要一个适配层。

slf4j是java的一个日志门面，提供了日志框架一些通用的api，log4j和logback是具体的日志框架。

log4j和logback可以单独的使用，也可以绑定slf4j一起使用。单独使用，则分别调用框架自己的方法来输出日志信息；绑定slf4j一起使用，则调用slf4j的api来输入日志信息，具体使用与底层日志框架无关（需要底层框架的配置文件）。

不推荐直接单独使用日志框架。假设项目中已经使用了log4j，而我们此时加载了一个类库，而这个类库依赖另一个日志框架。这个时候我们就需要维护两个日志框架，这是一个非常麻烦的事情。而使用了slf4j就不同了，由于应用调用的抽象层的api，与底层日志框架是无关的，因此可以任意更换日志框架。

使用slf4j绑定日志系统的优势
* 软件工程的角度。抽象，解耦，便于维护。
* 语法设计角度。slf4j有{}占位符，而log4j需要用“+”来连接字符串，既不利于阅读，同时消耗了内存（heap memory）。


---


## log4j与logback
log4j 是 apache的一个开源日志框架。

logback相对于log4j来说，更新一点，是由log4j的作者设计实现的，第一个版本是2011推出的。无论从设计上还是实现上，Logback相对log4j而言有了相对多的改进。

但是两者的用法几乎差别不大。下面是logback的优势：
* 更快的执行速度
* 充分的测试
* logback-classic 非常自然的实现了SLF4J
* 丰富的扩展文档
* 可以使用使用XML配置文件或者Groovy
* 自动重新载入配置文件
* 优雅地从I/O错误中恢复
* 自动清除旧的日志归档文件
* 自动压缩归档日志文件

以上，从性能的角度，可以尽快从log4j迁移到logback上来。


---


## slf4j绑定log4j

Log4J的配置文件(Configuration File)就是用来设置记录器的级别、存放器和布局的，它可接key=value格式的设置或xml格式的设置信息。通过配置，可以创建出Log4J的运行环境。

### properties格式配置
log4j.properties

### xml格式配置
log4j.xml


---


## slf4j绑定logback


---


## 资料
* [Slf4J 文档](https://www.slf4j.org/manual.html)
* [The Logback Manual](https://logback.qos.ch/manual/index.html)








































