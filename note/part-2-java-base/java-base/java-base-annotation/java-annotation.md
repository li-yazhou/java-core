# Java 注解

x. Java泛型的实现方法——类型擦除

x. 类型擦除后保留的原始类型

x. 泛型类中的静态方法和静态变量不可以使用泛型类所声明的泛型类型参数


---


## 注解Annotation
注解相当于一种标记，在程序中加了注解就等于为程序打上了某种标记。
没加，则等于没有某种标记，以后java编译器、开发工具和其他程序可以用反射来了解你的类及各种元素上有无何种标记，看你有什么标记，就去干相应的事。

标记可以加在包、类、方法、字段、方法的参数以及局部变量上。

java.lang包有JDK提供的最基本的Annotation。
> @SuppressWarnings("deprecation")
> @Deprecated//注释某个方法已经过时
> @Overide//覆写方法，可以帮助检查方法签名


## 开发注解类
注解就相当于一个你的源程序中要调用的一个类，要在源程序中应用某个注解，得先准备好了这个注解，就像你要调用某个类，得先开发好这个类。

定义注解

元注解、元数据、元信息//信息中的信息
```
    @Retention(RetentionPolicy.RUNTIME)//元注解
    @Target({ElementType.TYPE, ElementType.METHOD})
    public @interface AnnotationName
    {
        //给注解设置属性，以方法的形式访问
        String ID();
        String name();
        String gender() default "female";
        int[] arr() default {1, 2, 3};
        // 属性值类型是注解
        MetaAnnotation annotationAttr() default @MetaAnnotation(value="Lee");
    }
    
    public @interface MetaAnnotation {
        String value();
    }
```

@Retention有三种取值
* RetationPolicy.SOURCE，对应java源程序
* RetationPolicy.CLASS，对应class文件，默认保存到class文件阶段
* RetationPolicy.RUNTIME，对应内存中的字节码

@Override、@SupressWarnings和@Deprecated这三个注解的属性值分别是SOURCE、CLASS、RUNTIME三个阶段（可查看api）

为注解增加属性，如果只有一个value属性需要赋值，赋值时可省略 value=，即可简写为 @AnnotationName("blue")，
如 Retention(RetentionPolicy.RUNTIME)，其属性就是value，属性值类型是枚举。
```
@AnnotationName(color="red",value="blue")//一个注解，相等于在类中加入了一个对象
public class AnnotationTest
{
   public static void main(String[] args)
	{
	   if(AnnotationTest.class.isAnnotationPresent(AnnotationName.class))
	   {
	      AnnotationName annotation = (AnnotationName)AnnotationTest.class.getAnnotation(AnnotationName.class);
		  System.out.println("ID="+ annotation.ID());
		  System.out.println("Arr=" + Arrays.toString(annotation.arr()));
		  System.out.println("AnnotatonAttr=" + annotation.annotationAttr().value());
	   }
	}
}
```

@Target(ElementType.METHOD)//可用在方法上

@Target({Element.METHOD,ElementType.TYPE})//可用在方法和类上

Target的默认值为任何元素，设置Target等于ElementType.METHOD，原来加载类上的注解就报错了，

改为用数组方式设置{Element.METHOD,ElementType.TYPE}即可。

Type接口，是定义各种类型的关键字的父类，如 class,interface,enum,@interface。



---


## 注解的使用场景

可以通过注解的声明周期来分析注解的使用场景：

* SOURCE源码级别：给编译器使用，如@Override、@Deprecated 等， 这部分开发者应该使用的场景不多

* CLASS：字节码级别，这部分也很少见到

* RUNTIME：运行时级别，这个是最多的，几乎开发者使用到的注解都是运行时级别，运行时注解常用的有以下几种情况 

注解中没有任何属性的，空的注解，这部分注解通常起到一个标注的作用，如@Test、@Before、@After，通过获取这些标记注解在逻辑上做一些特殊的处理

可以使用约束注解@Constraint来对属性值进行校验，如@Email, @NotNull等

可以通过在注解中使用属性来配置一些参数，然后可以使用反射获取这些参数，这些注解没有其他特殊的功能，只是简单的代替xml配置的方式来配置一些参数。使用注解来配置参数这在Spring boot中得到了热捧，如@Configuration

关于配置方式xml vs annotation, 一般使用xml配置一些和业务关系不太紧密的配置，使用注解配置一些和业务密切相关的参数。


---


## 自定义注解应用示例

使用自定义注解+拦截器或者是AOP等可以进行权限的控制。
   
下面通过定义一个注解用来限制当用户访问接口时必须要登录的示例
   
### 步骤一：定义注解 
RequiresLogin.java
```
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiresLogin {

}
```
  
### 步骤二：使用注解
```
@Controller
@RequestMapping("/user")
public class UserController {
   @RequiresLogin
   @RequestMapping(value = "/list", produces = {"application/json;charset=UTF-8;"})
   public String getUserList(){

       System.out.println("--------------");
       return "[{'id': 1, 'username':'zhangsan'}]";
   }
}
```   

### 步骤三：使用AOP进行拦截，解析注解
   
```java
public class LoginAdvices {
   public void before(JoinPoint joinPoint) throws Exception{

       Object target = joinPoint.getTarget();
       String methodName = joinPoint.getSignature().getName();

       System.out.println(target + "-------" + methodName);
       Method method = target.getClass().getMethod(methodName);
       boolean annotationPresent = method.isAnnotationPresent(RequiresLogin.class);
       if (annotationPresent) {
           // 用户必须登录
           boolean isLogin = false;
           if (!isLogin) {
               throw new Exception("访问该接口必须先登录");
           } else {
               System.out.println("已登录...");
           }
       }
   }
}
```

在applicationContext.xml中配置aop
```
<bean id="loginAdvices" class="com.mengdee.manager.aop.LoginAdvices"/>
   <!-- aop配置 -->
   <aop:config proxy-target-class="true">
       <!--切面 -->
       <aop:aspect ref="loginAdvices">
           <!-- 切点 -->
           <aop:pointcut id="pointcut1" expression="execution(* com.mengdee.manager.controller.*.*(..))"/>
           <!--连接通知方法与切点 -->
           <aop:before method="before" pointcut-ref="pointcut1"/>
       </aop:aspect>
   </aop:config>
</bean>
```  






































