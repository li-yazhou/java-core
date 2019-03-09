package javabase.javase.lang;

import org.junit.Test;

/**
 * <p>
 *
 * @author liyazhou1
 * @date 2018/12/30
 */
public class VariableParameterDemo {


     /*

     可变参数VariableParameter
     public int add(int x, int... args)
        在三个点前后有无空格皆可以
        以数组的形式访问可变参数

     可变参数解决一个方法接受的参数个数不固定（0个或者多个参数）问题，实际上是数组参数的简化形式。
     可变参数的特点：
        只能出现在参数列表的最后；
        ... 位于变量类型和变量名之间，前后有无空格都可以；
        调用可变参数的的方法时，编译器为该可变参数隐含创建一个数组，在方法体重以数组的形式访问可变参数。

        当不给可变参数传入值时，则认为该可变参数是长度为0的数组，不是空数组
      */

     private int add(int a, int... ints) {
         int sum = a;
         /* 当不给可变参数传入值时，则认为该可变参数是长度为0的数组，不是空数组 */
         System.out.println("ints.length = " + ints.length);
         for (int element : ints) {
             sum += element;
         }
         return sum;
     }

     @Test
     public void testAdd() {
         int result;
         result = add(1, 2, 3, 4);
         System.out.println("result = " + result);

         result = add(2);
         System.out.println("result = " + result);
     }
}
