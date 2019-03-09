package javabase.jdk8.util;

import org.junit.Test;

import java.util.StringJoiner;

/**
 * @author liyazhou1
 * @date 2018/7/31
 */
public class StringJoinerPrimer {

    /*
        StringJoiner
            add()
            merge()
            setEmptyValue()
            length()
            toString()
     */
    @Test
    public void stringJoiner() {
        StringJoiner stringJoiner = new StringJoiner(", ");
        System.out.println("--------------------------");
        stringJoiner.setEmptyValue("empty value");
        System.out.println("stringJoiner = " + stringJoiner);

        stringJoiner.add("lyz")
                .add("zz")
                .add("zhouzhou");
        System.out.println("--------------------------");
        System.out.println("add()");
        System.out.println("stringJoiner = " + stringJoiner);

        System.out.println("--------------------------");
        System.out.println("length()");
        /*
            Returns the length of the String representation of this StringJoiner.
         */
        System.out.println("stringJoiner.length() = " + stringJoiner.length());

        System.out.println("--------------------------");
        StringJoiner stringJoiner1 = new StringJoiner(", ", "[", "]");
        stringJoiner1.add("llyyzz")
                .add("zz")
                .add("zhouzhou");
        System.out.println("stringJoiner1 = " + stringJoiner1);

        System.out.println("--------------------------");
        stringJoiner.merge(stringJoiner1);
        System.out.println("stringJoiner = " + stringJoiner);
        
        stringJoiner1 = stringJoiner1.merge(stringJoiner);
        System.out.println("stringJoiner1 = " + stringJoiner1);
    }
}
