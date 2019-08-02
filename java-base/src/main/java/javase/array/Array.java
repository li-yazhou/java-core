package javase.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * <p>
 *
 * @author liyazhou1
 * @date 2018/12/11
 */
public class Array {

    /*
        内存的划分：
            1. 寄存器。
            2. 本地方法区。
            3. 方法区。
            4. 栈内存。
                存储的都是局部变量。
                而且变量所属的作用域一旦结束，该变量就自动释放。
            5. 堆内存。
                存储是数组和对象(其实数组就是对象) 凡是new建立在堆中。
                特点：
                1，每一个实体都有首地址值。
                2，堆内存中的每一个变量都有默认初始化值，根据类型的不同而不同。整数是0，小数0.0或者0.0f，boolean false char '\u0000'
                3，垃圾回收机制。


         数组的内存分析
            数组的引用存放在栈中
            数组对象存放在堆中

     */



    /*
        定义并初始化数组
            静态初始化数组，定义数组变量值时就进行初始化；
            动态初始化数组，定义数组和初始化数组两个动作分开操作；
     */

    @Test
    public void defineArray() {
        char[] charArray = new char[]{'a', 'b', '0', '1', '2'};
        /* 语法糖，只有在定义并初始化变量时可以使用 */
        char[] chars = {'a', 'b', '0', '1', '2'};
        System.out.println("Arrays.toString(chars = " + Arrays.toString(chars));

        int[] intArray = new int[10];
        for (int i = 0; i < intArray.length; i ++) {
            intArray[i] = i;
        }
        System.out.println("Arrays.toString(intArray) = " + Arrays.toString(intArray));
    }



    public String toHex(int num) {
        char[] chs = {
                '0', '1', '2', '3',
                '4', '5', '6', '7',
                '8', '9', 'A', 'B',
                'C', 'D', 'E', 'F'
        };

        StringBuilder sb = new StringBuilder(8);
        char[] result = new char[8];
        int k = result.length;
        int temp;

        for (int i = 0; i < 8; i ++) {
            temp = num & 15;
            num >>>= 4;
            result[--k] = chs[temp];

            sb.append(chs[temp]);
        }


        for (int i = sb.length() - 1; i > 0; i --) {
            if (sb.charAt(i) != '0') {
                break;
            } else {
                sb.deleteCharAt(i);
            }
        }

        return "0X" + new String(result);
    }


    @Test
    public void testToHex() {
        int[] ints = {5, 16, 17, 26, 32, 121};
        for (int num : ints) {
            System.out.println("toHex(" + num + ") = " + toHex(num));
        }
    }

}
