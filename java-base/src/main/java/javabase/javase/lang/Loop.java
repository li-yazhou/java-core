package javabase.javase.lang;

import org.junit.Test;

/**
 * <p>Description: <p/>
 *
 * @author liyazhou1
 * @date 2018/7/16
 */
public class Loop {


    /*
        循环类型：
            while...do
            do...while
            for


         增强for循环(语法糖)
            语法：
                for(type tmp : iterableVariable){ //... }
            注意事项：
                迭代变量必须在()中定义
                可迭代变量可以是数组或实现了Iterable接口的集合类。
                使用 foreach 遍历 null，会报异常 NullPointerException
                使用 foreach 遍历长度为 0 的数组，不会报异常
            
     */



    /*
        使用 foreach 遍历 null，会报异常 NullPointerException
    */
    @Test
    public void foreachNull() {
        String[] nullArray = null;
        for (String str : nullArray) {
            System.out.println(str);
        }
    }


    /*
        使用 foreach 遍历长度为 0 的数组，不会报异常
     */
    @Test
    public void foreachArray0() {
        String[] array0 = new String[0];
        for (String str : array0) {
            System.out.println(str);
        }
    }
}
