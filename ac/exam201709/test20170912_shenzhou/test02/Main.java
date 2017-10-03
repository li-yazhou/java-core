package exam201709.test20170912_shenzhou.test02;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-09-12 22:00
 */
public class Main {

    public static void main(String[] args){
        //int[] input = new int[] { 12, 1, 50, 8, 9, 8, 6, 7, 10, 3 };
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] elements = line.split(",");

        int[] input = new int[elements.length];
        for (int i = 0; i < input.length; i ++)
            input[i] = Integer.valueOf(elements[i]);

        qsort(input);
        // Arrays.sort(input);
//        for (int ele : input)
//            System.out.print(ele + " ");
        for (int i = 0; i < input.length; i ++){
            if (i != input.length-1) System.out.print(input[i] + " ");
            else                     System.out.println(input[i]);
        }
    }

    private static void qsort(int[] input) {
        if (input == null || input.length < 2) return;
        qsort(input, 0, input.length-1);
    }

    private static void qsort(int[] input, int low, int high) {
        if (low < high) {
            int mid = partition(input, low, high);
            qsort(input, low, mid-1);
            qsort(input, mid + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int key = arr[low];
        while (low < high){
            for (; low < high && arr[high] > key; high --);
            if (low < high){
                arr[low] = arr[high];
                low ++;
            }

            for (; low < high && arr[low] < key; low ++);
            if (low < high){
                arr[high] = arr[low];
                high --;
            }
        }
        arr[low] = key;
        return low;
    }
}
