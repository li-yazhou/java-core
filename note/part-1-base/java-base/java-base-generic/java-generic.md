# 泛型


* 泛型基础
* 泛型的内部原理及更深应用
* 泛型的通配符扩展应用
* 泛型集合的综合应用案例
* 自定义泛型方法及其应用
* 自定义泛型方法的练习与类型推断总结
* 自定义泛型类的应用
* 通过反射获得泛型的实际类型参数


## 泛型基础

jdk1.5新特性，涉及到很多公式推导，设计起来极其复杂，因为要保证确定性。

泛型的好处：
* 1.编译时期的类型检查（猪圈、羊圈）
* 2.省去强制类型转化，编程更加简洁
  
```
	Constructor<String> constructor = String.class.getConstructor(StringBuffer.class);
	// 有了泛型，此处不用再使用强制类型转换
	String str = constructor.newInstance(new StringBuffer("123"));
```
	
集合类希望在定义集合时，明确表示你要向集合中装哪种类型的数据，无法加入指定类型以外的数据。


```
	List<String> strList = new ArrayList<String>();
	strList.add("abc");
	List<Integer> intList = new ArrayList<Integer>();
	intList.add(123);
	System.out.println(strList.getClass() == intList.getClass());
	// return true，编译之后泛型被类型擦除，集合没有了泛型信息
	// 反射可以绕过泛型类型的检查，插入"不安全"的数据，也即是非泛型类型的数据
	intList.getClass().getMethod("add", Object.class).invoke(intList, "abc");
```

由于类型擦除，所以可以利用反射向 List<Integer>对象中插入 String对象。

泛型是提供给 javac 编译器使用的，可以限定集合中的输入类型，让编译器挡住源程序中的非法输入，
编译器编译带类型说明的集合时会除掉泛型信息，使程序运行效率不受影响，对于参数化的泛型类型，getClass方法的返回值和原始类型完全一样。

由于编译生成的字节码会去掉泛型的类型信息，只要能跳过编译器，就可以往某个泛型集合中加入其他类型的数据，例如，用反射得到集合，再调用其 add方法即可。

    ArrayList<E>		泛型类型
    E					类型变量、类型参数
    ArrayList<Integer>	参数化类型（Parameterized Type），<> 读作 typeof
    Integer			    类型参数的实例、实际类型参数
    ArrayList			原始类型


## 参数化类型与原始类型的兼容性

参数化类型可以引用一个原始类型的对象，编译报告警告，例如 Collection<String> c = new Vector();
原始类型可以引用一个参数化类型的对象，编译报告警告，例如 Collection c = new Vector<String>();


参数化类型不考虑类型参数的继承关系
> Vector<String> v = new Vector<Object>();//Error，不写Object没错，写了就是明知故犯
>
> Vector<Object> v = new Vector<String>();//Error

> Vector v1 = new Vector<String>();
> 
> Vector<Object> v  = v1;//编译不会出错

泛型中的类型参数严格说明集合中装载的数据类型是什么和可以加入什么类型的数据，Collection<String>和Collection<Object>是两个没有转换关系的参数化的类型。

原因是，假设Vector<String> v = new Vector<Object>(); 可以的话，那么以后从v中取出的对象当作String用，而v实际指向的对象中可以加入任意类型的对象；

假设Vector<Object> v = new Vector<String>(); 可以的话，那么以后可以向V中加入任意的类型对象，而v实际指向的集合中只能装String类型的对象。

使用编译时类型和运行时类型类似的思路理解这种关系。


---


## 泛型数组
在创建数组实例时，数组的元素不能使用参数化的类型，例如，下面语句有错误：
> Vector<Integer>[] vectorList = new Vector<Integer>[10];


---


## 泛型通配符

泛型通配符？，可以匹配任意类型

打印任意集合中的元素
```
public static void printCollection(Collection<?> collection)//用泛型参数类型也可以
{
   //Collection<?>其中？不能改为Object类型，因为Collection<Object> coll = new ArrayList<Integer>();是错误的
}
```

