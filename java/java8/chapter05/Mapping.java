package java8.chapter05;

import java8.chapter03.Dish;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-28 21:36
 */
public class Mapping {
    private List<Dish> menu = Dish.menu;

    /**
     * 对流中的每一个元素应用函数
     * map(Function<T, R> function)
     *      Function<T, R>  R apply(T t)
     *
     * map会接收一个函数作为参数，并将这个函数应用到每一个元素上，并将其映射成一个新元素
     */
    @Test
    public void mappingElements(){
        List<String> dishNames = menu.stream()
                                   .map(Dish::getName)
                                   .collect(toList());
        dishNames.forEach(System.out::println);
    }

    @Test
    public void mappingElements02(){
        List<Integer> dishNamesLen = menu.stream()
                                         .map(Dish::getName)
                                         .map(String::length)
                                         .collect(toList());
        dishNamesLen.forEach(System.out::println);
    }


    /**
     * 统计单词集合中出现的字母
     * flatMap(Arrays.stream) 将多个流扁平化为一个流
     */
    @Test
    public void distinctCharacters(){
        List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
        List<String> distinctCharacters = words.stream()
                                          .map(w -> w.split(""))
                                          .flatMap(Arrays::stream)
                                          .distinct()
                                          .collect(toList());
        distinctCharacters.forEach(System.out::print);
    }

}
