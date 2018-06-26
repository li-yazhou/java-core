package test.test201708;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-14 10:43
 */
public class Test20170814 {
    @Test
    public void test(){
        ArrayList<Integer> list = new ArrayList<Integer>(10);
        list.add(5, 1);
        System.out.println(list);
    }


    @Test
    public void test02(){
        Integer[] array = new Integer[10];
        array[5] = 1;
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
        System.out.println(list);
    }
}
