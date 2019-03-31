package jdk8.lambda;

/**
 * 操作函数式接口唯一抽象方法的类
 *
 * @author liyazhou1
 * @date 2018/7/28
 */
public class IntComputer {

    /*
     * 定义调用Lambda接口方法的方法，需要接收Lambda接口对象和接口方法需要的参数
     *
     * 其实，Lambda接口的实例可以直接调用接口方法，
     * 但是，为了提高程序的灵活性，需要定义一个方法，
     *      其接收Lambda接口对象和接口方法需要的参数，方法体是接口对象调用接口方法，传入接口方法需要的参数
     */

    /**
     * a, b 是函数式接口的唯一抽象方法需要的参数
     * operation 是函数式接口的引用
     */
    public int compute(int a, int b, MathOperation operation) {
        return operation.operate(a, b);
    }
}
