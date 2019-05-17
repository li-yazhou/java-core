# spring-ioc

## IOC 概念

IOC，是 Inversion of Control 的缩写，控制反转之意。控制的什么被反转了？获得依赖对象的方式反转了。

IoC 可以说是spring最核心的部分，是spring家族任意组件的基本。
IoC 本身并不能算为一种技术，而是一种思想，它使你从繁琐的对象交互中解脱出来，而专注于对象本身，更进一步突出面向对象。

IOC的核心思想，也就是它要解决的问题：由容器来负责控制对象的生命周期和对象间的关系，让你脱离对依赖对象的维护，只需要随用随取，不需要关心依赖对象的任何过程。


---


## IOC 的技术实现方式

如何将依赖的对象准备好呢（依赖注入），常用的有两种方式：构造方法注入和setter注入。

构造器注入，它就代表了当Person这个对象生成时，就准备好了依赖的对象。
```
public Person(Food food) {
    this.food = food;
}
```

setter注入，有所不同，需要使用setter方法指定依赖的对象。
```
public void setFood(Food food) {
    this.food = food;
}
```


---


## IOC 容器

IOC 需要一系列技术要实现。
首先它需要知道服务的对象是谁，以及需要为服务对象提供什么样的服务。
提供的服务指：要完成对象的构建（即把饭做好），将其送到服务对象即完成对象的绑定（即把饭端到我面前）。

Ioc需要实现两个技术：
* 对象的构建
* 对象的绑定

对于这两个方面技术的实现具有很多的方式：
* 硬编码（Ioc 框架都支持）
* 配置文件
* 注解（最洁的方式）

但无论哪种方式都是在Ioc容器里面实现的，可以理解为一个大池子，里面躺着各种各样的对象，并能通过一定的方式将它们联系起来。


Spring IOC 也是一个java对象，在某些特定的时间被创建后，可以进行对其他对象的控制，包括初始化、创建、销毁等。
简单地理解，在上述过程中，我们通过配置文件配置了**实现类的完全限定名**，然后利用反射在运行时为**接口**创建实际实现类，
而我们唯一要做的就是，把需要创建的类和其他类依赖的类以配置文件的方式告诉IOC容器需要创建那些类和注入哪些类即可。

Spring通过这种控制反转（IoC）的设计模式促进了松耦合，这种方式使一个对象依赖其它对象时会通过被动的方式传送进来，
如BookServiceImpl被创建时，其依赖的BookDao的实现类也会同时被注入BookServiceImpl中，而不是通过手动创建这些类。

可以把IoC模式看做是工厂模式的升华，可以把IoC看作是一个大工厂，这个大工厂里要生成的对象都是在配置文件(XML)中给出定义的，然后利用Java的反射技术，根据XML中给出的类名生成相应的对象。
从某种程度上来说，IoC相当于把在工厂方法里通过**硬编码**创建对象的代码，改变为由XML文件来定义，也就是把工厂和对象生成这两者独立分隔开来，目的就是提高灵活性和可维护性，更是达到最低的耦合度，
因此我们要明白所谓的IOC，就是将对象的创建权交由Spring完成，从此解放手动创建对象的过程，同时让类与类间的关系到达最低耦合度。


Spring提供了两种类型的容器，一个是BeanFactory,一个是ApplicationContext(可以认为是BeanFactory的扩展)，下面将介绍这两种容器如何实现对对象的管理。


### BeanFactory

如果没有特殊指定，默认采用延迟初始化策略(lazy-load)。
只有当客户端对象需要访问容器中的某个受管对象的时候，才对 该受管对象进行初始化以及依赖注入操作。
所以，相对来说，容器启动初期速度较快，所需 要的资源有限。
对于资源有限，并且功能要求不是很严格的场景，BeanFactory是比较合适的 IoC 容器选择。

BeanFactory类的关系图
![BeanFactory类的关系图](img/BeanFactory类图.png)


### ApplicationContext


---


## Spring依赖注入

DI，Dependency Injection，依赖注入。依赖注入就是将服务注入到使用它的地方。

对象只提供普通的方法让容器去决定依赖关系，容器全权负责组件的装配，它会把符合依赖关系的对象通过属性（JavaBean中的setter）或者是构造子传递给需要的对象。

相对于IoC而言，依赖注入(DI)更加准确地描述了IoC的设计理念。

所谓依赖注入，即组件之间的依赖关系由容器在应用系统运行期来决定，也就是由容器动态地将某种依赖关系的目标对象实例注入到应用系统中的各个关联的组件之中。


Spring依赖注入
* Setter注入

* 构造方法注入

* 循环依赖

* 自动装配与注解注入
    * 基于xml的自动装配
    * 基于注解的自动装配与AutowiredResourceValue
        * 基于Autowired注解的自动装配
        * 基于JavaEE Resource注解的自动装配
        * 基于Value注解的自动装配以及properties文件读取

