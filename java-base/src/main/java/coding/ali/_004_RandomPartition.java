package coding.ali;

import java.util.Arrays;
import java.util.Random;

/**
 * 写一个方法,入参为自然数n  (n > 0)，返回一个自然数数组，数组长度为n，元素为[1,n]之间，且每个元素不重复，数组中各元素顺序要求随机；
 * 
 * @author liyazhou1
 * @date 2019/11/25
 */
public class _004_RandomPartition {
    
    
    public int[] randomPartitionArray(int n) {
        
        int[] nums = new int[n];
        
        for (int i = 0; i < nums.length; i ++) {
            nums[i] = i + 1;
        }
        
        Random random = new Random();
        for (int j = 0; j < nums.length; j ++) {
            int tmp = random.nextInt(nums.length);
            swap(nums, j, tmp);
        }
        
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] partitions = new _004_RandomPartition().randomPartitionArray(10);
        System.out.println("Arrays.toString(partitions) = " + Arrays.toString(partitions));
        
    }

}
