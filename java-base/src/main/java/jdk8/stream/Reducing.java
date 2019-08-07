package jdk8.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author liyazhou1
 * @desc TODO
 * @date 2019/8/7
 */
public class Reducing {

    /*
        归约操作，将流归约成一个值。
        使用函数式编程语言的术语来说，这称为折叠fold。

        T reduce(T identity, BinaryOperator<T> accumulator);
        reduce方法接收两个参数：
            一个初始值，比如求和将初始值设置为0；
            一个BinaryOperator<T>将两个元素结合起来产生一个新值，比如求和时使用lambda (a, b) -> a + b。

        Optional<T> reduce(BinaryOperator<T> accumulator);

     */


    @Test
    public void sum() {
        List<Integer> numList = Arrays.asList(1, 2, 3, 4 ,5);

        Integer sum = numList.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("sum = " + sum);

        Integer sumInJava8 = numList.stream()
                .reduce(0, Integer::sum);
        System.out.println("sumInJava8 = " + sumInJava8);
    }


    @Test
    public void max() {
        List<Integer> numList = Arrays.asList(1, 2, 3, 4 ,5, -1, -2, 6, 2);

        Optional<Integer> max = numList.stream()
                .reduce((a, b) -> (a > b ? a : b));
        max.ifPresent(System.out::println);

        max = numList.stream()
                .reduce(Integer::max);
        max.ifPresent(System.out::println);

        Optional<Integer> min = numList.stream()
                .reduce(Integer::min);
        min.ifPresent(System.out::println);
    }


    /**
     * Map-Reduce模式
     *
     * 满足条件元素的个数
     *
     * 大于 0 元素的个数
     */
    @Test
    public void count() {
        List<Integer> numList = Arrays.asList(1, 2, 3, 4 ,5, -1, -2, 6, 2);

        int count = numList.stream()
                .map(x -> x > 0 ? 1 : 0)
                .reduce(0, Integer::sum);
        System.out.println("元素大于0的个数为 " + count);

        long size = numList.stream().count();
        System.out.println("size = " + size);
    }

}
