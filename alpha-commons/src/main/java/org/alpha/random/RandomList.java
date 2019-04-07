package org.alpha.random;

import java.util.*;

/**
 * <p>
 *  生产在[a, b]区间的随机数，每轮每个数字生产一次
 * @author liyazhou1
 * @date 2018/11/6
 */
public class RandomList {

    private List<Integer> randomList = new ArrayList<>();

    public List<Integer> generateRandomList() {
        randomList.clear();
        for (int i = 0; i < 10; i ++) {
            randomList.add(i);
        }
        Collections.shuffle(randomList);
        return randomList;
    }


    public int[] generateRandomArray(){
        int[] randomArr = new int[10];
        for (int i = 0; i < randomArr.length; i ++) {
            randomArr[i] = i;
        }
        Random random = new Random();        
        for (int j = randomArr.length-1; j > 1; j --) {
            swap(randomArr, j, random.nextInt(j));
        }
        return randomArr;
    }
    
    private void swap(int[] arr, int i, int j) {
        if (arr == null || arr.length < 1 
                || i < 0 || i >= arr.length
                || j < 0 || j >= arr.length
        ) {
            throw new IllegalArgumentException();
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        RandomList randomList = new RandomList();
        int[] arr = randomList.generateRandomArray();
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));

        System.out.println("randomList = " + randomList.generateRandomList());
    }

}