### 基于注解的自动装配与AutowiredResourceValue

1. 基于@Autowired注解的自动装配

@Autowired 可以标注成员变量、标注构造方法、标注set方法。
我们通过3种方式注入实例，xml配置文件只需声明bean的实例即可，
在实际开发中，我们只需选择其中一种进行注入操作即可，建议使用成员变量注入，这样可以省略set方法和构造方法，相当简洁。

在@Autowired中还传递了一个required=false的属性，false指明当userDao实例存在就注入不存就忽略，
如果为true，就必须注入，若userDao实例不存在，就抛出异常。

由于默认情况下@Autowired是按类型匹配的(byType)，如果需要按名称(byName)匹配的话，
可以使用@Qualifier注解与@Autowired结合，请注意必须在xml配置中启动注解驱动。
```
<!-- 使用注解时必须启动注解驱动 -->
<context:annotation-config />
```


2. 基于@Resource注解的自动装配

与@Autowried具备相同功效的还有@Resource，默认按 byName模式 自动注入,由J2EE提供，需导入Package: javax.annotation.Resource，
可以标注在成员变量和set方法上，但无法标注构造函数。@Resource有两个中重要的属性：name和type。
Spring容器对于@Resource注解的name属性解析为bean的名字，type属性则解析为bean的类型。
因此使用name属性，则按byName模式的自动注入策略，如果使用type属性则按 byType模式自动注入策略。
倘若既不指定name也不指定type属性，Spring容器将通过反射技术默认按byName模式注入。
```
//@Autowired标注成员变量
@Autowired
@Qualifier("userDao")
private UserDao userDao;  
//上述代码等价于@Resource
@Resource(name=“userDao”)
private UserDao  userDao;//用于成员变量

//也可以用于set方法标注
@Resource(name=“userDao”)
public void setUserDao(UserDao userDao) {
   this.userDao= userDao;
}
```


3. 基于@Value注解的自动装配以及properties文件读取


关于@Autowired和@Resource都分析完了，但这里存在一个问题，上述两种自动装配的依赖注入并不适合简单值类型，如int、boolean、long、String以及Enum等，对于这些类型，Spring容器也提供了@Value注入的方式，这是非常具备人性化的，可以解决很多硬编码问题。@Value接收一个String的值，该值指定了将要被注入到内置的java类型属性值，放心，不必关系类型转换，大多数情况下Spring容器都会自动处理好的。一般情况下@Value会与properties文件结合使用，也分两种情况一种是SpEL（有点类似于jsp的EL），另外一种是占位符方式，看一个简单例子jdbc.properties文件如下：

jdbc.driver=com.mysql.jdbc.Driver
jdbc.username=admin

利用注解@Value获取jdbc.driver和jdbc.username的值，实现如下：

```
    //占位符方式
    @Value("${jdbc.driver}") private String driver;
    
    //SpEL表达方式，其中代表xml配置文件中的id值configProperties
    @Value("#{configProperties['jdbc.username']}")
    private String userName;
```

基于xml的配置如下：
```
<beans xmlns="...">
    <!--基于占位符方式 配置单个properties -->
    <!--<context:property-placeholder location="conf/jdbc.properties"/>-->
    <!--基于占位符方式 配置多个properties -->
    <bean id="propertyConfigurer" class="org.springframework.beans.factory.config.PreferencesPlaceholderConfigurer">
        <property name="location" value="conf/jdbc.properties"/>
    </bean>

    <!--基于SpEL表达式 配置多个properties id值为configProperties 提供java代码中使用 -->
    <bean id="configProperties" class="org.springframework.beans.factory.config.PropertiesFactoryBean">
        <property name="locations">
            <list>
                <value>classpath:/conf/jdbc.properties</value>
            </list>
        </property>
    </bean>

    <!--基于SpEL表达式 配置单个properties -->
    <!--<util:properties id="configProperties" location="classpath:conf/jdbc.properties"/>-->

    <!--注解驱动 -->
    <context:annotation-config/>
</beans>
```


同一接口有多个实现类，如何注入呢？

@Autowired、@Qualifier、@Resource

* @Autowired 是通过 byType 的方式去注入的，使用该注解，要求接口只能有一个实现类。
* @Qualifier 注解可以按名称注入， 但是注意是**类名**。
```
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;
```
* @Resource 注解属于J2EE的，它可以通过 byName 和 byType 的方式注入，默认先按 byName 的方式进行匹配，如果匹配不到，再按 byType 的方式进行匹配。


## SpringIOC容器管理Bean

### Bean的命名

