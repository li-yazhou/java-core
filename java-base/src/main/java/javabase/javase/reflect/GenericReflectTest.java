package javabase.javase.reflect;

import org.junit.Test;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-14 18:18
 */


public class GenericReflectTest {

    public static Object getInstance(String classFullName){
        try{
            Class clazz = Class.forName(classFullName);
            return clazz.newInstance();
        } catch(ClassNotFoundException | IllegalAccessException | InstantiationException exception){
            exception.printStackTrace();
            return null;
        }
    }


    @Test
    public void getInstanceTest(){
        String classFullName = "java.util.DateUtil";
        Date date = (Date) getInstance(classFullName);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:MM:ss");
        String formatDate = sdf.format(date);
        System.out.println(formatDate);
    }


    public static <T> T getInstance(Class<T> classFullName){
        try{
            return classFullName.newInstance();
        } catch(InstantiationException | IllegalAccessException exception){
            exception.printStackTrace();
            return null;
        }
    }

    @Test
    public void getInstanceWithGenericTest(){
        Class clazz;
        try{
            clazz = Class.forName("java.util.Date");
            // 下面的语句不能编译通过，因为在编译时期泛型方法无法确定泛型的类型参数
            // DateUtil date = GenericReflectTest.getInstance(clazz);

            Date date2 = getInstance(Date.class);

        } catch (ClassNotFoundException exception){
            exception.printStackTrace();
        }
    }

    public static <T> T[] newInstance(Class<T> type, int length){
        return (T[]) Array.newInstance(type, length);
    }

    @Test
    public void createArrayInstance(){
        String[] strArr = newInstance(String.class, 10);
        int[][] intArr = newInstance(int[].class, 10);
        Integer[] integerArr1d = newInstance(Integer.class, 10);
        // int[] intArr1d = newInstance(int.class, 10);
    }


    private Map<String, Integer> score;
    @Test
    public void parameterizedTypeTest() throws NoSuchFieldException{
        Class<GenericReflectTest> clazz = GenericReflectTest.class;
        Field field = clazz.getDeclaredField("score");
        Type type = field.getType();
        System.out.println("type = " + type);
        System.out.println("field的普通类型是 " + type);

        Type gType = field.getGenericType();
        if (gType instanceof ParameterizedType){
            ParameterizedType pType = (ParameterizedType) gType;
            Type rawType = pType.getRawType();
            Type[] gArgs = pType.getActualTypeArguments();
            System.out.println("原始类型是 " + rawType);
            for(int i = 0; i < gArgs.length; i ++){
                System.out.println("第 " + i + " 的泛型类型参数是 " + gArgs[i]);
            }
        }
    }


}
