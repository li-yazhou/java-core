# 设计模式

## 6大原则

- 单一职责原则
- 里氏替换原则
- 依赖倒置原则
- 接口隔离原则
- 迪米特原则
- 开闭原则


## 5个创建类模式

- 单例模式
- 原型模式
- 建造者模式
- 抽象工厂模式
- 工厂方法模式


## 7个结构类模式

- 组合模式
- 代理模式
- 装饰模式
- 适配器模式
- 享元模式
- 桥梁模式
- 门面模式


## 11个行为类模式

- 模板方法模式
- 策略模式
- 命令模式
- 状态模式
- 迭代器模式
- 解释器模式
- 观察者模式
- 访问者模式
- 中介者模式
- 备忘录模式
- 责任链模式


## 扩展的模式



### 策略模式

创建一个能够根据所传递的参数对象的不同而具有不同行为的方法。

通过传递不同对象和若干参数，实现传递该对象的某个方法及方法所需要的参数，通过执行该方法实现不同的行为。

将方法中的参数类型指定为接口，当调用该方法时传递不同实现类的对象作为实参，不同的对象调用同一个方法而具有不同的行为，这就是策略模式。


### 适配器模式

适配器中的代码将接收你拥有的接口，并产生你所需要的接口。

FilterAdapter 可以将 Filter 的接口转化为 Processor 的接口。
```
class FilterAdapter implements Processor {
    private Filter filter;
    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }
}
```


---


### 自动装箱与享元模式

2017年08月12日 15:23:54


## 自动装箱

代码示例
```
Integer i = 10;
Integer j = 128;
```
以上，可以把int型字面量直接赋值给Integer引用变量，jdk隐含了一步操作，将 int 型数字包装成Integer类型，这个升级是为了简化编程。

程序的升级一般包括三个目的中的至少一个：
> 提高安全性
> 简化编程
> 提高性能

小小的自动装箱背后隐藏着一个知识点，那就是享元模式，下面来聊聊它。


---


## 自动装箱中的享元模式 

自动装箱拆箱AutoBox示例代码：
```
int i = 10;
int j = 128;

Integer ii1 = i;
Integer ii2 = i;
System.out.println("ii == ij ? " + (ii1 == ii2));  // true，它们都是包装类型的对象，但是是同一个对象

Integer ij1 = j;
Integer ij2 = j;
System.out.println("ii == ij ? " + (ij1 == ij2)); // false，它们都是包装类型的对象，但是不是同一个对象
```
以上结果说明了什么？

答案是这样的，当-128~127之间的整数（byte类型的范围）初始化包装类型，自动装箱时，内存将其缓存起来，下次再次遇到**相等**的整数，则直接从缓存中取出即可，不需要再次创建该对象。

我们看看Integer的源代码中，其中包含了一个内部类IntegerCache，它默认缓存-128~127之间的整数包装类对象。

```
 /**
  * Cache to support the object identity semantics of autoboxing for values between
  * -128 and 127 (inclusive) as required by JLS.
  *
  * The cache is initialized on first usage.  The size of the cache
  * may be controlled by the {@code -XX:AutoBoxCacheMax=<size>} option.
  * During VM initialization, java.lang.Integer.IntegerCache.high property
  * may be set and saved in the private system properties in the
  * sun.misc.VM class.
  */

 private static class IntegerCache {
     static final int low = -128;
     static final int high;
     static final Integer cache[];

     static {
         // high value may be configured by property
         int h = 127;
         String integerCacheHighPropValue =
             sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
         if (integerCacheHighPropValue != null) {
             try {
                 int i = parseInt(integerCacheHighPropValue);
                 i = Math.max(i, 127);
                 // Maximum array size is Integer.MAX_VALUE
                 h = Math.min(i, Integer.MAX_VALUE - (-low) -1);
             } catch( NumberFormatException nfe) {
                 // If the property cannot be parsed into an int, ignore it.
             }
         }
         high = h;

         cache = new Integer[(high - low) + 1];
         int j = low;
         for(int k = 0; k < cache.length; k++)
             cache[k] = new Integer(j++);

         // range [-128, 127] must be interned (JLS7 5.1.7)
         assert IntegerCache.high >= 127;
     }

     private IntegerCache() {}
 }
```

**为什么要这么做呢？**
以-128~127之间的整数初始化包装类型，自动装箱时，因为这些数字使用频率较高且可能不被改变，内存可以缓存起来，这样就可以节省内存。这就是享元模式。


---


## 享元模式
    
经常使用一些在一定范围内的对象，而且这些对象一般不被改变，当使用该对象时，就把它创建并缓存起来，以后其他地方再次使用时， 直接从缓存中取出来即可，不用再次创建，这样可以避免创建新对象而造成的资源浪费（cpu和内存等资源）。

  比如，文本编辑器中字符，对于英文字母的话，就创建52个字母对象，没必要每写一个字符就创建一个对象，只是显示的位置不一样而已。
    还有，操作系统中的文件夹的图标，也都是一个对象，只是文件名和位置不同而已。

 这就是享元设计模式，它简单，正因为它很简单，所以它是设计模式，如果它很复杂，那么它就是设计模式了。

 如果有很多很小的对象，它们有很多相同的属性，那么可以把它们当作一个对象，对于不同的属性，把它变成外部属性，作为方法的参数传入。 相同的属性称为对象的内部状态，不同的属性称为对象的外部状态。


