package javase.proxy.cglib.dao;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author liyazhou1
 * @date 2019/12/17
 */
public class DaoProxyForMethod implements MethodInterceptor {


    /**
     * 拦截目标类的方法
     *
     * @param o Object表示要进行增强的对象
     * @param method Method表示拦截的方法
     * @param objects Object[]数组表示参数列表，基本数据类型需要传入其包装类型，如int-->Integer、long-Long、double-->Double
     * @param methodProxy MethodProxy表示对方法的代理，invokeSuper方法表示对被代理对象方法的调用
     * @return
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        String prefix = "[ V-1 ] ";

        System.out.println(prefix + "invoke before");

        // 调用"原生的方法"
        Object result = methodProxy.invokeSuper(o, objects);

        System.out.println(prefix + "result = " + result);

        // Object value = method.invoke(o, objects);

        // System.out.println("value = " + value);

        System.out.println(prefix + "invoke after");

        return o;
    }
}
