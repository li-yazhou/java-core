package javabase.javase.reflect;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-14 15:59
 */

interface Student{
    void walk();
    void sayHello(String name);
}

class MyInvocationHandler implements InvocationHandler {

    /**
     * 执行动态代理类的所有方法时，都会被替换执行如下的invoke方法
     * @param proxy 动态代理对象
     * @param method 正在执行的方法
     * @param args 调用目标方法时，传入的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-------------正在执行的方法：" + method);
        if (args != null){
            System.out.print("-------------调用目标方法时，传入的实参：");
            System.out.println(Arrays.toString(args));
        }
        else
            System.out.println("调用该方法时，没有传入实参！");
        return null;
    }
}


public class ProxyTest {

    @Test
    public void invocationHandlerTest(){
        // 创建一个 InvocationHandler 对象
        InvocationHandler handler = new MyInvocationHandler();
        // 使用指定的InvocationHandler生成一个动态代理对象
        Student student = (Student) Proxy.newProxyInstance(Student.class.getClassLoader(),
                new Class[]{Student.class}, handler);
        student.walk();
        student.sayHello("zz");
    }
}
