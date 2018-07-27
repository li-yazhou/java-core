package org.alpha.javabase.jdk8.lambda;

import org.junit.Test;

/**
 * <p>Description: <p/>
 *
 * @author liyazhou1
 * @date 2018/7/27 16:02
 */
public class LambdaExpressionPrimer {

    /*
        Lambda expression eliminates the need of anonymous class and
        gives a very simple yet powerful functional programming capability to Java.


        使用Lambda表达式
            1. 定义一个函数式接口；
            2. 定义一个动作类，动作类包含一个方法，其专门调用函数式接口方法，
                  它接收函数式接口对象和接口方法需要的参数，方法体是
                  通过函数式接口对象调用接口方法；
            3. 创建函数式接口对象；
            4. 创建动作类实例，调用动作类的特定方法（将函数式接口对象和参数
                  传递给动作类的方法，完成函数式接口方法被调用的过程）
     */

    /**
     * 定义Lambda接口，包含一个方法，该方法接收参数
     *      Lambda接口是函数式接口，functional interface
     */
    interface MathOperation {
        int operation(int a, int b);
    }

    /**
     * 定义调用Lambda接口方法的方法，需要接收Lambda接口对象和接口方法需要的参数
     *
     * 其实，Lambda接口的实例可以直接调用接口方法，
     * 但是，为了提高程序的灵活性，需要定义一个方法，
     *      其接收Lambda接口对象和接口方法需要的参数，方法体是接口对象调用接口方法，传入接口方法需要的参数
     */
    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }


    @Test
    public void lambdaExp() {
        MathOperation addition = (int a, int b) -> { return a + b; };
        MathOperation subtraction = (int a, int b) -> a - b;
        MathOperation multiplication = (int a, int b) -> a * b;
        MathOperation division = (a, b) -> a / b;

        LambdaExpressionPrimer lambdaExp = new LambdaExpressionPrimer();
        int a = 20, b = 5;

        // 先创建对象，然后再调用对象的方法，程序不灵活
        System.out.println(a + " + " + b + " = " + addition.operation(a, b));
        System.out.println(a + " + " + b + " = " + subtraction.operation(a, b));
        System.out.println(a + " + " + b + " = " + multiplication.operation(a, b));
        System.out.println(a + " + " + b + " = " + division.operation(a, b));

        System.out.println("................................");

        // 可以将对象作为参数，通过对象传递方法，程序更加灵活，扩展性更强
        System.out.println(a + " + " + b + " = " + lambdaExp.operate(a, b, addition));
        System.out.println(a + " - " + b + " = " + lambdaExp.operate(a, b, subtraction));
        System.out.println(a + " * " + b + " = " + lambdaExp.operate(a, b, multiplication));
        System.out.println(a + " / " + b + " = " + lambdaExp.operate(a, b, division));
    }
}
