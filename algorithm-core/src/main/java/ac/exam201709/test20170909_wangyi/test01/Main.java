package ac.exam201709.test20170909_wangyi.test01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-09-09 14:32
 */
public class Main {

//    @Test
//    public void test(){
//        int[][] arrs = {
//                {1, 10, 100},
//        };
//
//        for (int[] arr : arrs){
//            boolean yes = judge(arr);
//            String result = yes ? "Yes" : "No";
//            System.out.println(result);
//        }
//    }



//    private static boolean judge(int[] arr) {
//        boolean succ = false;
//        List<Integer> part1 = new ArrayList<Integer>();
//        List<Integer> part2 = new ArrayList<Integer>();
//        for (int ele : arr){
//            if (ele % 4 == 0) part1.add(ele);
//            else              part2.add(ele);
//        }
//        int len1 = part1.size();
//        int len2 = part2.size();
//        if (len2 - len1 < 2) succ = true;
//        return succ;
//    }



    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i ++){
            int len = sc.nextInt();
            int[] arr = new int[len];
            for (int j = 0; j < len; j ++){
                arr[j] = sc.nextInt();
            }

            boolean yes = permutation(arr);
            String result = yes ? "Yes" : "No";
            System.out.println(result);
        }

    }

//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        for (int i = 0; i < N; i ++){
//            int len = sc.nextInt();
//            int[] arr = new int[len];
//            for (int j = 0; j < len; j ++){
//                arr[j] = sc.nextInt();
//            }
//
//            boolean yes = permutation(arr);
//            String result = yes ? "Yes" : "No";
//            System.out.println(result);
//        }
//
//    }

    public static boolean permutation(int[] ints){
        if (ints == null) return false;
        return permutation(ints, 0);
    }

    private static boolean permutation(int[] ints, int start) {
        if (start == ints.length) {
            System.out.println(Arrays.toString(ints));
            boolean yes = validate(ints);
            if (yes) return yes;
        }

        for (int idx = start; idx < ints.length; idx++){
            int tmp = ints[idx];
            ints[idx] = ints[start];
            ints[start] = tmp;

            boolean yes = permutation(ints, start+1);
            if (yes) return yes;

            tmp = ints[idx];
            ints[idx] = ints[start];
            ints[start] = tmp;
        }
        return false;
    }

    private static boolean validate(int[] ints) {
        boolean valid = true;
        for (int i = 1; i < ints.length; i ++){
            if (ints[i-1] * ints[i] % 4 != 0){
                valid = false;
                break;
            }
        }
        return valid;
    }


    @Test
    public void test2(){
        int[][] arrs = {
                {1, 10, 100},
                {1, 2, 3, 4}
        };
        for (int[] arr : arrs){
            System.out.println(permutation(arr));
        }
    }

}
