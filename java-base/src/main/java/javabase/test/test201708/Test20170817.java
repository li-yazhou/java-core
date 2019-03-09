package javabase.test.test201708;

import org.junit.Test;

import java.util.Arrays;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-17 21:54
 */
public class Test20170817 {

/*

* @param      src      the source array.
* @param      srcPos   starting position in the source array.
* @param      dest     the destination array.
* @param      destPos  starting position in the destination data.
* @param      length   the number of array elements to be copied.

public static native void arraycopy(Object src,  int  srcPos,
                                    Object dest, int destPos,
                                    int length);
 */

    @Test
    public void test01(){
        int[] arr = {1, 2, 3, 4, 5};
        int[] arrcp = new int[arr.length];
        System.arraycopy(arr, 0, arrcp, 0, arr.length);
        System.out.println(Arrays.toString(arrcp));
    }


    @Test
    public void test02(){
        int[] arr = {1, 2, 3, 4, 5};
        // int[] arrcp = new int[arr.length];
        // System.arraycopy(arr, 0, arrcp, 0, arr.length);

        int[] arrcp1 = Arrays.copyOf(arr, arr.length);
        System.out.println("arr == arrcp1 ? " + (arr == arrcp1));
        System.out.println(Arrays.toString(arrcp1));

        System.out.println();

        int[] arrcp2 = Arrays.copyOfRange(arr, 1, 3);
        System.out.println("arr == arrcp2 ? " + (arr == arrcp2));
        System.out.println(Arrays.toString(arrcp2));
    }

}
