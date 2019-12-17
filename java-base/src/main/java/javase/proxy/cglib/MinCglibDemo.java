package javase.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author liyazhou1
 * @date 2019/12/16
 */
public class MinCglibDemo {

    public Object run(String input) {
        System.out.println("input = " + input);
        return input + "_" + input;
    }


    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(MinCglibDemo.class);

        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

                System.out.println("before ...");

                Object result = methodProxy.invokeSuper(obj, args);

                System.out.println("after ...");

                return result;
            }
        });

        MinCglibDemo proxy = (MinCglibDemo) enhancer.create();

        Object result = proxy.run("2019-12-16 20:25:49");

        System.out.println("result = " + result);

    }
}
