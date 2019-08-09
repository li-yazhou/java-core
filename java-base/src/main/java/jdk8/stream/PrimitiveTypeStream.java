package jdk8.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author liyazhou1
 * @desc TODO
 * @date 2019/8/9
 */
public class PrimitiveTypeStream {

    /*

        为了避免原始数字类型装箱导致性能下降，Stream API 提供了原始流特化。

        IntStream、LongStream和DoubleStream，分别将流中的元素特化为 int、long和double，从而避免了暗含的装箱成本。

     */

    private List<Dish> menu = Menu.menu;


    /**
     * 映射到数值流
     *
     * IntStream mapToInt()
     * LongStream mapToLong()
     * DoubleStream mapToDouble()
     */
    @Test
    public void tooIntStream() {

        int calories = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println("calories = " + calories);
    }


    /**
     * 数值流转换为包装流
     */
    @Test
    public void toStream() {

        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);

        Stream<Integer> stream = intStream.boxed();

    }


    /**
     * Optional原始类型特化版本
     *
     * OptionalInt
     * OptionalLong
     * OptionalDouble
     */
    @Test
    public void optionalInt() {
        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        int max = maxCalories.orElse(-1);

        System.out.println("max = " + max);
    }


    @Test
    public void range() {
        IntStream evenNumbers = IntStream.range(0, 10)
                .filter(n -> (n & 1) == 0);

        System.out.println("evenNumbers = " + evenNumbers.count());

        List<Integer> numList = IntStream.rangeClosed(0, 9)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("numList = " + numList);

    }


    /**
     * 数值流应用：勾股数
     */
    @Test
    public void pythagoreanTriple() {
        Stream<double[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 100)
                    .boxed()
                    .flatMap(a ->
                            IntStream.rangeClosed(a, 100)
                                .mapToObj(b -> new double[]{a, b, Math.sqrt(a*a + b*b)})
                                .filter(t -> t[2] % 1 == 0)
                    );
        pythagoreanTriples.map(Arrays::toString).forEach(System.out::println);
    }
}
