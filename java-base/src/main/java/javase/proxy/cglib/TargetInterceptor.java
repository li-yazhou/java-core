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
public class TargetInterceptor implements MethodInterceptor {

    /**
     * 将被增强的对象
     */
    private Object target;


    public TargetInterceptor(Object target) {
        this.target = target;
    }

    /**
     * 拦截所有的目标类方法的调用
     *
     * @param obj           CGLIB动态生成的代理类实例
     * @param method        上文中实体类所调用的被代理的方法引用，目标方法的反射对象，通过Method可以实现仅对部分方法拦截
     * @param args          实例方法的参数
     * @param methodProxy   生成的代理类对方法的代理引用，代替Method对象的一个对象，使用MethodProxy比调用JDK自身的Method直接执行方法效率会有提升
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

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
        // 调用代理类实例上的 methodProxy 方法的父类方法（即实体类TargetObject中对应的方法）
        Object result = methodProxy.invokeSuper(obj, args);

        // 用这种方式会发生死循环，因为方法会被拦截，导致栈溢出
        // method.invoke(o, args);

        System.out.println("result = " + result);

        Object retval = method.invoke(target, args);
        System.out.println("retval = " + retval);

        System.out.println("日志结束....");


        return result;
    }
}
