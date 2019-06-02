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












































