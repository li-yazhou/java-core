package org.alpha.javabase.jdk8.stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <p>Description: <p/>
 *
 * @author liyazhou1
 * @date 2018/7/13
 */
public class StreamPrimer {

    /*
        map()
        distinct()
     */
    @Test
    public void map() {
        List<Integer> intList = Arrays.asList(2, 2, 3, 5, 6, 9);
        List<Integer> squareList = intList.stream()
                .map(i -> i * i)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("squareList = " + squareList);
    }


    /*
        filter()
     */
    @Test
    public void filter() {
        List<String> stringList = Arrays.asList(
                "lyz",
                "zz",
                "",
                "zhouzhou"
        );

        // collect() 方法
        List<String> filtered = stringList.stream()
                .filter(str -> !str.isEmpty())
                .collect(Collectors.toList());

        System.out.println("filtered = " + filtered);

        System.out.println("----------------------");

        long emptyCnt = stringList.stream()
                // .filter(str -> str.isEmpty())
                .filter(String::isEmpty)
                .count();
        System.out.println("emptyCnt = " + emptyCnt);
    }



    /*
        Random
            ints().limit(size);
     */
    @Test
    public void forEach() {
        Random random = new Random();
        IntStream intStream = random.ints().limit(10);
        intStream.forEach(System.out::println);

        // Stream<Integer> stream = random.ints().boxed();
        // stream.forEach(System.out::println);
    }


    @Test
    public void sorted() {
        Random random = new Random();
        random.ints().limit(10)
                .sorted()
                .forEach(System.out::println);
    }


    /*
        Collectors are used to combine the result of processing on the elements of a stream.
        Collectors can be used to return a list or a string.

        collect(Collector collector)
     */
    @Test
    public void collect() {
        List<String> stringList = Arrays.asList(
                "lyz",
                "zz",
                "",
                "zhouzhou"
        );

        List<String> filtered = stringList.stream()
                .filter(str -> !str.isEmpty())
                .collect(Collectors.toList());
        System.out.println("filtered = " + filtered);

        String mergeedString = stringList.stream()
                .filter(str -> !str.isEmpty())
                .collect(Collectors.joining(", "));
        System.out.println("mergeedString = " + mergeedString);
    }


    /*
        IntSummaryStatistics
        DoubleSummaryStatistics
     */
    @Test
    public void statistics() {
        List<Integer> intList = Arrays.asList(2, 2, 3, 5, 6, 9);
        IntSummaryStatistics stats = intList.stream()
                .mapToInt(x -> x)
                .summaryStatistics();
        System.out.println("stats = " + stats);

        System.out.println("stats.getMax() = " + stats.getMax());
        System.out.println("stats.getMin() = " + stats.getMin());
        System.out.println("stats.getSum() = " + stats.getSum());
        System.out.println("stats.getCount() = " + stats.getCount());
        System.out.println("stats.getAverage() = " + stats.getAverage());
    }
}
