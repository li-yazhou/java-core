package jdk8.functional.designpattern.responsibility_chain.lambda;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * @author liyazhou1
 * @date 2018/8/3
 */
public class Lambda {
    /*
        UnaryOperator<T> extends Function<T, T>
            default Function<T, R> andThen(Function after)

        Function<T, R>
            R apply(T t)
     */

    public static void main(String[] args) {
        UnaryOperator<String> headProcessing = (String text) -> "[ " + text;

        UnaryOperator<String> tailProcessing = (String text) -> text + " ]";

        Function<String, String> pipeline = headProcessing.andThen(tailProcessing);

        String result = pipeline.apply("This is a string");

        System.out.println("result = " + result);
    }
}
