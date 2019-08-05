package jdk8.base.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * <p>Description: <p/>
 *
 * @author liyazhou1
 * @date 2018/7/28
 */
public class FunctionalInterfaceDemo {

    /*
        函数式接口，就是指定一个抽象方法的接口。

        函数式接口中的抽象方法是Lambda表达式的规范。

     */

    /*
        java.util.function package 包含一系列的函数式接口。下面介绍几个常用的函数式接口。
            @FunctionalInterface
            public interface Predicate<T> {
                boolean test(T t)
            }

            @FunctionalInterface
            public interface Consumer<T> {
                void accept(T t);
            }

            @FunctionalInterface
            public interface Function<T, R> {
                R apply(T t);
            }

            @FunctionalInterface
            public interface Supplier<T> {
                T get();
            }


            原始类型特化，避免装箱操作，提高程序运行效率
            FunctionalInterface
            public interface IntFunction<R> {
                R apply(int t);
            }

            FunctionalInterface
            public interface ToIntFunction<T> {
                int apply(T t);
            }



     */

    public static List<Integer> range(int start, int end) {
        if (start >= end) {
            return Collections.emptyList();
        }
        List<Integer> range = new ArrayList<>();
        for (int i = start; i < end; i ++) {
            range.add(i);
        }
        return range;
    }


    /*
     *  程序通用性较强，可以自定义多种过滤条件，通过 Predicate 对象传入过滤条件
     */
    private List<Integer> filter(List<Integer> integerList, Predicate<Integer> predicate) {
        if (integerList == null || integerList.isEmpty()) return Collections.emptyList();
        List<Integer> filteredIntegerList = new ArrayList<>();
        for (int element : integerList) {
            if (predicate.test(element)) {
                filteredIntegerList.add(element);
            }
        }
        return filteredIntegerList;
    }


    @Test
    public void predicate() {
        // List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> intList = range(0, 10);

        Predicate<Integer> isEven = x -> x % 2 == 0;
        List<Integer> filteredList = filter(intList, isEven);
        System.out.println("even .................");
        filteredList.forEach(System.out::println);

        System.out.println("odd .................");
        filter(intList, x -> x % 2 == 1).forEach(System.out::println);

        System.out.println("bigger.................");
        filter(intList, x -> x > 5).forEach(System.out::println);

        System.out.println("smaller.................");
        filter(intList, x -> x < 5).forEach(System.out::println);

    }
}
