package org.alpha.javabase.javase.reflect;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Properties;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-14 14:45
 */

class Person{
    String name;
    int age;
    Integer attribute;

    public Person(){}
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void setAttribute(Integer _attribute){
        attribute = attribute;
    }
    public void info(){
        System.out.println("non parameters");
    }

    public void info(String name){
        System.out.println("parameter, name = " + this.name);
        System.out.println("parameter, name = " + name);

    }

    public void info(String name, int age){
        System.out.println("name = " + this.name + " age = " + this.age);
        System.out.println("name = " + name + " age = " + age);
    }
}
public class ReflectInfoTest {
    @Test
    public void methodTest() throws Exception{
        Class clazz = Class.forName("Person");
        // Class<?> clazz = Class.forName("Person");
        // Class clazz1 = Person.class;
        // Class clazz2 = new Person().getClass();
        Method infoMethod = clazz.getMethod("info");
        Person person = new Person("zz", 22);
        infoMethod.invoke(person);
        Method infoMethodWithName = clazz.getMethod("info", String.class);
        infoMethodWithName.invoke(person, "newName zz");
        Method infoMethod2 = clazz.getMethod("info", String.class, int.class);
        infoMethod2.invoke(person, "newName zz", 23);

        Person newPerson = (Person) clazz.newInstance();
    }

    @Test
    public void propertiesTest(){
        Properties props = new Properties();
        props.setProperty("name", "zz");
        props.setProperty("age", "123");
        for (Object key : props.keySet()){
            String strKey = (String) key;
            String value = (String) props.get(key);
            System.out.println(strKey + " = " + value);
        }

        for (String key : props.stringPropertyNames())
            System.out.println("key = " + key + ", value = " + props.get(key));

    }

}
