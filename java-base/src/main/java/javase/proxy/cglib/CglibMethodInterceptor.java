package javase.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-22 14:06
 */
public class CglibMethodInterceptor implements MethodInterceptor {

    /**
     * 将被增强的对象
     */
    private Object target;


    public CglibMethodInterceptor(Object target) {
        this.target = target;
    }

    /**
     * 拦截所有的目标类方法的调用
     *
     * @param o             实例
     * @param method        目标方法的反射对象，通过Method可以实现仅对部分方法拦截
     * @param args          实例方法的参数
     * @param methodProxy   方法的代理类
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        // System.out.println("o = " + o);
        System.out.println("method = " + method);
        System.out.println("args = " + Arrays.toString(args));
        System.out.println("methodProxy = " + methodProxy);
        /*
            method = public void javase.proxy.cglib.Train.running()
            args = []
            methodProxy = net.sf.cglib.proxy.MethodProxy@5679c6c6
         */

        System.out.println("日志开始....");


        // 代理类调用父类的方法
        Object result = methodProxy.invokeSuper(o, args);
        System.out.println("result = " + result);


        // method.invoke(o, args); // 导致栈溢出


        Object retval = method.invoke(target, args);
        System.out.println("retval = " + retval);


        System.out.println("日志结束....");


        return result;
    }
}
