package jdk8.stream;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author liyazhou1
 * @desc TODO
 * @date 2019/8/10
 */
public class StreamBuilder {

    /*
        构建流
     */


    /**
     * 由多个值（变长数组）创建流
     */
    @Test
    public void fromVargs() {
        Stream<String> stream = Stream.of("JDK8", "Lambda", "Method Reference",
                "Stream", "Default Method", "Functional Interface", "Optional", "Time");
        stream.map(String::toUpperCase).forEach(System.out::println);

        Stream<String> emtpyStream = Stream.empty();
        long count = emtpyStream.count();
        System.out.println("count = " + count);
    }


    /**
     * 由数组创建流
     */
    @Test
    public void fromArrays() {
        int[] nums = {1, 2, 3, 4, 5};
        IntStream intStream = Arrays.stream(nums);

        int sum = intStream.sum();
        System.out.println("sum = " + sum);
    }


    /**
     * 由文件创建流
     */
    @Test
    public void fromFiles() {
        long uniqueWords = 0;

        String filepath = "/Users/liyazhou1/self-repo/java-core/java-base/src/main/resources/stream/file.txt";
        try(Stream<String> lines = Files.lines(Paths.get(filepath), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("uniqueWords = " + uniqueWords);
    }


    /**
     *  由iterate生成无限流
     */
    @Test
    public void iterate() {

        UnaryOperator<Integer> unaryOperator = n -> n + 1;
        Stream<Integer> stream = Stream.iterate(0, unaryOperator)
                .limit(10);
        stream.forEach(elem -> System.out.print(elem + ", "));
        System.out.println();

        // 生成斐波那锲元组序列
        UnaryOperator<int[]> arrOperator = arr -> new int[]{arr[1], arr[0] + arr[1]};
        Stream<int[]> arrStream = Stream.iterate(new int[]{0, 1}, arrOperator)
                .limit(20);
        arrStream.map(Arrays::toString).forEach(System.out::println);

    }

    /**
     * 使用generate生成无限流
     */
    @Test
    public void generate() {

        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        IntStream ones = IntStream.generate(() -> 1);
        ones.limit(5).forEach(x -> System.out.print(x + ", "));
        System.out.println();

        IntStream twos = IntStream.generate(new IntSupplier() {
            @Override
            public int getAsInt() {
                return 2;
            }
        });
        twos.limit(3).forEach(x -> System.out.print(x + ", "));
        System.out.println();

        // 生成斐波那锲序列
        IntSupplier fib = new IntSupplier() {

            // 有状态的计算，无法并行
            private int first = 0;
            private int second = 1;

            @Override
            public int getAsInt() {
                int retval = first;
                int sum = first + second;
                first = second;
                second = sum;
                return retval;
            }
        };
        IntStream.generate(fib)
                .limit(10)
                .forEach(x -> System.out.print(x + ", "));
        System.out.println();

    }



}
