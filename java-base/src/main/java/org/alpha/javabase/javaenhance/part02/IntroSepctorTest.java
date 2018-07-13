package org.alpha.javabase.javaenhance.part02;

import org.junit.Test;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-12 12:39
 */

class Person{
    private int age;
    public Person(){}
    public Person(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }
}


public class IntroSepctorTest {

    @Test
    public void propertyDescriptorTest() throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        String propertyName = "age";
        PropertyDescriptor pd = new PropertyDescriptor(propertyName, Person.class);
        Method methodGetAge = pd.getReadMethod();
        Method methodSetAge = pd.getWriteMethod();

        Person p = new Person(10);
        int age = (int) methodGetAge.invoke(p);
        System.out.println("age = " + age);

        methodSetAge.invoke(p, 20);
        System.out.println("age = " + p.getAge());
    }


    @Test
    public void propertyTest() throws Exception {
        Person p = new Person(12);
        String propertyName = "age";
        Object retVal = getProperty(p, propertyName);
        System.out.println(propertyName + " = " + retVal);

        setProperty(p, propertyName, 22);
        System.out.println(propertyName + " = " + p.getAge());
    }

    // 不使用getter方法情况下，通过JavaBean对象、属性名称和新的属性值，为JavaBean设置新的属性
    public void setProperty(Object obj, String propertyName, Object newValue) throws Exception {
        // 属性描述符，根据属性名称和字节码获取到该属性的描述符
        PropertyDescriptor pd = new PropertyDescriptor(propertyName, obj.getClass());
        // 通过属性描述符，获取到该属性的写方法，也就是setter方法
        Method setter = pd.getWriteMethod();
        // invoke该属性的写方法Method
        setter.invoke(obj, newValue);
    }

    // 不使用getter方法情况下，通过JavaBean对象、属性名称，获得JavaBean的属性值
    public Object getProperty(Object obj, String propertyName) throws Exception {
        // 属性描述符，根据属性名称和字节码获取到该属性的描述符
        PropertyDescriptor pd = new PropertyDescriptor(propertyName, obj.getClass());
        // 通过属性描述符，获取到该属性的读方法，也就是getter方法
        Method getter = pd.getReadMethod();
        // invoke该属性的读方法Method
        return getter.invoke(obj);
    }
}
