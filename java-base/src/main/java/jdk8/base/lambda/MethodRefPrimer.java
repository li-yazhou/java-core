package jdk8.base.lambda;

import com.sun.tools.corba.se.idl.constExpr.Or;
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

        方法引用让你可以重复使用现有的方法定义，并像Lambda一样传递它们。
        在一些情况下，比起使用Lambda表达式，它们似乎更易读，感觉更自然。

        方法引用主要有三类：
        (1) 指向静态方法的方法引用
            (args) -> ClassName.staticMethod(args)
            ClassName::staticMethod
            如 Integer::parseInt
        (2) 参数对象的方法
            (arg0, rest) -> arg0.instanceMethod(rest)
            ClassName::instanceMethod
            如 strList.sort(String::compareToIgnoreCase)
        (3) 非参数对象的方法
            (args) -> expr.instanceMethod(args)
            expr::instanceMethod
            如 System.out::println

        一般情况下，方法的引用形式是 ClassName::methodName，比如，System.out::println
        构造方法的引用 ClassName::new，Function<Integer, List> func = List::new


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

        Supplier<Apple> appleWithoutArgs = Apple::new;
        Supplier<Orange> orangeWithoutArgs = Orange::new;
        Apple apple3 = appleWithoutArgs.get();
        Orange orange = orangeWithoutArgs.get();
        System.out.println("apple3 = " + apple3);
        System.out.println("orange = " + orange);


        BiFunction<String, Double, Apple> appleBiFunction1 = Apple::new;
        BiFunction<String, Double, Orange> orangeBiFunction = Orange::new;

        List<Apple> appleList = generateAppleList(weights, appleBiFunction1);
        List<Orange> orangeList = generateAppleList(weights, orangeBiFunction);
        System.out.println("appleList = " + appleList);
        System.out.println("orangeList = " + orangeList);

        Apple apple4 = apply("Green", 1.2, Apple::new);
        Orange orange1 = apply("Yellow", 1.3, Orange::new);
        System.out.println("apple4 = " + apple4);
        System.out.println("orange1 = " + orange1);
    }


    private <T> T get(Supplier<T> supplier) {
        return supplier.get();
    }


    private <T> T apply(String color, double weight, BiFunction<String, Double, T> biFunction) {
        return biFunction.apply(color, weight);
    }


    private <T> List<T> generateAppleList(List<Double> weights, BiFunction<String, Double, T> appleBiFunction1) {
        List<T> list = new ArrayList<>();
        for (Double weight : weights) {
            list.add(appleBiFunction1.apply("red", weight));
        }
        return list;
    }
}


class Apple {

    private String color;

    private double weight;


    public Apple() {
    }

    public Apple(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}


class Orange {

    private String color;
    private double weight;

    public Orange() {
    }

    public Orange(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Orange{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}