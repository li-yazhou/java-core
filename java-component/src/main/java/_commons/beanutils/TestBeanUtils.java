package _commons.beanutils;


import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @brief: TODO
 * @author: liyazhou1
 * @date: 2018/6/19
 */
public class TestBeanUtils {

    public static void main(String... args) {
        System.out.println("test beanutils...");
    }


    @Test
    public void testBeanMap() {

    }


    /**
     * BeanUtils
     * static void	populate(Object bean, Map<String,? extends Object> properties)
     */
    @Test
    public void testPopulate() throws InvocationTargetException, IllegalAccessException {
        String id = "no001";
        String name = "zz";
        String gender = "male";
        int age = 10;

        Map<String, Object> properties = new HashMap<>();
        properties.put("ID", id);
        properties.put("name", name);
        properties.put("gender", gender);
        properties.put("age", age);


        Student student = new Student();
        BeanUtils.populate(student, properties);
        System.out.println(student);
    }


}
