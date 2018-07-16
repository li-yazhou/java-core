package org.alpha.javabase.javase.lang;

import org.junit.Test;

/**
 * <p>Description: <p/>
 *
 * @author liyazhou1
 * @date 2018/7/16
 */
public class Loop {

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
