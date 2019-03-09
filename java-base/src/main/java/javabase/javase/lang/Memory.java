package javabase.javase.lang;

import org.junit.Test;

/**
 * <p>
 *
 * @author liyazhou1
 * @date 2018/12/12
 */
public class Memory {
    /*
        变量的内存分析
            基本类型的变量
            引用类型的变量
            引用类型的对象

            静态变量的内存分析


        引用类型对象
            数组
            对象
     */


    @Test
    public void multiDimArray() {
        int[][] mdArray = new int[2][];
        mdArray[0] = new int[]{1, 2};
        mdArray[1] = new int[]{3, 4, 5};
        for (int i = 0; i < mdArray.length; i ++) {
            for (int j = 0; j < mdArray[i].length; j ++) {
                System.out.print(mdArray[i][j] + "\t");
            }
            System.out.println();
        }

        int[][] arr = {
                {1, 2},
                {3, 4, 5}
        };

        int[][] array = new int[][] {
                {1, 2},
                {3, 4, 5}
        };
    }


    /*
        方法调用过程
            方法调用过程是不断入栈和出栈的过程
     */


}
