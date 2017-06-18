package algorithm.ac.foroffer.top50;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-04 19:54
 *
 * 面试题 49：把字符串转换成整数
 *
 * 考查点：
 *      1. 细节。空字符串，空指针，正负号，前几个数字是0（没啥影响），超出表示范围
 *
 * 思路：
 *      1. 从低位往高位（从右往左）计算
 *
 *
 */
public class Test49 {

    public int strToInt(char[] chars){
        String str = String.valueOf(chars);
        return Integer.valueOf(str); // Integer.parseInt(str);
    }

    public int strToInt2(char[] chars){
        if (chars == null || chars.length == 0) throw new RuntimeException("Invalid input. chars can be null or length is 0.");

        int sign = 1;
        int start = 0;
        if (chars[0] == '-') {
            start = 1;
            sign = -1;
        }
        else if (chars[0] == '+') start = 1;

        return strToIntCore(chars, start, sign);
    }

    private int strToIntCore(char[] chars, int start, int sign) {
        // int value = (int)Math.pow(2, 31); 2147483647,已经强转，表示int型最大值

        long value = sign;
        int base = 1;
        for (int i = chars.length - 1; i >= start; i --){
            if (chars[i] < '0' || chars[i] > '9')
                throw new NumberFormatException(String.valueOf(chars, start, chars.length-start) + ", Invalid input. Element of chars should range from '0' to '9' ");
            // try {  intValue += (chars[i] - '0') * base;  }
            // catch(Exception except){  throw new RuntimeException("beyond the range of int");  }
            value += (chars[i] - '0') * base;
            if (value < Integer.MIN_VALUE || value > Integer.MAX_VALUE)
                throw new NumberFormatException(String.valueOf(chars, start, chars.length-start) + ", beyond the range of int");
            base *= 10;
        }
        return (int)value;
    }


    @Test
    public void test(){
        String[] strs = {
                "123",
                "-123",
                "-0",
                "+123",
                "+12345671111111110",
                "-12345611111111170",
        };
        for (String str : strs){
            System.out.println(strToInt2(str.toCharArray()));
            System.out.println(strToInt(str.toCharArray()));
        }
        // char[] chars = new char[0]; System.out.println(chars.length == 0);
    }

}
