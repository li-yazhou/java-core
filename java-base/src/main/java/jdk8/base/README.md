## JDK8 基础

### 要点
- 方法引用
- lambda表达式，行为参数化
- 默认方法
- 流


### 常用的函数式接口

Predicate

谓词接口，谓词即它接受一个参数，并返回true或false。 
```
@FunctionalInterface
public interface Predicate<T> {

    boolean test(T t);
    
    // 其他默认方法 ...
    
}
```

文件过滤器接口
```
@FunctionalInterface
public interface FileFilter {

    boolean accept(File pathname);
    
}
```


　　函数式接口　　　　　　　　函数描述符　　　　　　原始类型特化

　　Predicate<T>     　　　　T -> boolean 　　　　 IntPredicate,LongPredicate,DoublePredicate

　　Consumer<T>　 　　　　T -> void　　　　　　 IntConsumer, LongConsumer, DoubleConsumer

　　Function<T, R>   　　　　T -> R　　　　　　    IntFunction<R>, IntToDoubleFunction, IntToLongFunction,LongFunction<R>, LongToDoubleFunction, LongToIntFunction, DoubleFunction<R>, ToIntFunction<T>, ToDoubleFunction<T>, ToLongFunction<T>

　　Supplier<T>　   　　　　 () -> T 　　　　　　  BooleanSupplier, IntSupplier, LongSuppier, DoubleSupplier

　　UnaryOperator<T>　 　  T -> T                     IntUnaryOperator, LongUnaryOperator, DoubleUnaryOperator

　　BinaryOperator<T>　　  (T, T) -> T　　　　    IntBinaryOperator, LongBinaryOperator, DoubleBinaryOperator

　　BiPredicate<L, R>　　　 (L, R) -> boolean　　

　　BiConsumer<T, U>　　　(T, U) -> void　　 　 ObjIntConsumer<T>, ObjLongConsumer<T>, ObjDoubleConsumer<T>

　　BiFunction<T, U, R>　　 (T, U) -> R　　　　　ToIntBiFunction<T, U>, ToLongBiFunction<T, U>, ToDoubleBiFunction<T, U>

