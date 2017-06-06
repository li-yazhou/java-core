package algorithm.foroffer.top60;

import org.junit.Test;

import java.util.Arrays;


/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-05 21:43
 * 面试题 51：数组中重复的数字
 *
 * 题目：
 *      在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 *      数组中某些数字是重复的，但不知道有几个数字重复了，也不知道
 *      每个数字重复了几次。请找出数组中任意一个重复的数字。例如，
 *      如果输入长度为 7 的数组 {2, 3, 1, 0, 2, 5, 3}，那么对应
 *      的输出是重复的数字 2 或者 3。
 *
 * 考查点：
 *
 * 思路：
 *      1. 方法一：
 *          时间复杂度小，需要辅助空间
 *          需要一个保存数字以及其出现次数的 map
 *      2. 方法二：
 *           时间复杂度高，空间复杂度是 O(1)
 *           两层循环遍历所有的数字
 *
 */
public class Test51 {

    public int findOneDuplicateDigit(int[] array){
        if (array == null || array.length == 0) throw new RuntimeException("Invalid input.");
        // Map<Integer, Integer> map = new HashMap<>();
        int[] entrys = new int[array.length];
        int result = -1;
        for (int i = 0; i < array.length; i++){
            entrys[array[i]] += 1;
            if (entrys[array[i]] > 1) {
                result = array[i];
                break;
            }
        }
        System.out.println(Arrays.toString(entrys));
        return result;
    }

    public int findOneDuplicateDigit2(int[] array){
        if (array == null || array.length == 0) throw new RuntimeException("Invalid input.");
        int result = -1;
        for (int i = 0; i < array.length; i ++){
            for (int j = i+1; j < array.length; j ++){
                if (array[i] == array[j]) return array[i];
            }
        }
        return result;
    }

    @Test
    public void test(){
        int[] array = {1, 2, 3, 5, 7, 2, 1, 3};
        System.out.println(findOneDuplicateDigit(array));
        System.out.println(findOneDuplicateDigit2(array));
    }
}