每一个交给Spring IOC（后面统称Spring容器）容器创建的对象必须被分配至少一个名称，
如果开发者没有提供，Spring容器将会为其分配一个内部名称，通过Bean的名称，我们可以在其他类中查找该类并使用它，
如前面的案例，也是通过Bean名称获取到实际对象并执行对应的操作。
在基于xml的配置信息中，可以使用id属性来为一个Bean分配名称，在同一个xml配置文件中，id必须是唯一的，
但不同的xml可以相同，当然还可以使用name来为Bean分配名称，name属性可以分配多个名称，
此时可使用空格、逗号、分号来分离给定Bean分配多个名称，而id属性则无法这样使用。


上述的Bean对象声明使用都在xml内声明手动声明的方式，一旦Bean对象多起来，管理Bean可能会发生繁琐的情况，
为了Spring提供了基于Java注解的配置方式，使用 org.springframework.stereotype.Service（@Service）
和org.springframework.stereotype.Repository（@Repository）声明**接口的实现类**，
然后使用@Autowired注解为接口声明的引用注入对象，需要在xml声明注解驱动。

```
//@Component 相同效果
@Service
public class AccountServiceImpl implements AccountService {
  @Autowired
  private AccountDao accountDao;
}

//@Component 相同效果
@Repository
public class AccountDaoImpl implements AccountDao{}
```

有了注解声明，就不需要在xml中声明Bean，但需要明确告诉Spring注解的Bean在那些包下，因此需要添加包扫描机制，此时需要启用Spring的context命名空间。
```
<beans xmlns="...">
    <!-- 声明包扫描 -->
    <context:component-scan base-package="com.zejian.spring.springIoc" />
</beans>
```


声明方式与之前在xml声明bean的效果相同。
这里我们需要明白可以使用@Component注解达到与@Service和@Repository的效果，
@Component与@Service的含义并无差异，只不过@Service更能让我们明白该类为业务类罢了。
至于@Repository在表示数据访问层含义的同时还能够启用与Spring数据访问相关链的其他功能
（这个在Spring jdbc相关内容时再详谈，此时我们只需明白@Repository与@Component等效即可），
同时还可给@Component、@Service和@Repository输入一个String值的名称，如果没有提供名称，
那么默认情况下就是一个简单的类名(第一个字符小写)变成Bean名称。


Spring的框架中提供了与@Component注解等效的三个注解，@Repository 用于对DAO实现类进行标注，
@Service 用于对Service实现类进行标注，
@Controller 用于对Controller实现类进行标注（web层控制器），
同时也了解了Spring 容器通过xml的bean标签配置和java注解两种方式声明的Bean对象，
我们可以单独使用其中一种也可以两种混合使用，取决于各自的需求。


### Bean的实例化方法

在日常开发中创建对象的最常用的就是通过类的构造方法，事实上Spring容器也是正常情况下也是通过构造方法创建bean的。

```
public class Account {
    private String name;
    private String pwd;

    public Account(){}

    public Account(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }
    
    // setter/getter
```

在xml中配置
```
<!-- 默认构造创建,并通过property 注入属性值 -->
<bean id="account" class="pojo.Account" >
    <property name="name" value="Jack" />
    <property name="pwd" value="123" />
</bean>

<!-- 带参构造创建,并通过constructor-arg注入属性值 -->
<bean id="account2" class="pojo.Account" >
    <constructor-arg name="name" value="Jack" />
    <constructor-arg name="pwd" value="1234" />
</bean>
```


### Bean的重写机制
Bean的重写机制并没有那么神秘，主要是当不同的xml文件中出现同名id属性的bean时读取的优先级问题。

Bean的重写机制原则是当声明的bean的名称一样时，后者会覆盖前者。

我们还需要明确的一点时，在web应用开发过程中，一般都会将配置进行分层管理，
然后通过一个主springApplication.xml来聚合它，在这样的情况下分层的配置文件属于springApplication.xml的子文件，
在这样的关系遇到上述的情况一般都子文件的优先级高，因此会加载子文件的bean。


关于分层管理开发一般按如下方式（这样的好处是脉络清晰，方便管理）：
* spring-web.xml文件：web层相关bean声明 
* spring-service.xml文件：service层相关bean声明 
* spring-dao.xml文件：dao层相关bean声明 
* spring-tx.xml文件：事务相关bean和规则声明 
* spring-security.xml文件：安全相关声明 
* spring-application.xml 文件：汇聚文件或总bean声明


### Bean的作用域
* singleton作用域

* prototype作用域

* request与session作用域

* globalSession作用域


### Bean的延迟加载



## context component-scan与context annotation-config




## 参考
* [1] [Spring官方文档](https://spring.io/projects/spring-framework#learn)
* [2] [关于SpringIOC你需要知道的一切](https://blog.csdn.net/javazejian/article/details/54561302)
* [3] [IoC--Spring的灵魂](https://juejin.im/post/593386ca2f301e00584f8036#heading-4)
* [4] 其他





























