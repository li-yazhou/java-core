package java8.chapter05;

import java8.chapter04.Dish;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-28 20:57
 */
public class Filtering {

    private List<Dish> menu = null;

    @Before
    public void init(){
        menu = Dish.menu;
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
                .filter((Integer i) -> (i & 1) == 0)
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * 截短流
     * limit(n)
     */
    @Test
    public void limitElements(){
        List<Dish> dishes = menu.stream()
                                .filter((Dish d) -> d.getCalories() > 300)
                                .limit(3)
                                .collect(toList());
        dishes.forEach(System.out::println);
    }

    /**
     * 跳过元素
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
