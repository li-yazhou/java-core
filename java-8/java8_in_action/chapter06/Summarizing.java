package java8_in_action.chapter06;

import java8_in_action.chapter04.Dish;
import org.junit.Test;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-30 9:05
 */
public class Summarizing {
    private List<Dish> menu = Dish.menu;

    /**
     * 流中一共有多少元素
     */
    @Test
    public void counting(){
        long count = menu.stream().collect(Collectors.counting());
        long howManyDishes = menu.stream().count();
        System.out.println("count = " + count);
        System.out.println("howManyDishes = " + howManyDishes);
    }


    /**
     * 查找流中的最大值
     * Comparator的默认方法 comparatingInt(ToIntFunction<? extends T> keyExtractor)
     * Collectors.maxBy(Comparator cmp)
     */
    @Test
    public void findMaximum(){
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCaloriesDish = menu.stream().collect(Collectors.maxBy(dishCaloriesComparator));
        // mostCaloriesDish.ifPresent(dish -> System.out.println(dish));
        mostCaloriesDish.ifPresent(System.out::println);
    }

    /**
     * 汇总，求和
     * Collectors.summingInt(ToIntFunction<? super T> mapper)
     * Collectors.summingLong
     * Collectors.summingDouble
     */
    @Test
    public void calculateTotalCalories(){
        int totalCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println("total calories is " + totalCalories);
    }

    /**
     * 求平均值
     * Collectors.averagingInt(ToIntFunction<? super T> mapper)
     */
    @Test
    public void calculateAverageCalories(){
        double averageCalories = menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
        System.out.println("average calories is " + averageCalories);
    }


    /**
     * 概要
     * Collectors.summarizingInt(ToIntFunction<? super T> mapper)
     */
    @Test
    public void summarizingTest(){
        IntSummaryStatistics caloriesSummary = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(caloriesSummary);

        System.out.println(caloriesSummary.getCount());
        System.out.println(caloriesSummary.getAverage());
        System.out.println(caloriesSummary.getMax());
        System.out.println(caloriesSummary.getMin());
        System.out.println(caloriesSummary.getSum());
    }


}
