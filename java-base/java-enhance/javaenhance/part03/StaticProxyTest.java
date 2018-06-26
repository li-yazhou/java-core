package javaenhance.part03;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-13 22:10
 */

interface StaticProxy{
    void method();
}

class Target implements StaticProxy{
    @Override
    public void method() {
        System.out.println("Hello world");
    }
}

class AdvancedTarget implements StaticProxy{
    StaticProxy target = new Target();
    @Override
    public void method() {
        System.out.println("before....");
        target.method();  // 调用Target类中的method方法
        System.out.println("after....");
    }
}

public class StaticProxyTest {
}
