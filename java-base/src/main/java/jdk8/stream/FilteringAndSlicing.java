package jdk8.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * description:
 *  过滤与切片
 *
 * @author liyazhou
 * @since 2017-07-28 20:57
 */
public class FilteringAndSlicing {

    private List<Dish> menu = null;

    @Before
    public void init(){
        menu = Menu.menu;
    }

    /**
     *  用谓词筛选
     *  filter(Predicate<T> p)
     *      -- Predicate<T> boolean test(T)
     */
    @Test
    public void filterElements(){
        List<Dish> vegetarianMenu = menu.stream()
                                        .filter(Dish::isVegetarian)  // 过滤返回true的元素
                                        .collect(toList());
        vegetarianMenu.forEach(System.out::println);
    }

    /**
     * 相等的元素保留一个
     * distinct()
     */
    @Test
    public void distinctElements(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 6, 9, 2, 3, 5, 9);
        numbers.stream()
                .filter((Integer i) -> (i & 1) == 0)  // 过滤出偶数
                .distinct()  // 去重
                .forEach(System.out::println);
    }

    /**
     * 截短流，从流中返回前几个满足条件的元素组成的流，并不是TopK
     * limit(n)
     */
    @Test
    public void limitElements(){
        menu.forEach(System.out::println);
        System.out.println("----------");
        List<Dish> dishes = menu.stream()
                                .filter((Dish d) -> d.getCalories() > 300)
                                .limit(3)
                                .collect(toList());
        dishes.forEach(System.out::println);
    }

    /**
     * 跳过元素，返回扔掉前 N 个元素的流
     *
     * skip(N)和limit(N)是互补的。
     *
     * skip(n)
     */
    @Test
    public void skipElements(){
        List<Dish> dishes = menu.stream()
                                .filter(d -> d.getCalories() > 300)
                                .skip(2)
                                .collect(toList());
        dishes.forEach(System.out::println);
    }

}
