package javacore.book.fkjava.ch07_classUsage;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-11 16:49
 */
public class StringTest {
    @Test
    public void test(){
        String str = "aabbaaccddaa";
        int idx = str.lastIndexOf("aa", 2);
//        int idx = str.lastIndexOf("aa");
        System.out.println(idx);
        System.out.println(str.substring(1,str.length()));

        StringBuilder sBuilder = new StringBuilder(str);
        System.out.println(sBuilder);
        System.out.println(sBuilder.length());
        System.out.println(sBuilder.capacity());

        sBuilder.setLength(4);
        System.out.println(sBuilder);
        System.out.println(sBuilder.length());
        System.out.println(sBuilder.capacity());
         // System.out.println(sBuilder.charAt(6));

        sBuilder.setLength(10);
        System.out.println("sBuilder.charAt(6) = " + sBuilder.charAt(6));
        System.out.println("sBuilder.charAt(6) = " + (sBuilder.charAt(6)=='\u0000'));


    }
}
