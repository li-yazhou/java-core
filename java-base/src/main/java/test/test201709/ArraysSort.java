package test.test201709;

import java.util.Arrays;
import java.util.Comparator;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-09-17 8:43
 */
public class ArraysSort {


    public static void main(String[] args){
        Integer[] arr = {1, 5, 3, 7, 2};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return (""+o1+o2).compareTo(""+o2+o1);
            }
        });
        System.out.println(Arrays.toString(arr));
    }


}
