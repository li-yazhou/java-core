package jdk8.stream;

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

    private List<Dish> menu = Menu.menu;

    /**
     * 对流中的每一个元素应用函数
     *
     * map(Function<T, R> function)
     *      Function<T, R>  R apply(T t)
     *
     * map会接收一个函数作为参数，并将这个函数应用到每一个元素上，并将其映射成一个新元素
     *
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
     * 流的扁平化，平铺Map，flatMap，降低数据的维度
     *
     * flatMap方法就是把一个流中的每一个值都换成另一个流，然后把所有的流连接成为一个流。
     *
     * Stream<String[]>.flatMap(Arrays::stream) 将 Stream<String[]>中的每一个字符串转换为Stream<String>，
     * 然后将所有Stream<String>连接为一个Stream<String>，实现将二维数据降低为一维数据
     *
     * 统计单词集合中出现的字母
     * flatMap(Arrays.stream) 将多个流扁平化为一个流，将二维数据降低为一维数据
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


    /**
     * 计算给定整数集合中每个元素的平方
     */
    @Test
    public void squareOfNumbers(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> squares = numbers.stream()
                                       .map(n -> n * n)
                                       .collect(toList());
        squares.forEach(e -> System.out.print(e + "\t"));
    }

    /**
     * 给定两个数字列表，返回所有的数对
     */
    @Test
    public void pairs(){
        List<Integer> firstArray = Arrays.asList(1, 2, 3);
        List<Integer> secondArray = Arrays.asList(3, 4);
        List<int[]> pairs = firstArray.stream()
                                      .flatMap(i -> secondArray.stream()
                                                               .map(j -> new int[]{i, j}))
                                      .collect(toList());
        pairs.forEach(pair -> System.out.println(Arrays.toString(pair)));
    }

    /**
     * 给定两个数字列表，返回所有的数对，且每个数对之和能被 3 整除
     */
    @Test
    public void filteredPairs(){
        List<Integer> firstArray = Arrays.asList(1, 2, 3);
        List<Integer> secondArray = Arrays.asList(3, 4);
        List<int[]> pairs = firstArray.stream()
                                      .flatMap(i -> secondArray.stream()
                                                               .filter(j -> (i + j) % 3 == 0)
                                                               .map(j -> new int[]{i, j}))
                                      .collect(toList());
        pairs.forEach(pair -> System.out.println(Arrays.toString(pair)));
    }


}
















