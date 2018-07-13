package org.alpha.javabase.javaenhance.part03;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-13 9:48
 */
public class ProxyTest {
    /**
     * 动态代理类
     */
    @Test
    public void proxyClassTest(){
        Class clazzProxy = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
        System.out.println(clazzProxy.getName());

        Constructor[] cons = clazzProxy.getConstructors();
        Method[] methods = clazzProxy.getDeclaredMethods();
        System.out.print("\n-----------------constructors-----------------");
        // printMethodOrConstructor(cons);
        System.out.print("\n-----------------methods-----------------");
        // printMethodOrConstructor(methods);


/*      Constructor[] constructors = clazzProxy.getConstructors();
        // Constructor()
        // Constructor(int)
        // Constructor(String, int)
        for (Constructor con : constructors){
            // System.out.println(con.getName());
            String conName = con.getName();
            StringBuilder sBuilder = new StringBuilder();
            sBuilder.append(conName);
            sBuilder.append('(');
            // Class<?>[] clazz = con.getParameterTypes();
            Class[] clazzTypes = con.getParameterTypes();  // 获取方法的参数
            for (Class type : clazzTypes)
                sBuilder.append(type.getName()).append(",");
            if (sBuilder.charAt(sBuilder.length()-1) == ',')  // 可能没有执行以上的循环
                sBuilder.deleteCharAt(sBuilder.length()-1);
            sBuilder.append(')');
            System.out.println(sBuilder);
        }


        Method[] methods = clazzProxy.getDeclaredMethods();
        for (Method method : methods){
            // System.out.println(con.getName());
            String methodName = method.getName();
            StringBuilder sBuilder = new StringBuilder();
            sBuilder.append(methodName);
            sBuilder.append('(');
            // Class<?>[] clazz = con.getParameterTypes();
            Class[] clazzTypes = method.getParameterTypes();  // 获取方法的参数
            for (Class type : clazzTypes)
                sBuilder.append(type.getName()).append(",");
            if (sBuilder.charAt(sBuilder.length()-1) == ',')  // 可能没有执行以上的循环
                sBuilder.deleteCharAt(sBuilder.length()-1);
            sBuilder.append(')');
            System.out.println(sBuilder);
        }*/
    }

    /**
     * 打印方法的签名
     * @param executables 构造方法或者普通方法，Constructor和Method都实现了抽象类 Executable
     */
    /*private void printMethodOrConstructor(Executable[] executables){
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
    }*/

}
