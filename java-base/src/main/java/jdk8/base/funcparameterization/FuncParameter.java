package jdk8.base.funcparameterization;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liyazhou1
 * @desc 行为参数化
 * @date 2019/8/3
 */
public class FuncParameter {


    /**
     * 行为参数化
     *
     * @param list List
     * @param filter 行为的接口
     * @return List
     */
    public List<Number> listFilter(List<Number> list, Filter<Number> filter) {
        List<Number> result = new ArrayList<>(list.size());
        for (Number num : list) {
            if (filter.test(num)) {
                result.add(num);
            }
        }
        return result;
    }


    /**
     * 方法引用
     */
    public static boolean oddIntFilter(Number number) {
        return number instanceof Integer && number.intValue() % 2 == 1;
    }

    @Test
    public void listFilter() {
        List<Number> list = Arrays.asList(0, 1, 2, 3, 4, 5.1f, 6.2f, 7.0, 8.3, 9);

        // 行为参数化，通过接口及其实现类实现传递函数
        List<Number> intList = listFilter(list, new IntFilter());
        System.out.println("intList = " + intList);
        List<Number> evenIntList = listFilter(list, new EvenIntFilter());
        System.out.println("evenIntList = " + evenIntList);

        // 行为参数化，通过接口及其匿名类实现传递函数
        List<Number> doubleList = listFilter(list, new Filter<Number>() {
            @Override
            public boolean test(Number number) {
                return number instanceof Double;
            }
        });
        System.out.println("doubleList = " + doubleList);

        // 行为参数化，通过接口及Lambda表达式实现传递函数
        List<Number> floatList = listFilter(list, (Number num) -> num instanceof Float);
        System.out.println("floatList = " + floatList);

        // 行为参数化，通过接口及方法引用实现传递函数
        List<Number> oddIntList = listFilter(list, FuncParameter::oddIntFilter);
        System.out.println("oddIntList = " + oddIntList);
    }

    public static void main(String... args) {

    }

}


/**
 * 行为参数化的过程
 *
 * 1. 将行为（函数）定义在一个接口中（定义包含一个函数的接口，函数式接口）
 * 2. 接口的实现类
 * 3. 该接口作为参数，通过传递该接口实现类的对象，实现传递函数
 *
 * @param <T>
 */
interface Filter<T extends Number> {
    boolean test(T t);
}

class IntFilter implements Filter<Number> {
    @Override
    public boolean test(Number number) {
        // return Integer.class.isInstance(number);
        return number instanceof Integer;
    }
}

class EvenIntFilter implements Filter<Number> {
    @Override
    public boolean test(Number number) {
        return number instanceof Integer && number.intValue() % 2 == 0;
    }
}


/*
    行为参数化的 4 种实现方式：
        1. 行为参数化，通过接口及其实现类实现传递函数
        2. 行为参数化，通过接口及其匿名类实现传递函数
        3. 行为参数化，通过接口及Lambda表达式实现传递函数
        4. 行为参数化，通过接口及方法引用实现传递函数
 */

