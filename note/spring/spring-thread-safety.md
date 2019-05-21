# Spring中的线程安全性


## Bean的作用域与生命周期

Spring生成对象默认是单例的，通过scope属性可以更改为多例，也可以通过@Scope注解设置Bean的作用域。
```
<bean id="singleton" class="java.util.Date" scope="singleton"></bean>  
<bean id="prototype" class="java.util.Date" scope="prototype"></bean>  

@Scope("prototype")
```

Bean的作用域
* singleton作用域
* prototype作用域
* request作用域
* session作用域
* globalSession作用域


Bean的生命周期


---


## SpringMVC和Struts2中是并发访问否会存在线程安全问题
 
SpringMVC是基于方法的拦截，而Struts2是基于类的拦截。

对于Struts2来说，因为每次处理一个请求，struts就会实例化一个对象，这样就不会有线程安全的问题了。
而Spring的controller默认是Singleton的，这意味着每一个request过来，系统都会用原有的instance去处理，这样导致两个结果，
一是我们不用每次创建Controller，二是减少了对象创建和垃圾收集的时间，
由于只有一个Controller的instance，当多个线程调用它的时候，它里面的instance变量就不是线程安全的了，会发生窜数据的问题。

那为什么说Controller是不安全的呢？
原因就在于如果这个Controller对象是单例的，那么如果在类中定义了类变量，那么这个类变量是被所有请求共享的，这可能会造成多个请求修改该变量的值，出现与预期结果不符合的异常。
在单例的情况下 相当于所有类变量对于每次请求都是共享的，每一次请求对类变量的修改都是有效的。
 
当然大多数情况下，我们根本不需要考虑线程安全的问题，比如dao、service等，除非在bean中声明了实例变量。
因此，我们在使用SpringMVC 的Controller时，应避免在Controller中定义实例变量。 

```
public class Controller extends AbstractCommandController {    
    protected Company company;  
    protected ModelAndView handle(HttpServletRequest request,HttpServletResponse response,Object command,BindException errors) throws Exception {  
        // ...
    }             
}
```

线程安全性问题的解决方案如下：
* 在Controller中使用ThreadLocal变量，使用ThreadLocal来保存类变量，将类变量保存在线程的变量域中，让不同的请求隔离开来。
* 在spring配置文件Controller中声明 scope="prototype"，每次都创建新的controller，
    使用spring开发 web 时要注意，默认Controller、Dao、Service都是单例的。



## Spring与线程安全

Spring作为一个IOC/DI容器，帮助我们管理了许许多多的“bean”。
但其实，Spring并没有保证这些对象的线程安全，需要由开发者自己编写解决线程安全问题的代码。

Spring对每个bean提供了一个scope属性来表示该bean的作用域。
它是bean的生命周期。例如，一个scope为singleton的bean，在第一次被注入时，会创建为一个单例对象，该对象会一直被复用到应用结束。

* singleton：默认的scope，每个scope为singleton的bean都会被定义为一个单例对象，该对象的生命周期是与Spring IOC容器一致的（但在第一次被注入时才会创建）。
* prototype：bean被定义为在每次注入时都会创建一个新的对象。
* request：bean被定义为在每个HTTP请求中创建一个单例对象，也就是说在单个请求中都会复用这一个单例对象。
* session：bean被定义为在一个session的生命周期内创建一个单例对象。
* application：bean被定义为在ServletContext的生命周期中复用一个单例对象。
* websocket：bean被定义为在websocket的生命周期中复用一个单例对象。

我们交由Spring管理的大多数对象其实都是一些无状态的对象，这种不会因为多线程而导致状态被破坏的对象很适合Spring的默认scope，
每个单例的无状态对象都是线程安全的（也可以说只要是无状态的对象，不管单例多例都是线程安全的，不过单例毕竟节省了不断创建对象与GC的开销）。

无状态的对象即是自身没有状态的对象，自然也就不会因为多个线程的交替调度而破坏自身状态导致线程安全问题。
无状态对象包括我们经常使用的DO、DTO、VO这些只作为数据的**实体模型的贫血对象**，还有Service、DAO和Controller，
这些对象并没有自己的状态，它们只是用来执行某些操作的。例如，每个DAO提供的函数都只是对数据库的CRUD，
而且每个数据库Connection都作为函数的局部变量（局部变量是在用户栈中的，而且用户栈本身就是线程私有的内存区域，所以不存在线程安全问题），
用完即关（或交还给连接池）。

有人可能会认为，我使用request作用域不就可以避免每个请求之间的安全问题了吗？
这是完全错误的，因为Controller默认是单例的，一个HTTP请求是会被多个线程执行的，这就又回到了线程的安全问题。
当然，你也可以把Controller的scope改成prototype，实际上Struts2就是这么做的，
但有一点要注意，Spring MVC对请求的拦截粒度是基于每个方法的，而Struts2是基于每个类的，
所以把Controller设为多例将会频繁的创建与回收对象，严重影响到了性能。

通过阅读上文其实已经说的很清楚了，Spring根本就没有对bean的多线程安全问题做出任何保证与措施。
对于每个bean的线程安全问题，根本原因是每个bean自身的设计。
不要在bean中声明任何有状态的实例变量或类变量，如果必须如此，那么就使用ThreadLocal把变量变为线程私有的，
如果bean的实例变量或类变量需要在多个线程之间共享，那么就只能使用synchronized、lock、CAS等这些实现线程同步的方法了。

ThreadLocal是一个很好用的工具类，它在某些情况下解决了线程安全问题（在变量不需要被多个线程共享时）。


## 参考

* [1] [聊一聊Spring中的线程安全性](https://sylvanassun.github.io/2017/11/06/2017-11-06-spring_and_thread-safe/)
