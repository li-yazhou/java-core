package commons.beanutils;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <p>Description: <p/>
 *
 * @author liyazhou1
 * @date 2018/7/21 15:18
 */
public class MethodTest {

    @Test
    public void methodInvoke() {
        Student student = new Student("001", "zhou", 20, "male");
        Class<Student> studentClass = Student.class;
        String getName = "getName";
        String setName = "setName";


        String name = null;
        try {
            name = BeanUtils.getProperty(student, "name");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println("name = " + name);


        Method method = null;
        try {
            method = studentClass.getMethod("getName");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(method.invoke(student));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        try {
            studentClass.getMethod("getName").invoke(student);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            Student s = studentClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
