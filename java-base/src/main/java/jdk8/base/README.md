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

