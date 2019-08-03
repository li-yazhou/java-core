package jdk8.base.methodref;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * <p>Description: <p/>
 *
 * @author liyazhou1
 * @date 2018/7/27
 */
public class MethodRefPrimer {

    /*
        Method References

        Method references help to point to methods by their names.
        A method reference is described using "::" symbol.
        A method reference can be used to point the following types of methods −
            Static methods
            Instance methods
            Constructors using new operator (TreeSet::new)

        一般情况下，方法的引用形式是
            ClassName::methodName
        比如，System.out::println

        构造方法的引用
            ClassName::new


        Iterable
            default void forEach(Consumer<? super T> action) {
                Objects.requireNonNull(action);
                for (T t : this) {
                    action.accept(t);
                }
            }

        Consumer<T>
            void accept(T t);

     */


    @Test
    public void printlnRef() {
        List<String> names = Arrays.asList(
                "lyz",
                "zz",
                "zhouzhou"
        );

        names.forEach(System.out::println);
    }


    /*
        构造方法的引用
     */
    @Test
    public void constructor() {
        Supplier<Apple> appleSupplier = Apple::new;
        Apple apple = appleSupplier.get();
        System.out.println("apple = " + apple);

        /* Supplier 不需要传递参数，只有返回值，函数式接口的抽象方法是 get() */
        Supplier<Apple> appleSupplier1 = () -> new Apple();
        Apple apple1 = appleSupplier1.get();
        System.out.println("apple1 = " + apple1);

        /* Function 需要传递参数，有返回值， 函数式接口的抽象方法是 apply() */
        BiFunction<String, Double, Apple> appleBiFunction = Apple::new;
        Apple apple2 = appleBiFunction.apply("red", 100D);
        System.out.println("apple2 = " + apple2);


        /* 批量创建对象，将构造函数作为参数，同一段代码可以创建不同的对象 */
        List<Double> weights = Arrays.asList(
                100.0,
                50D,
                20D,
                60D
        );
        BiFunction<String, Double, Apple> appleBiFunction1 = Apple::new;
        List<Apple> appleList = generateAppleList(weights, appleBiFunction1);
        System.out.println("appleList = " + appleList);

        BiFunction<String, Double, Orange> orangeBiFunction = Orange::new;
        List<Orange> orangeList = generateAppleList(weights, orangeBiFunction);
        System.out.println("orangeList = " + orangeList);
    }

    private <T> List<T> generateAppleList(List<Double> weights, BiFunction<String, Double, T> appleBiFunction1) {
        List<T> list = new ArrayList<>();
        for (Double weight : weights) {
            list.add(appleBiFunction1.apply("red", weight));
        }
        return list;
    }


}
