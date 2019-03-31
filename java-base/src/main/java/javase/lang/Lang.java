package javase.lang;

import org.junit.Test;

/**
 * <p>
 *
 * @author liyazhou1
 * @date 2018/12/10
 */

public class Lang {


    /*
        java文件命名原则：
            public类型的类，文件名必须和类名保持一致；
            非public类型的类，文件名可以和类名称不一致；
     */


    /*
        运算符
            算术运算符
                +、-、*、/、%
                ++、--
                三元运算符 booleanExp ? retValIfTrue : retValIfFalse


            逻辑运算符（比较运算符）
                &&/&
                ||/|
                ！


            位运算符
                &
                |
                ~
                ^
                <<
                >>
                >>>
     */

    @Test
    public void xor() {
        /*

        xor使用
            不依赖第三个变量交换两个变量的值
            xor 可以作为一个简单的加密方案
                秘钥异或密码两次的结果等于密码

		使用第三方变量的形式，因为阅读性强。
            int c;
            c = a;
            a = b;
            b = c;

        这种方式不要用，如果两个整数的数值过大，会超出int范围，会强制转换。数据会变化。
            a = a + b; //a = 3 + 5;a = 8;
            b = a - b; //3+5-5 = 3;b = 3;
            a = a - b; //3+5-3 = 5;a = 5;

        使用异或运算符交换两个变量的值
            a = a ^ b; //a = 3 ^ 5;
            b = a ^ b; //b = (3^5)^5; b = 3;
            a = a ^ b; //a = (3^5)^3; a = 5;
		*/

        int a = 3;
        int b = 5;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }


    @Test
    public void moveLeft() {
        /*
            最快的方式计算 3 * 1024

            左移

            无符号右移
                每一位都往后移动n位，高位补充0
            有符号右移
                每一位都往后移动n位，高位补充符号位，0正1负
         */
        int x = 3 << 10;
        System.out.println("x = " + x);
    }


    @Test
    public void bitOperator() {
		/*
		对一个整数的最后一个字节，高四位和低四位进行换位。

		int num = 0101-1100 & 255;
		1100-0101
		61 = 0011-1101
			 1101-0011 = 211
		*/

        int num = 61;
        int n1 = num & 15;//低四位
        int n2 = num & (15<<4);//高四位
        int n = n1<<4 | n2>>>4;
        System.out.println("Integer.toBinaryString(num) = " + Integer.toBinaryString(num));
        System.out.println("Integer.toBinaryString(n) = " + Integer.toBinaryString(n));
    }


    /*
        数据类型
            基本数据类型和引用型数据类型

            8种基本数据类型

            基本数据类型之间的自动转换和强制转换
            +、-、*、/、% 等运算符是在进行byte、short、char类型计算时，默认是以int类型进行计算。
                short s = 3;
                //s+=4;
                s = (short)(s + 4);
     */


    /*
       关键字与保留字

            byte
            short
            int
            long
            char
            boolean
            float
            double


            if
            else
            switch
            case
            default
            for
            while
            continue
            break
            return


            private
            public
            protected


            class
            static
            final


            volatile
            synchronized


            strictfp


            implements
            extends


     */


    /*
        变量的作用域
            局部代码块
            静态代码块
            构造代码块
     */



}
