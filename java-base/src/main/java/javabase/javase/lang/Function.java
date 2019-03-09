package javabase.javase.lang;

/**
 * <p>
 *
 * @author liyazhou1
 * @date 2018/12/11
 */
public class Function {

    /*
        函数的重载 Overload

        函数签名：
            函数名称
            函数参数列表（参数个数、参数类型、参数顺序）

        函数的重载：
            同一个类中，函数名称相同，但函数参数列表不同
            函数重载和返回值类型无关。
            Java是强类型语言，如果函数出现的调用的不确定性，编译将失败。
     */

    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, int b) {
        return a + b;
    }
}
