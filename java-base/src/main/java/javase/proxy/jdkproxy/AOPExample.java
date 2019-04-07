package javase.proxy.jdkproxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-27 21:36
 */

/**
 * 该接口的实现类的实例需要被代理
 * @param <T>
 */
interface DAO<T>{
    int save(T t);
    T remove(String id);
}

class Student{}

/**
 * 接口的实现类，它的实例需要被代理
 * @param <T>
 */
class StudentDAO<T> implements DAO<T>{
    @Override
    public int save(T t) {
        printCurrentMethodName();
        System.out.println("save data....");
        return 0;
    }

    @Override
    public T remove(String id) {
        printCurrentMethodName();
        System.out.println("delete data....");
        return null;
    }

    private void printCurrentMethodName(){
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        System.out.println(methodName + " starts running....");
    }
}


/**
 * 提供增强操作的类
 */
class SafetyCheck{
    public void before(){
        System.out.println("方法执行之前....安全检查....");
    }

    public void after(){
        System.out.println("方法执行之后....安全检查....");
    }
}

/**
 * 方法调用处理接口的实现类，执行原来的方法之前或之后，添加额外的操作
 */
class DAOInvocationHandler implements InvocationHandler {
    private Object target;

    public void setTarget(Object target){
        this.target = target;
    }
    public DAOInvocationHandler(){}

    public DAOInvocationHandler(Object target){
        this.target = target;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    /**
     *
     * @param proxy
     * @param method 方法
     * @param args 方法的参数
     * @return method方法的返回结果
     * @throws Throwable
     */
    @Override
    // TODO: 2017/7/27 proxy没有被使用。。。
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SafetyCheck util = new SafetyCheck();
        util.before();
        Object result = method.invoke(target, args);
        util.after();
        return result;
    }
}

class DaoProxyFactory{
    public static Object getProxyObject(Object target){
        DAOInvocationHandler handler = new DAOInvocationHandler();
        handler.setTarget(target);
        // 加载被代理对象的类加载器，被代理的对象的接口，和方法调用处理接口的实例传递给Proxy
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), handler);
    }
}


public class AOPExample {
    @Test
    public void testProxy(){
        StudentDAO<Student> target = new StudentDAO<Student>();
        DAO targetProxy = (DAO) DaoProxyFactory.getProxyObject(target);  // 只能转换为接口类型
        targetProxy.save(new Student());
        System.out.println();
        targetProxy.remove("001");
    }


    @Test
    public void testProxy02(){
        StudentDAO<Student> target = new StudentDAO<>();
        DAO proxyInstance = (DAO) new DAOInvocationHandler(target).getProxy();
        proxyInstance.save(new Student());
        System.out.println();
        proxyInstance.remove("0001");
    }

}
