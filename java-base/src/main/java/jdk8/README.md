# JDK 8 新特性

## New Features

- Lambda expression − Adds functional processing capability to Java.

- Method references − Referencing functions by their names instead of invoking them directly. Using functions as parameter.

- Stream API − New stream API to facilitate pipeline processing.

- Default method − Interface to have default method implementation.

- Optional − Emphasis on best practices to handle null values properly.

- Date Time API − Improved date time API.

- New tools − New compiler tools and utilities are added like ‘jdeps’ to figure out dependencies.

- Nashorn, JavaScript Engine − A Java-based engine to execute JavaScript code.


## JDK8 基础

### 要点
- 方法引用
- lambda表达式，行为参数化
- 默认方法
- 流


### 常用的函数式接口

Predicate

```
// 谓词接口，谓词即它接受一个参数，并返回true或false。 
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t)
}


@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}


@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}


@FunctionalInterface
public interface Supplier<T> {
    T get();
}


```

文件过滤器接口
```
@FunctionalInterface
public interface FileFilter {

    boolean accept(File pathname);
    
}
```


| 函数式接口              | 函数描述符            | 原始类型特化 |
|-----------------------|---------------------|------------|
| Predicate<T>          | T -> boolean        |  IntPredicate,LongPredicate,DoublePredicate |
| Function<T, R>        | T -> R              |  IntFunction<R>, IntToDoubleFunction, IntToLongFunction,LongFunction<R>, LongToDoubleFunction, LongToIntFunction, DoubleFunction<R>, ToIntFunction<T>, ToDoubleFunction<T>, ToLongFunction<T> |
| Consumer<T>　 　　　　  | T -> void           |  IntConsumer, LongConsumer, DoubleConsumer  |
| Supplier<T>           | () -> T             |  BooleanSupplier, IntSupplier, LongSuppier, DoubleSupplier |
| UnaryOperator<T>      | T -> T              |  IntUnaryOperator, LongUnaryOperator, DoubleUnaryOperator |
| BinaryOperator<T>     | (T, T) -> T         |   IntBinaryOperator, LongBinaryOperator, DoubleBinaryOperator |
| BiPredicate<L, R>     | (L, R) -> boolean   | 　　|
| BiConsumer<T, U>      | (T, U) -> void      | 　ObjIntConsumer<T>, ObjLongConsumer<T>, ObjDoubleConsumer<T> |
| BiFunction<T, U, R>   | (T, U) -> R　　　　　 |  ToIntBiFunction<T, U>, ToLongBiFunction<T, U>, ToDoubleBiFunction<T, U> |


---


## Stream

Stream允许以声明的方式处理数据集合。Stream有以下特点：
- 声明性————更简洁、更易读
- 可复合————更灵活
- 可并行————性能更好

流，简短的定义就是从支持数据处理操作的源生成的元素序列。

**集合**讲的是数据，**流**讲的是计算。

哲学中的流和集合，可以把流看作在时间中分布的一组值，集合则是空间（计算机内存）中分布的一组值。
在一个时间点上全体存在，可以使用迭代器来访问for-each循环中的成员。

流只能遍历一次，和迭代器类似，遍历结束之后，表示这个流已经被消费掉了。

外部迭代与内部迭代。
使用Collection接口需要用户去做迭代（使用for-each或者迭代器），这称为外部迭代。
Stream库使用内部迭代，并把得到的流值存放起来，流将用户自定义的操作添加到内部迭代过程中。

流操作有两个重要的特点。
- 流水线————很多流操作会返回一个流，这样多个操作就可以链接起来，形成一个流水线。这样使**延迟和短路**等操作成为可能。流水线的操作可以看做对数据源进行数据库式查询。
- 内部迭代————与使用迭代器显示迭代的集合不同，流的迭代操作是在背后进行的。


流操作的类型
- 中间操作（转换操作），返回另外一个流的操作。
- 终端操作（动作操作），会从流的流水线生成结果，非Stream类型的数据。

除非流水线上触发一个**终端操作**，否则**中间操作**不会执行任何处理。

中间操作是懒操作，因为中间操作一般都可以合并起来，在终端操作时一次性全部处理。

将多个独立的操作合并到同一次遍历中，这种技术称为**循环合并**。

利用流的延迟性质实现循环合并，提升了工作效率。



