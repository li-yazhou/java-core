package jdk8.base;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author liyazhou1
 * @desc TODO
 * @date 2019/8/3
 */
public class Jdk8Primer {

    public static void main(String... args) {
    }

    /**
     * 通过传递对象实现传递对象的方法
     *
     * 传递方法引用，直接传递方法
     */
    @Test
    public void hiddenFiles() {
        File[] hiddenFiles = null;
        String path = "/Users/liyazhou1";

        hiddenFiles = new File(path).listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });
        println(hiddenFiles);

        // hiddenFiles = new File(path).listFiles((File pathname) -> {pathname.isHidden()});
        // ERROR

        hiddenFiles = new File(path).listFiles(File::isHidden);
        println(hiddenFiles);
    }

    private static void println(Object[] objects) {
        System.out.println(Arrays.toString(objects));
    }

    private static void println(Object object) {
        System.out.println(object);
    }


    /**
     * 结合函数式接口，定义通用性的方法
     * @param list List
     * @param p 条件，是函数式参数，接收lambda表达式或者方法引用
     * @return 满足条件的List
     */
    private List<Number> filter(List<Number> list, Predicate<Number> p) {
        List<Number> result = new ArrayList<>(list.size());
        for (Number elem : list) {
            if (p.test(elem)) {
                result.add(elem);
            }
        }
        return result;
    }

    /**
     * 定义方法引用
     * @param num 函数式接口方法的参数
     * @return bool
     */
    private static boolean isEven(Number num) {
        return Integer.class.isInstance(num) && num.intValue() % 2 == 0;
    }

    @Test
    public void filterListElement() {
        List<Number> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7.1f, 8.0f, 9.0, 10.1);

        List<Number> intList = null;
        intList = filter(list, (Number num) -> num instanceof Integer);
        println("intList = " + intList);

        intList = filter(list, (Number num) -> Integer.class.isInstance(num));
        println("intList = " + intList);
        intList = filter(list, Integer.class::isInstance);
        println("intList = " + intList);

        List<Number> evenList = null;
        evenList = filter(list, (Number num) -> Integer.class.isInstance(num) && num.intValue() % 2 == 0);
        println("evenList = " + evenList);

        // 方法引用
        evenList = filter(list, Jdk8Primer::isEven);
        println("evenList = " + evenList);

        List<Number> doubleList = null;
        doubleList = filter(list, Double.class::isInstance);
        println("doubleList = " + doubleList);
    }


    /**
     * Stream
     */
    @Test
    public void stream() {
        Collection<Number> coll = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7.1f, 8.0f, 9.0, 10.1);
        long evenIntCount = coll.stream()
                .filter(Integer.class::isInstance)
                .filter((Number num) -> {
                    boolean isEven = num.intValue() % 2 == 0;
                    if (isEven) {
                        System.out.print(num + "\t");
                    }
                    return isEven;
                })
                .count();
        println("\nevenIntCount = " + evenIntCount);

        Collection<Number> evenList = coll.stream()
                .filter(Integer.class::isInstance)
                .filter((Number num) -> num.intValue() % 2 == 0)
                .collect(Collectors.toList());
        println("evenList = " + evenList);


        // 几乎免费的并行
        Collection<Number> oddList = coll.parallelStream()
                .filter((Number num) -> num instanceof Integer && num.intValue() % 2 == 1)
                .collect(Collectors.toList());

    }

}
