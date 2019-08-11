package jdk8.stream;

import org.junit.Test;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author liyazhou1
 * @desc TODO
 * @date 2019/8/11
 */
public class CollectorBase {

    private List<Dish> menu = Menu.menu;


    /**
     * 将数据分组
     *
     * collection()
     *
     * Collectors.groupingBy()
     * Collectors.toList()
     */
    @Test
    public void groupingBy() {

        Map<Dish.Type, List<Dish>> dishTypeMap = menu.stream().collect(Collectors.groupingBy(Dish::getType));

        dishTypeMap.forEach(new BiConsumer<Dish.Type, List<Dish>>() {
            @Override
            public void accept(Dish.Type type, List<Dish> dishes) {
                System.out.println(type + " = " + dishes);
            }
        });
    }


    /*
        预定义的收集器，主要提供了三大功能：
            1. 将流元素规约和汇总为一个值
            2. 元素分组
            3. 元素分区

            Collectors.toList()
            Collectors.groupingBy()
            Collectors.counting()

            计算count、sum、max、min、average五个统计值

     */

    /**
     * 1. 求元素个数
     */
    @Test
    public void counting() {

        long counting = menu.stream().collect(Collectors.counting());
        System.out.println("counting = " + counting);

        long count = menu.stream().count();
        System.out.println("count = " + count);

        long size = menu.size();
        System.out.println("size = " + size);
    }


    /**
     * 2. 求最值
     *
     * 收集最值的两种方式
     *
     * stream.collect(Collectors.maxBy(cmp))
     * stream.max(cmp)
     *
     */
    @Test
    public void max(){

        // Comparator comparingInt() 为 接口的静态方法
        // JDK8 支持接口提供默认方法和静态方法
        Comparator<Dish> dishCaloriesCmp = Comparator.comparingInt(Dish::getCalories);

        Optional<Dish> mostCaloriesDish = menu.stream().collect(Collectors.maxBy(dishCaloriesCmp));
        mostCaloriesDish.ifPresent(System.out::println);

        mostCaloriesDish = menu.stream().max(dishCaloriesCmp);
        mostCaloriesDish.ifPresent(System.out::println);

    }


    /**
     * 3. 求和
     *
     * stream.collect(Collectors.summingInt(Dish::getCalories))
     *
     * Collectors.summingInt()
     * Collectors.summingLong()
     * Collectors.summingDouble()
     */
    @Test
    public void summingInt() {

        int totalCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println("totalCalories = " + totalCalories);

        totalCalories = menu.stream().map(Dish::getCalories).reduce(0, (x, y) -> x + y);
        System.out.println("totalCalories = " + totalCalories);

        totalCalories = menu.stream().map(Dish::getCalories).reduce(Integer::sum).orElse(-1);
        System.out.println("totalCalories = " + totalCalories);

        totalCalories = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println("totalCalories = " + totalCalories);

    }


    /**
     * 4. 求均值
     *
     * Collectors.averagingInt()
     * Collectors.averagingLong()
     * Collectors.averagingDouble()
     */
    @Test
    public void averagingInt() {
        double averageCalories = menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
        System.out.println("averageCalories = " + averageCalories);
    }


    /**
     * 5. 求统计结果
     *
     * 返回count、sum、average、max、min五个统计值
     * Collectors.summarizingInt()
     * Collectors.summarizingLong()
     * Collectors.summarizingDouble()
     */
    @Test
    public void summarizingInt() {
        IntSummaryStatistics menuSummaryStat = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println("menuSummaryStat = " + menuSummaryStat);
    }


    @Test
    public void joining() {
        String shortMenu = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.joining());
        System.out.println("shortMenu = " + shortMenu);

        shortMenu = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.joining(", "));
        System.out.println("shortMenu = " + shortMenu);

        Optional<String> dishNames = menu.stream()
                .map(Dish::getName)
                .reduce((a, b) -> a + ", " + b);
        dishNames.ifPresent(System.out::println);

        StringJoiner stringJoiner = new StringJoiner(", ");
        for (Dish dish : menu) {
            stringJoiner.add(dish.getName());
        }
        System.out.println("stringJoiner = " + stringJoiner);

    }


    /**
     * 使用map-reduce实现 collect(Collectors.toList())
     *
     * collect 与 reduce 规约对比
     */
    @Test
    public void reduceToList(){
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
        List<Integer> numList = stream.collect(Collectors.toList());
        System.out.println("numList = " + numList);


        numList = Stream.of(1, 2, 3, 4, 5, 6).map(e -> {
            List<Integer> list = new ArrayList<>();
            list.add(e);
            return list;
        }).reduce(new ArrayList<Integer>(),
                // 修改原来的list，线程不安全，该reduce无法并行计算
                (a, b) -> {
                    a.addAll(b);
                    return a;
        });
        System.out.println("numList = " + numList);


        numList = Stream.of(1, 2, 3, 4, 5, 6).map(e -> {
            List<Integer> list = new ArrayList<>();
            list.add(e);
            return list;
        }).reduce(new ArrayList<Integer>(),
                (a, b) -> {
                    List<Integer> list = new ArrayList<>();
                    list.addAll(a);
                    list.addAll(b);
                    return list;
        });
        System.out.println("numList = " + numList);

    }


    /**
     * 广义的规约汇总
     *
     * collect(Collectors.reducing(x, y, z))
     */
    @Test
    public void collectReducing() {
        int totalCalories = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println("totalCalories = " + totalCalories);

        totalCalories = menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
        System.out.println("totalCalories = " + totalCalories);

        totalCalories = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
        System.out.println("totalCalories = " + totalCalories);


        String shortMenu = menu.stream().map(Dish::getName).reduce("", (a, b) -> a + "," + b);
        System.out.println("shortMenu = " + shortMenu);

        shortMenu = menu.stream().map(Dish::getName).reduce((a, b) -> a + "," + b).get();
        System.out.println("shortMenu = " + shortMenu);

        shortMenu = menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
        System.out.println("shortMenu = " + shortMenu);

        shortMenu = menu.stream().collect(Collectors.reducing("", Dish::getName, (a, b) -> a + ", " + b));
        System.out.println("shortMenu = " + shortMenu);
        /*
        shortMenu = ,pork,beef,chicken,french fries,rice,season fruit,pizza,prawns,salmon
        shortMenu = pork,beef,chicken,french fries,rice,season fruit,pizza,prawns,salmon
        shortMenu = pork, beef, chicken, french fries, rice, season fruit, pizza, prawns, salmon
        shortMenu = , pork, beef, chicken, french fries, rice, season fruit, pizza, prawns, salmon
        */
    }

}
