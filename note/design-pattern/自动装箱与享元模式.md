# 自动装箱与享元模式

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


## 参考
*《设计模式之禅》
*《Java基础强化》