总结：使用？通配符可以引用任何各种参数化的类型，？通配符定义的变量主要用作引用，可以调用与参数化无关的方法，不能调用与参数化有关的方法。

比如 collction可以调用 size方法，但不可以调用 add方法，因为add方法的参数类型是？，无法确定。
```
   Collection<?> coll = new HashSet<Date>();  // ok
   Collection<Object> coll = new HashSet<Date>(); // error
```

Collection<?> coll, coll可以与任意参数化的类型匹配，但到底匹配的是什么类型，只有以后才知道，
所以，coll = new ArrayList<Integer> 和 coll = new ArrayList<String>都可以，
但coll.add(new Date()) 或者 coll.add("element")等跟元素类型相关的操作都不可以。

Collection<Object> 中的Object只是说明Collection<Object>实例对象中的方法接受的参数是Object，
Collection<Object>是一种具体类型，new HashSet<Date>也是一种具体类型，两者没有兼容性问题。
```
    List<Double> tmpList = new ArrayList<Double>();
    tmpList.add(new Double("123.4"));
    List<? extends Number> numList = tmpList;
    // numList.add(new Double("123")); // Error
    System.out.println(numList.get(0));
```

对于泛型，通配符是万能类型，而Object不是，因为泛型类型没有继承关系。

限定通配符的上边界：
//不确定类型继承自某个类，只能传入该类的子类
Vector<? extends Number> x = new Vector<Integer>();

限定通配符的下边界，不确定类型是某个类的父类，只能传入该类的父类
> Vector<? super Integer> x = new Vector<Number>();

extends传其子类，super传其父类。

限定通配符总是包括自己。

？不能赋值给一个具体的类型，具体的类型可以赋值给？。
比如Class<?> Class.forName("java.lang.String");的返回类型是 Class<?>，类型参数不确定
```
   Class<String> clazz = Class.forName("java.lang.String");  // error
   Class<?> clazz = Class.forName("java.lang.String");  // OK
   Class clazz = Class.forName("java.lang.String");  // error
```


---


## 泛型方法及其应用
Java中的泛型类型（泛型）类似于C++中的模板。

但是这种相似性仅限于表面，Java语言中的泛型基本上完全是在编译器中实现，用于编译器执行类型检查和类型推断，然后生成普通的非泛型的字节码，这种实现技术称为檫除（erasure）。

编译器使用泛型类型信息保证类型安全，然后在生成字节码之前将其清除。

这是因为扩展虚拟机指令集来支持泛型被认为是无法接受的，这会为Java厂商升级其JVM造成难以逾越的障碍。

所以，Java的泛型采用了可以完全在编译器中实现的檫除方法。

```
private <T> T add(T x, T y){ return null; }
Integer x0 = add(3, 5);  // OK
Double x1 = add(2.5, 3);  // ERROR
Number x1 = add(2.5, 3);  // OK
Object x2 = add(2, "abc"); // OK
```
类型推断，取两个参数的公共的父类型。


泛型方法

交换任何类型数组的两个元素
```
public static <T> void swap(T[] arr,int i,int j)
{
	T tmp = arr[i];
	arr[i] = arr[j];
	arr[j] = tmp;
}
```

```
<T extends Serializable&Cloneable>

public <T> T autoConvertType(Object obj) {
    return (T)obj;
}
Object obj = "abc";
String str = autoConvertType(obj);  // 怎么将真实的类型参数传递给 T 的
```



```
// 把一个数组中的每个元素填充为一个值
public static <T> T[] fillArray(T[] arr,T obj)
{
   for(int i = 0; i < arr.length; i++)
	{
	    arr[i] = obj;
	}
}


public void printCollection(Collection<?> coll){
   for (Object obj : coll)
       System.out.println(obj);
}

public <T> void printCollection(Collection<T> coll){
   for(T t : coll)
       System.out.println(t);
}

```


以上采用通配符和自定义泛型方法的方式打印出任意参数化类型的集合中的所有内容。

在这种情况下，前面的通配符方案要比泛型方法更有效。

