package practice;

import java.util.Arrays;

/**
 * @author liyazhou1
 * @date 2020/2/14
 */
public class StringDemo {


    public static void main(String[] args) {
//        String str = "";
        String str = "abc";
        String[] strs = str.split(",");
        System.out.println("Arrays.toString(strs) = " + Arrays.toString(strs));
        System.out.println("strs.length = " + strs.length);
        System.out.println("strs[0] = [" + strs[0] + "]");
/*        Integer[] ints = new Integer[strs.length];
        for (int i = 0; i < ints.length; i ++) {
            System.out.println(i);
            ints[i] = Integer.parseInt(strs[i]);
        }*/
    }

}
