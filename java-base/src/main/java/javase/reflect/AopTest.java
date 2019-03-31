package javase.reflect;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-14 16:52
 */
interface Dog{
    void info();
    void run();
}

class GunDog implements Dog{

    @Override
    public void info() {
        System.out.println("i am a gun dog.");
    }

    @Override
    public void run() {
        System.out.println("gun dog run fast.");
    }
}

/**
 * 包装目标对象的方法
 */
class DogUtil{
    public static void before(){
        System.out.println("调用方法之前执行。。。。");
    }

    public static void after(){
        System.out.println("调用方法之后执行。。。。");
    }
}


class DogInvocationHandler implements InvocationHandler{
    private Object target;  // 被代理的对象
    public void setTarget(Object _target){ target = _target; }

    /**
     * InvocationHandler的invoke方法
     * @param proxy 被代理的对象
     * @param method invoke中要执行的方法
     * @param args method方法中的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        DogUtil.before();

        Object result = method.invoke(target, args);  // Method 的 invoke 方法

        DogUtil.after();

        return result;
    }
}

class ProxyFactory{
    /**
     * 为指定的 target 生成动态代理对象
     * @param target 目标对象
     * @return 代理对象
     */
    public static <T> T getProxy(T target){
        DogInvocationHandler handler = new DogInvocationHandler();
        handler.setTarget(target);
        return (T)Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), handler);
    }
}

public class AopTest {

    @Test
    public void proxyTest(){
        Dog gunDog = new GunDog();
        Dog proxyDog = ProxyFactory.getProxy(gunDog);
        proxyDog.info();
        proxyDog.run();

    }

}
