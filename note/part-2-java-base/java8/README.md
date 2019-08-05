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