---


享元模式（Flyweight Pattern）是池技术的重要实现方式。它的定义如下：
> 使用共享对象可有效地支持大量的细粒度的对象。

享元模式的定义为我们提出了两个要求：细粒度的对象和共享对象。我们知道分配太多的对象到应用程序中将有损程序的性能，同时还容易造成内存溢出，那怎么避免呢？
就是享元模式提到的共享技术。


---


# 工厂方法模式
写作时间：2017-06-28 20:41

## 工厂方法模式的思路
第一，创建产品规范，也就是产品接口
第二，根据产品规范设计真实的产品，也就是使产品类实现产品接口
第三，结合产品规范，创建工厂规范，也就是工厂接口或者抽象类，产品规范作为工厂中抽象方法（生产线）的参数
第四，根据工厂规范创建工厂，此时工厂可以生产产品了


----------


## 举一个例子——生产手机
业务需求是，现在和将来一段时间要生产各种型号的手机。
所有的手机都满足手机的规范，比如包含打电话，上网，定位等功能。
现在，小米公司设计了小米手机，苹果公司设计了苹果手机，它们没有手机生产线。
有需求就有人做，富士康有大规模生产加工的经验和能力，它准备建立手机生产线。
只要给手机设计方案，富士康就能够产生出手机。
手机方案是满足手机规范的，工厂根据手机规范建设生产线。
生产线根据手机设计方案生产手机。

### 手机规范

```
public interface Phone {

    /**
     * 手机介绍自己的功能
     */
    void introduce();
}
```

### 手机产品设计方案
小米手机和苹果手机的设计方案

```
public class XiaomiPhone implements Phone {
    @Override
    public void introduce() {
        System.out.println("i am a xiaomi mobilephone");
    }
}


public class Iphone implements Phone {
    @Override
    public void introduce() {
        System.out.println("i am an iphone.");
    }
}
```
### 工厂规范
定义工厂的规范，工厂有一条手机生产线

```
public abstract class ExtractPhoneFactory {

    /**
     * 手机生产线
     * @param clazz 手机的设计方案
     * @param <T> 手机类型
     * @return 根据该类型手机的设计方案生产出来的手机
     */
    public abstract <T extends Phone> T createPhone(Class<T> clazz);
}
```

### 真实的工厂

```
public class PhoneFactory extends ExtractPhoneFactory {
    @Override
    public <T extends Phone> T createPhone(Class<T> clazz) {
        T phone = null;
        try{
            phone = (T)Class.forName(clazz.getName()).newInstance();
        } catch (Exception e){
            System.out.println("it goes wrong when creating phone.");
        }
        return phone;
    }
}
```

### 生产场景
当前，工厂可以生产小米手机和苹果手机

```
public class App {
    public static void main(String[] args){
        // 实例化工厂
        ExtractPhoneFactory phoneFactory = new PhoneFactory();

        // 为工厂的生产线 createPhone 传递一个手机设计方案 XiaomiPhone.class
        XiaomiPhone mi = phoneFactory.createPhone(XiaomiPhone.class);
        mi.introduce();

        Iphone iphone = phoneFactory.createPhone(Iphone.class);
        iphone.introduce();
    }
}
```
### 新的需求——生产华为手机

```
public class HuaweiPhone implements Phone {
    @Override
    public void introduce() {
        System.out.println("i am a huawei mobilephone.");
    }
}
```

### 新的生产场景

```
public class App {
    public static void main(String[] args){
        // 实例化工厂
        ExtractPhoneFactory phoneFactory = new PhoneFactory();

        // 为工厂的生产线 createPhone 传递一个手机设计方案 XiaomiPhone.class
        XiaomiPhone mi = phoneFactory.createPhone(XiaomiPhone.class);
        mi.introduce();

        Iphone iphone = phoneFactory.createPhone(Iphone.class);
        iphone.introduce();

        // 现在增加生产华为手机的业务，只需要创建一个实现了手机接口的手机设计方案类即可
        HuaweiPhone huawei = phoneFactory.createPhone(HuaweiPhone.class);
        huawei.introduce();
    }
}
```


----------


## 解释
工厂方法模式命名非常准确。在工厂方法模式中，有两个主体，产品和工厂。
产品一定要满足产品规范，工厂通过产品规范来设计生产线，工厂通过产品设计方案生产产品。
一般地，工厂也需要满足工厂规范。


----------


## 典型应用
JDBC 连接不同的数据库


----------


## 为什么需要工厂模式
提高程序的可扩展性，降低程序之间的耦合程度。
比如，已经有一个生产手机的工厂，它可以生产小米手机、苹果手机，
现在工厂接到生产华为手机的订单。怎么办？
工厂只需要华为的手机设计即可，也就是定义一个实现了手机规范的化为手机类即可。


----------


## 规范的作用
规范，也就是接口，或者是抽象类，
规范是各个模块通信的桥梁。它可以是各个具体模块之间耦合关系降低。


----------


## 工厂方法模式的弱化——静态工厂模式
简单工厂模式，也就是静态工厂模式
我们省略掉工厂规范，并将实际的工厂类中的方法设置为静态类型，此时就是静态工厂模式。
静态工厂模式的缺点是，工厂类的扩展比较困难。
