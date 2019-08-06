package jdk8.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-29 8:44
 */
public class Finding {
    private List<Dish> menu = Menu.menu;

    /**
     * 检查谓词是否至少匹配一个元素
     * anyMatch(Predicate<T> predicate)
     */
    @Test
    public void anyMatchTest(){
        if (menu.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("The menu is (somewhat) vegetarian friendly!");
        }
    }


    /**
     * 检查谓词是否匹配所有的元素
     * allMatch(Predicate<T> predicate)
     */
    @Test
    public void allMatchTest(){
        if (menu.stream().allMatch(dish -> dish.getCalories() < 1000)){
            System.out.println("calorie of every dish is less 1000 ");
        }
    }

    /**
     * 一个都没有
     * noneMatch(Predicate<T> predicate)
     */
    @Test
    public void noneMatchTest(){
        if (menu.stream().noneMatch(dish -> dish.getCalories() >= 1000)){
            System.out.println("there is no dish that its calorie is more than 1000.");
        }
    }


    /**
     * 返回流中的任意一个元素
     * Optional<T> findAny()
     *
     * Optional 对象中存储 0 个或者 1 个元素
     * 其常用方法有
     *  isPresent()
     *  ifPresent(Consumer<T> block)
     *  T get(), if isPresent() is false, will throw NoSuchElement Exception
     *  T orElse(T other)，if isPresent is false, will return other
     */
    @Test
    public void findAny(){
        Optional<Dish> optionalDish = menu.stream()
                                          .filter(dish -> dish.isVegetarian())
                                          .findAny();
                                          //.ifPresent(dish -> System.out.println(dish))  ;
        System.out.println(optionalDish);
        if (optionalDish.isPresent()) {
            System.out.println(optionalDish.get().getName());
            Dish dish = optionalDish.get();
            System.out.println(dish);
        }

        // optionalDish.ifPresent(dish -> System.out.println(dish));
        optionalDish.ifPresent(System.out::println);


        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(System.out::println);
    }


    /**
     * 查找流中的第一个元素
     * findFirst()
     */
    @Test
    public void findFirstTest(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Optional<Integer> firstSqureDivisibleByThree = numbers.stream()
                                                                .map(x -> x * x)
                                                                .filter(x -> x % 13 == 0)
                                                                .findFirst();
        Integer number  = firstSqureDivisibleByThree.orElse(1000);
        System.out.println(number);

        firstSqureDivisibleByThree.ifPresent(intNumber -> System.out.println(intNumber));
        firstSqureDivisibleByThree.ifPresent(System.out::println);
    }



}























