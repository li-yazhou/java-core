package javase.annotation.annotationbase.demo01;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-18 19:26
 */
public class ParseAnnotation {

    /**
     * 解析类上的注解
     *      获取到被注解的类的字节码
     *      判断注解是否存在
     *      如果存在该注解，则获取到该注解对象，通过注解对象获取到注解信息
     */
    @Test
    public void parseDescriptionAnno(){
        try {
            Class clazz = Class.forName("Child");
            boolean exists = clazz.isAnnotationPresent(Description.class);
            if (exists){
                Description desc = (Description) clazz.getAnnotation(Description.class);
                System.out.println(desc.value());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void parseMethodAnnotation(){
        try {
            Class clazz = Class.forName("Child");
            Method[] methods = clazz.getMethods();

            // 方法上的注解，方式一
            for (Method method : methods){
                boolean exists = method.isAnnotationPresent(Description.class);
                if (!exists) continue;
                Description desc =  method.getAnnotation(Description.class);
                System.out.println(desc.value());
            }

            // 方式二
            for (Method method : methods){
                Annotation[] anns = method.getDeclaredAnnotations();
                for (Annotation ann : anns){
                    if (ann instanceof Description){
                        Description desc = (Description) ann;
                        System.out.println(desc.value());
                    }
                }
            }




        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
