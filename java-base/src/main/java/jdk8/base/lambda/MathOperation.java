package jdk8.base.lambda;

/**
 * 函数式接口，包含一个抽象方法，该方法接收参数
 *
 * @author liyazhou1
 * @date 2018/7/28
 */
@FunctionalInterface
interface MathOperation {

    int operate(int a, int b);

}