package javabase.javase.proxy;

import org.junit.Test;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Collection;
/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-13 10:33
 */

public class ProxyTest0 {

    public static void main(String[] args) throws Exception{
        final ArrayList target = new ArrayList(); // 方法里的内部类访问局部变量，需要加 final
        Collection proxy = (Collection)getProxy(target, new MyAdvice0());
        proxy.add("aaa");
        proxy.add("bbb");
        proxy.add("ccc");
    }



    /**
     * 动态代理类
     * 创建实现了某个接口的动态类
     */
    @Test
    public void proxyClassTest() {
        Class clazzProxy = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
        System.out.println(clazzProxy.getName());

        Constructor[] cons = clazzProxy.getConstructors();
        Method[] methods = clazzProxy.getDeclaredMethods();
        System.out.print("\n-----------------constructors-----------------");
        printMethodOrConstructor(cons);
        System.out.print("\n-----------------methods-----------------");
        printMethodOrConstructor(methods);
    }


    /**
     * 打印方法的签名
     * @param executables 构造方法或者普通方法，Constructor和Method都实现了抽象类 Executable
     */
    private void printMethodOrConstructor(Executable[] executables){
        for (Executable executable : executables){
            String methodName = executable.getName();
            StringBuilder sBuilder = new StringBuilder();
            sBuilder.append(methodName);
            sBuilder.append('(');
            // Class<?>[] clazz = con.getParameterTypes();
            Class[] clazzTypes = executable.getParameterTypes();  // 获取方法的参数
            for (Class type : clazzTypes)
                sBuilder.append(type.getName()).append(",");
            if (sBuilder.charAt(sBuilder.length()-1) == ',')  // 可能没有执行以上的循环
                sBuilder.deleteCharAt(sBuilder.length()-1);
            sBuilder.append(')');
            System.out.println(sBuilder);
        }
    }


    /**
     * 获取字节码中的所有方法
     * @param clazzProxy1
     */
    private  void getMethodsInfo(Class clazzProxy1) {
        String margin = "*******************";
        System.out.println(margin + "start methond list" + margin);
        Method[] methods = clazzProxy1.getMethods();
        for (Method method : methods) {
            StringBuilder sBuilder = new StringBuilder(method.getName());
            sBuilder.append('(');
            Class[] clazzParams = method.getParameterTypes();
            for (Class classParam : clazzParams) {
                sBuilder.append(classParam.getName());
                sBuilder.append(',');
            }
            if(clazzParams != null && clazzParams.length > 0){
                sBuilder.deleteCharAt(sBuilder.length()-1);
            }
            sBuilder.append(')');
            System.out.println(sBuilder);
        }
    }


    /**
     * 获取字节码中的构造方法
     * @param clazzProxy1
     */
    private void getConstructorsInfo(Class clazzProxy1) {
        String margin = "-----------------";
        System.out.println(margin+ "start constructor list" + margin);
        //Constructor[] constructors = clazzProxy1.getConstructors();
        Constructor[] constructors = clazzProxy1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            StringBuilder sBuilder = new StringBuilder(constructor.getName());
            Class[] clazzParams = constructor.getParameterTypes();
            sBuilder.append("(");
            for (Class class1 : clazzParams) {
                sBuilder.append(class1.getName());
                sBuilder.append(",");
            }
            if(clazzParams != null && clazzParams.length > 0){
                sBuilder.deleteCharAt(sBuilder.length() - 1);
            }
            sBuilder.append(")");
            System.out.println(sBuilder);
        }
    }


    //-----------------------------------------------------------------------------------------------


    /**
     * 通过代理创建对象
     * @param clazzProxy1
     * @return
     */
    private static Collection newInstanceByProxy(Class clazzProxy1) throws Exception {
        Constructor constructor = clazzProxy1.getConstructor(InvocationHandler.class);
        Collection coll = (Collection)constructor.newInstance(new InvocationHandler(){
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });
        return coll;
    }


    /**
     * 创建代理类的实例
     * 代理类的实例方法调用的限制
     */
    @Test
    public void newInstanceByProxyTest()
            throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class clazzProxy1 = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
        Constructor constructor = clazzProxy1.getConstructor(InvocationHandler.class);
        Collection coll = (Collection)constructor.newInstance(new InvocationHandler(){
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });
        System.out.println(coll); // null，但并非是空指针，而是返回值是 null 字符串
        System.out.println(coll.toString());
        //int size = coll.size();
        //调用有返回值的方法会出现异常，因为返回值是 invoke的返回结果 null，null无法转换为int或其他类型，
        //但是可以转换为 void 类型，即无返回值
        coll.clear();
    }


    @Test
    public void getProxyByHardCode() {
        System.out.println("new proxy instance ");
        Collection collProxy = (Collection)Proxy.newProxyInstance(
                Collection.class.getClassLoader(),
                new Class[]{Collection.class},
                new InvocationHandler(){
                    // 此处是硬编码，缺乏灵活性
                    ArrayList target = new ArrayList(); // 目标对象（联想公司电脑销售部）
                    @Override
                    /**
                     * proxy: 代理对象，帮助目标对象做事情的对象（卖联想电脑的代理商）
                     * method: 代理对象要执行目标对象要完成的任务（帮A买联想电脑）
                     * args: method方法需要的参数（需要的联想电脑的性能参数）
                     *
                     * 代理最简单的实现是 return method.invoke(target, args);
                     * 但是代理在返回值之前可以做其他事情，比如说过滤 args参数，不合格不予执行等等。
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // return method.invoke(target, args);
                        System.out.println("execute.....");
                        long startTime = System.currentTimeMillis();
                        Thread.sleep(1000);
                        Object retVal = method.invoke(target,args);
                        long endTime = System.currentTimeMillis();
                        System.out.println(method.getName() + " execute time is " + (endTime - startTime));
                        return retVal;
                    }

                });
        collProxy.add("123");
        collProxy.add("abc");
        int size = collProxy.size(); //invoke的返回值
        System.out.println(size);
        System.out.println(collProxy.getClass().getName());// com.sun.proxy.$Proxy0
        //分析：查看 Proxy API文档：
        //对于从Object继承过来的方法，只有 equals,hashCode和toString三个方法委托给handler处理，其他方法自己处理，如getClass方法
    }



    /**
     * 生成动态代理对象，（联想电脑销售代理商）
     * @param target，目标类，（联想电脑销售部）
     * @param myAdvice，其他业务对象
     * @return 返回代理对象
     */
    private static Object getProxy(final ArrayList target, final MyAdvice0 myAdvice) {
        Object proxy = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),	//target字节码的类加载器
                target.getClass().getInterfaces(),  //target实现的接口
                new InvocationHandler(){			//代理通过handler调用target的方法
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        myAdvice.beforeMethod(method);
                        Object retVal = method.invoke(target, args);
                        myAdvice.afterMethod(method);
                        return retVal;
                    }
                });
        return proxy;
    }

}
