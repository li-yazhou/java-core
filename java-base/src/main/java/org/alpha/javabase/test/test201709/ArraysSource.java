package org.alpha.javabase.test.test201709;

import org.junit.Test;

import java.util.Arrays;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-09-04 9:39
 */
public class ArraysSource {
    public static void main(String... args){
        int[] ints = new int[10];
        Arrays.sort(ints);

        Object obj = 1; // new String("abc");
        // Integer integer = (Integer)obj;
        // System.out.println(integer);
        //String s = (String) obj;
        //System.out.println(s);
        Object[] arr = new Object[10];
        //String[] strs = (String[]) arr; // Error
        String[] strs = (String[]) new Object[10];
        strs[1] = "aaaaa";
        System.out.println(Arrays.toString(strs));
    }


    @Test
    public void test01(){
        Item[] items = (Item[]) new Object[10];
        items[0] = new Item();
    }
}


class Item{

}
