package javabase.jdk8.book.java8_in_action;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * description:
 * <p>
 * author: liyazhou1
 * date: 2018/5/23
 */

/*

Lambda表达式，
1. 定义只包含一个方法的接口，函数式接口；（事先完成）
2. 定义一个方法，接收Lambda需要的参数和接口实例，方法体是通过接口实例调用接口的方法，并把参数传给该接口的方法，定义的这个方法是提供给外界的接口；（事先完成）
3. 为该接口的实例赋值Labda表达式，可以把把它看做一个函数；（自定义）


1 定义一个算术运算接口，里面包含一个方法，接收两个参数；
2 在另一个类中定义一个方法，该方法的参数是接口实例和接口中方法需要的参数；
3 声明接口实例，并为该接口实例赋值一个Lambda表达式，这样就完成了Labmda表达式和接口中方法绑定的过程。

 */
public class LambdaTest {


    @Test
    public void testLabamda() {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        // forEach是定义好的一个方法；
        // forEach的参数是Lambda表达式，是函数式接口Consumer中的方法；
        // forEach不接收lambda需要的参数，lambda需要的参数，通过遍历当前的对象可以得到；
        Consumer<String> consumer = (String element) -> {
            System.out.println(element);
        };
        list.forEach(consumer);
        /*
        list.forEach((String element) -> {
            System.out.println(element);
        });
        */
    }


    @Test
    public void testOperation() {
        Operation add = (int a, int b) ->  a + b;
        int result = operate(1, 3, add);
        System.out.println(result);
    }

    public int operate(int a, int b, Operation operation) {
        return operation.operationMethod(a, b);
    }
}


interface Operation {
    int operationMethod(int a, int b);
}

