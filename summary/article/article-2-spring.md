# Spring

- 常用注解
- IOC
- AOP
- Schedule
- 事务


## Spring 开发资料
* [Spring官方文档](https://spring.io/projects/spring-framework#learn)
* [Spring4 官方文档](https://docs.spring.io/spring/docs/4.3.24.RELEASE/spring-framework-reference/htmlsingle/)
* [Spring5 官方文档](https://docs.spring.io/spring/docs/5.1.7.RELEASE/spring-framework-reference/)



# spring-annotations

## 常用注解

| 注解 | 描述 |
|---|---|
| @Component |泛指组件，当组件不好归类时，可以使用这个注解进行标注 |
| @Controller | 用于标注控制层组件，其标记在一个类上，使用它标记的类就是一个SpringMVC Controller对象，分发处理器将会扫描使用了该注解的类的方法，并检测该方法是否使用了@RequestMapping注解，可以把Request请求header部分的值绑定到方法的参数上 |
| @Service | 用于注解业务层组件，在Service的实现类上注解 |
| @Repository | 用于注解DAO层组件，在Dao的实现类上注解 |
|||
| @RestController | 相当于@Contoller和@ResponseBody的组合 |
| @ResponseBody | 异步请求，该注解用于将Controller的方法返回的对象，通过适当的HttpMessageConverter转换为指定格式后，写入到Response对象的body数据区。返回的数据不是html页面，而是其他的某种格式的数据时使用，如json、xml等 |
| @RequestMapping | 一个用于处理请求地址映射的注解，可用于类或非法上，用于类上表示类中的所有响应请求的方法都是以该地址作为父路径 |
| @Autowired | 可以标注类的成员变量、方法及构造方法，完成自动装配的工作，通过@Autowired的使用来消除set、get方法 |
| @PathVariable | 用于将请求URL中的模板变量映射到功能处理方法的参数上，即取出URL模板中的变量作为参数 |
| @RequestParam | 主要用于在SpringMVC后台控制层获取参数，类似是 request.getParameter("name") |
| @RequestHandler | 可以把Request请求header部分的值绑定到方法的参数上 | 
|||
| @ModelAttribute | 该Controller的所有方法在调用前，先执行才@ModelAttribute方法，可用于注解方法参数中，可以把这个@ModelAttribute特性应用在BaseController当中，所偶的Controller继承BaseController，即可以实现调用Controller时，先执行@ModelAttribute方法 |
| @SessionAttributes | 即将值放到session作用域中，写在类上面 | 
| @Valid | 实体数据校验，可以结合hibernate validator一起使用 |
| @CookieValue | 用来获取Cookie中的值 |






# Spring IOC
# spring-ioc

## IOC 概念

IOC，是 Inversion of Control 的缩写，控制反转之意。

控制反转IoC(Inversion of Control)是说创建对象的控制权进行转移，以前创建对象的主动权和创建时机是由自己把控的，
而现在这种权力转移到第三方，比如转移交给了IoC容器，它就是一个专门用来创建对象的工厂，
你要什么对象，它就给你什么对象，有了 IoC容器，依赖关系就变了，原先的依赖关系就没了，它们都依赖IoC容器了，通过IoC容器来建立它们之间的关系。

控制的什么被反转了？获得依赖对象的方式反转了。

IOC的核心思想，也就是它要解决的问题：由容器来负责控制对象的生命周期和对象间的关系，让你脱离对依赖对象的维护，只需要随用随取，不需要关心依赖对象的任何过程。

IoC的一个重点是在系统运行中，动态的向某个对象提供它所需要的其他对象。这一点是通过DI（Dependency Injection，依赖注入）来实现的。

IoC 本身并不能算为一种技术，而是一种思想，它使你从繁琐的对象交互中解脱出来，而专注于对象本身，更进一步突出面向对象。

IoC 可以说是spring最核心的部分，是spring家族任意组件的基本。


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


IOC与DI的区别如下：
* IOC 控制反转，将对象的创建权，由Spring管理。
* DI 依赖注入，在Spring创建对象的过程中，把对象依赖的属性注入到类中。


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

### 基于注解的自动装配与Autowired、@Resource和@Value

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

可以使用Autowired和Qualifier解决多个相同类型的bean如何共存的问题。

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
* spring-web.xml 文件：web层相关bean声明 
* spring-service.xml文件：service层相关bean声明 
* spring-dao.xml 文件：dao层相关bean声明 
* spring-tx.xml 文件：事务相关bean和规则声明 
* spring-security.xml 文件：安全相关声明 
* spring-application.xml 文件：汇聚文件或总bean声明


### Bean的延迟加载



## context component-scan 与 context annotation-config


## Spring IOC 运行简析

首先，定义一个Bean类，这个类用来存放一个Bean拥有的属性。
```
    /* Bean Id */
	private String id;
	/* Bean Class */
	private String type;
	/* Bean Property */
	private Map<String, Object> properties = new HashMap<String, Object>();
```
Bean包括id,type,和Properties。 


接下来，Spring就开始加载配置文件，并将配置的信息保存在一个HashMap中，
HashMap的key就是Bean 的 Id ，HasMap 的value是这个Bean，
这样可以通过context.getBean("student")方法获得Student这个类的实例。
Spring不仅可以注入基本类型，而且可以注入像List，Map这样的类型，接下来以Map为例分析Spring是怎么保存数据的。

Bean的配置信息如下。
```
<bean id="test" class="Test">
		<property name="testMap">
			<map>
				<entry key="a">
					<value>1</value>
				</entry>
				<entry key="b">
					<value>2</value>
				</entry>
			</map>
		</property>
	</bean>
```


```
if (beanProperty.element("map") != null) {
    Map<String, Object> propertiesMap = new HashMap<String, Object>();
    Element propertiesListMap = (Element) beanProperty
            .elements().get(0);
    Iterator<?> propertiesIterator = propertiesListMap
            .elements().iterator();
    while (propertiesIterator.hasNext()) {
        Element vet = (Element) propertiesIterator.next();
        if (vet.getName().equals("entry")) {
            String key = vet.attributeValue("key");
            Iterator<?> valuesIterator = vet.elements()
                    .iterator();
            while (valuesIterator.hasNext()) {
                Element value = (Element) valuesIterator.next();
                if (value.getName().equals("value")) {
                    propertiesMap.put(key, value.getText());
                }
                if (value.getName().equals("ref")) {
                    propertiesMap.put(key, new String[] { value
                            .attributeValue("bean") });
                }
            }
        }
    }
    bean.getProperties().put(name, propertiesMap);
```


接下来就是最核心部分 —— Spring是怎么依赖注入的。其实依赖注入的思想很简单，它是通过反射机制实现的。
在实例化一个类时，它通过反射调用类中set方法将事先保存在HashMap中的类属性注入到类中。
首先，实例化一个对象。
```
public static Object newInstance(String className) {
		Class<?> cls = null;
		Object obj = null;
		try {
			cls = Class.forName(className);
			obj = cls.newInstance();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		return obj;
	}
```

然后，将这个类的依赖注入。
```
public static void setProperty(Object obj, String name, String value) {
		Class<? extends Object> clazz = obj.getClass();
		try {
			String methodName = returnSetMthodName(name);
			Method[] ms = clazz.getMethods();
			for (Method m : ms) {
				if (m.getName().equals(methodName)) {
					if (m.getParameterTypes().length == 1) {
						Class<?> clazzParameterType = m.getParameterTypes()[0];
						setFieldValue(clazzParameterType.getName(), value, m,
								obj);
						break;
					}
				}
			}
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
}
```

注入Map对象的过程如下。
```
if (value instanceof Map) {
    Iterator<?> entryIterator = ((Map<?, ?>) value).entrySet()
            .iterator();
    Map<String, Object> map = new HashMap<String, Object>();
    while (entryIterator.hasNext()) {
        Entry<?, ?> entryMap = (Entry<?, ?>) entryIterator.next();
        if (entryMap.getValue() instanceof String[]) {
            map.put((String) entryMap.getKey(),
                    getBean(((String[]) entryMap.getValue())[0]));
        }
    }
    BeanProcesser.setProperty(obj, property, map);
}
```

至此，Spring 完成了对象的创建。

Spring 运行简析仅仅分析了最核心的依赖注入功能中的小小的一部分，更多细节之处可以参阅源码。 


---


## 参考
* [1] [Spring4: The IoC container](https://docs.spring.io/spring/docs/4.3.24.RELEASE/spring-framework-reference/htmlsingle/#beans)
* [2] [关于SpringIOC你需要知道的一切](https://blog.csdn.net/javazejian/article/details/54561302)
* [3] [IoC--Spring的灵魂](https://juejin.im/post/593386ca2f301e00584f8036#heading-4)
* [4] [spring ioc原理](https://blog.csdn.net/it_man/article/details/4402245)
* [5] 其他

本文参考了大量资料，没有一一列举，在此表示对作者的感谢。





# Spring 定时任务


使用Spring定时任务

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
       xmlns:task="http://www.springframework.org/schema/task"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
        http://www.springframework.org/schema/beans/spring-beans.xsd 
        http://www.springframework.org/schema/task 
        http://www.springframework.org/schema/task/spring-task-3.0.xsd">

    <bean id="springScheduledTask" class="org.alpha.SpringScheduledTask" />
    <task:scheduled-tasks>
        <task:scheduled ref="springScheduledTask" method="startCollect" cron="${sampling.time}"/>
        <task:scheduled ref="springScheduledTask" method="startManage" cron="${manage.time}"/>
        <task:scheduled ref="springScheduledTask" method="startTakeSnapshot" cron="${snapshot.time}"/>
    </task:scheduled-tasks>

    <task:scheduler id="myScheduler" pool-size="5"/>
    <task:annotation-driven scheduler="myScheduler"/> 
    
    <!--<task:annotation-driven />-->
</beans>
```


除了可以在task:scheduled标签中指定调度时间属性cron之外，也可以在方法上使用@Scheduled注解，指定调度时间cron。
```
@Component  // import org.springframework.stereotype.Component
public class SpringScheduledTask implements ISpringScheduledTask {
      @Scheduled(cron="0/5 * *  * * ? ")   // 每5秒执行一次
      @Override
      public void startCollect() { 
          System.out.println("Enter startCollect ...");
      }
}
```


使用Spring定时任务时，需要注意的是：
* 实现类上要有组件的注解@Component
* Spring的@Scheduled注解需要写在实现上
* 定时器的任务方法不能有返回值，如果有返回值，spring初始化时会报错
* corn表达式
* 推荐配置定时任务的线程池，Spring的定时任务默认是单线程，多个任务执行起来时间会有问题，B任务会因为A任务执行起来需要20S而被延后20S执行




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


---


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


---


## 参考

* [1] [聊一聊Spring中的线程安全性](https://sylvanassun.github.io/2017/11/06/2017-11-06-spring_and_thread-safe/)


















































# Spring AOP


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









































1. [Spring 框架的设计理念与设计模式分析](https://www.ibm.com/developerworks/cn/java/j-lo-spring-principle/)
1. [Spring IOC核心源码学习](http://yikun.github.io/2015/05/29/Spring-IOC%E6%A0%B8%E5%BF%83%E6%BA%90%E7%A0%81%E5%AD%A6%E4%B9%A0/)
1. [Spring AOP的一点总结](https://www.jianshu.com/p/4fe5a75b9202)
1. [springMVC学习笔记(一)-----springMVC原理](https://www.cnblogs.com/selene/p/4658554.html)
1. [Bean的生命周期](http://wiki.jikexueyuan.com/project/spring/bean-life-cycle.html)





# spring 事务机制


## Spring事务传播机制
 
 
Propagation支持7种不同的传播机制：
 
REQUIRED：如果存在一个事务，则支持当前事务。如果没有事务则开启一个新的事务。
 
SUPPORTS： 如果存在一个事务，支持当前事务。如果没有事务，则非事务的执行。但是对于事务同步的事务管理器，PROPAGATION_SUPPORTS与不使用事务有少许不同。
 
NOT_SUPPORTED：总是非事务地执行，并挂起任何存在的事务。
 
REQUIRESNEW：总是开启一个新的事务。如果一个事务已经存在，则将这个存在的事务挂起。
 
MANDATORY：如果已经存在一个事务，支持当前事务。如果没有一个活动的事务，则抛出异常。
 
NEVER：总是非事务地执行，如果存在一个活动事务，则抛出异常。
 
NESTED：如果一个活动的事务存在，则运行在一个嵌套的事务中。如果没有活动事务，则按REQUIRED属性执行。
 
 
 
当异常被捕获时，默认情况下，事务不会回滚。
默认情况下，在发生RuntionException和Error时会触发回滚操作。
 
 
 
 
 
 
 
 
 

















































# springmvc-interceptor