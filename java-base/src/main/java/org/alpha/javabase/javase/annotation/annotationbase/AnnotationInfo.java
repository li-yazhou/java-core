package org.alpha.javabase.javase.annotation.annotationbase;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-12 20:41
 */
public class AnnotationInfo {

    @Test
    public void annotationInfo() throws ClassNotFoundException{
        // Class personClazz = Class.forName("Person");
        Class personClazz = Person.class;
        System.out.println(personClazz);
        // Field[] fields = personClazz.getFields();
        Field[] fields = personClazz.getDeclaredFields();
        for (Field field : fields){
            field.setAccessible(true);
            System.out.println(field.getName());
            // Annotation[] annotations = field.getAnnotations();
            // Annotation[] annotations = field.getDeclaredAnnotations();
            Property property = field.getAnnotation(Property.class);
            System.out.println(property);
        }
    }

    @Test
    public void simpleAnnotationInfo() throws ClassNotFoundException{
        Class objClazz = Class.forName("Person");
        for(Field field : objClazz.getDeclaredFields()){
            String fieldName = field.getName();
            Property prop = field.getAnnotation(Property.class);
            String column = prop.column();
            String type = prop.type();
            String fieldInfo = String.format("field = %s, column = %s, type = %s", fieldName, column, type);
            System.out.println(fieldInfo);
        }
    }

    @Test
    public void defaultAnnotationInfo() throws ClassNotFoundException{
        Class objClazz = Class.forName("Person");
        // Annotation persistent = objClazz.getAnnotation(Persistent.class);
        // TODO: 2017/7/12 多余的强制类型转换
        Persistent persistent = (Persistent) objClazz.getAnnotation(Persistent.class);
        String tableName = "".equals(persistent.table()) ? objClazz.getSimpleName().toLowerCase() : persistent.table();
        System.out.println("tableName = " + tableName);

        for(Field field : objClazz.getDeclaredFields()){
            String fieldName = field.getName();
            Property prop = field.getAnnotation(Property.class);
            String column = "".equals(prop.column()) ? fieldName : prop.column();
            String type = prop.type();
            String fieldInfo = String.format("field = %s, column = %s, type = %s", fieldName, column, type);
            System.out.println(fieldInfo);
        }
    }
}