当一个类型变量用来表达两个参数之间或者参数和返回值之间的关系时，即同一个类型变量在方法签名的两处被使用，
或者类型变量在方法体代码中也被使用而不是仅在签名的时候使用，才需要使用泛型方法。如下。

此处没有必要声明泛型类型参数，直接使用通配符即可。
```
public <T> void handleCollection(Collection<T> coll, T element){
   coll.add(element);
}
```


---

## 型参数的类型推断
编译器判断泛型方法的实际类型参数的过程称为类型推断，类型推断是相对于知觉推断的，其实现方法是一种非常复杂的过程。

根据调用泛型方法时实际传递的参数类型或返回值的类型来推断，具体规则如下：

1. 当某个类型变量只在整个参数列表中的所有参数和返回值中的某一处被应用了，那么根据调用方法时该处的实际应用类型来确定，
着很容易凭感觉推断出来，即直接根据调用方法时传递的参数类型或返回值来决定泛型参数的类型，例如：
> swap(new String[3], 3, 4) --> static <E> void swap(E[] a, int i, int j)

2. 当某个类型变量在整个参数列表中的所有参数和返回值中的多处被应用了，如果调用方法时这多处的实际应用类型都对应同一种类型来确定，
这很容易凭借感觉推断出来，例如 
> add(3, 5) --> static <T> T add(T a, T b)

3. 当某个类型变量在整个参数列表中的所有参数和返回值中的多处被应用了，如果调用方法时这多处的实际应用类型对应到了不同的类型，且没有
使用返回值，这时候取多个参数中的最大交集类型（父类），例如，下面语句实际对应的类型就是Number了，编译没问题，只是运行时出问题：
> fill(new Integer[3], 2.5f)  --> static <T> void fill(T[] a, T v)

4. 当某个类型变量在整个参数列表中的所有参数和返回值中的多处被应用了，如果调用方法时这多处的实际应用类型对应到了不同的类型，并且使用返回，
这时候有限考虑返回值的类型，例如，下面语句实际对应的类型就是Integer了，编译将报告错误，将变量x的类型改为float，同样报告错误，
如果将变量x类型改为Number，则没有错误： 
> int x = add(2, 3.5f) --> static <T> T add(T a, T b)

5. 参数类型的类型推断具有传递性，下面第一种情况推断实际参数类型为Object，编译没有问题，而第二种情况则根据参数化的Vector类实例将类型变量
直接确定为String类型，编译将出现问题：
```
   copy(new Integer[5], new String[5]) --> static <T> void copy(T[] a, T[] b)
   copy(new Vector<String>(), new Integer[5]) --> static <T> void copy(Collection<T> a, T[] b)

   public static <T> void copy2(T[] dest,T[] src){}
   public static <T> void copy1(Collection<T> dest,T[] src){}
   copy1(new Vector<String>(),new String[10]);
   copy2(new Date[10],new String[10]);  // Object
   //copy1(new Vector<Date>(),new String[10]); // 已经将 T 指定为Date，报错
```


---


## 自定义泛型类的应用
静态方法不能使用类的泛型类型的参数，因为类型参数是在创建对象时才传入的。
```
public class GenericDao<E>{
   public static void update(E obj){} // ERROR
   public static <T> void update2(T obj){}  // OK，调用方法时传入类型参数
}
```


---


## 通过反射获得泛型的实际类型参数
获得方法的泛型类型，Hibernate等框架都有使用，可以完成类型自动转换。
```
public static void applyVector(Vector<Date> v){}

main{
    Method applyMethod = GenericTest.class.getMethod("applyVector",Vector.class);
    Type[] types = applyMethod.getGenericParameterTypes();  // Method的方法，可以获得参数的列表（带泛型信息）
    ParameterizedType pType = (ParameterizedType)types[0];
    System.out.println("原生类型：：" + pType.getRawType());//java.util.Vector
    System.out.println("泛型类型：：" + pType.getActualTypeArguments()[0]);//java.util.Date，可能有多个参数，如map集合
}
```


Type 和 ParameterizedType



























































