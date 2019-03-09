package javabase.javase.lang;

import org.junit.Test;

/**
 * <p>
 *
 * @author liyazhou1
 * @date 2018/12/12
 */
public class BinOctHexConverter {


    //-----------------------------------------------------------------------------


    public static String toBin(int num) {
        return convert(num, 1, 1);
    }

    public static String toOct(int num) {
        return convert(num, 7, 3);
    }

    public static String toHex(int num) {
        return convert(num, 15, 4);
    }


    private static String convert(int num, int base, int binOctHex) {
        if (num == 0) {
            return "0";
        }

        // to reduce compute complexity, receive this parameter base
        // int base = (int)Math.pow(2, binOctHex) - 1;
        char[] result = new char[32];
        int k = result.length;
        int temp;
        while (num != 0) {
            temp = num & base;
            num >>>= binOctHex;
            result[--k] = (char)(temp < 10 ? temp + '0' : temp - 10 + 'A');
        }

        return new String(result, k, result.length - k);
    }


    //-----------------------------------------------------------------------------


    public String toHexWithArray(int num) {
        char[] chs = {
                '0', '1', '2', '3',
                '4', '5', '6', '7',
                '8', '9', 'A', 'B',
                'C', 'D', 'E', 'F'
        };

        char[] result = new char[8];
        int k = result.length;
        int temp;
        while (num != 0) {
            temp = num & 15;
            num >>>= 4;
            result[--k] = chs[temp];
        }

        return "0X" + new String(result, k, result.length - k);
    }


    public String toHexNoArray(int num) {
        char[] result = new char[8];
        int k = result.length;
        int temp;
        while (num != 0) {
            temp = num & 15;
            num >>>= 4;
            result[--k] = (char)(temp < 10 ? temp + '0' : temp - 10 + 'a');
        }
        return "0X" + new String(result, k, result.length - k);
    }


    @Test
    public void testToHex() {
        int[] ints = {
                -1, -121,
                0, 5, 16, 17, 26, 32, 121
        };
        for (int num : ints) {
            System.out.println("toHexWithArray(" + num + ") = " + toHexWithArray(num));
            System.out.println("toHexNoArray(" + num + ") = " + toHexNoArray(num));
            System.out.println("toHex(num) = " + toHex(num));
            System.out.println("Integer.toHexString(" + num + ") = " + Integer.toHexString(num));
            System.out.println("toOct(" + num + ") = " + toOct(num));
            System.out.println("Integer.toOctalString(" + num + ") = " + Integer.toOctalString(num));
            System.out.println("toBin(" + num + ") = " + toBin(num));
            System.out.println("Integer.toBinaryString(" + num + ") = " + Integer.toBinaryString(num));
            System.out.println("--------------");
        }
    }

}
