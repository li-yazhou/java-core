package algorithm.black.ch03_linear;

/**
 * Created by liyazhou on 2017/2/27.
 */

public class LinearList {
    public static void main(String[] args){
        LinearList obj = new LinearList();
        obj.extendArrLen();
    }

    /* 扩展数组的长度 */
    public void extendArrLen(){
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int[] newArr = new int[arr.length * 2];
//        for(int i = 0; i < arr.length; i++){
//            newArr[i] = arr[i];
//        }
        System.arraycopy(arr,5,newArr,0,4);
        System.out.println(java.util.Arrays.toString(newArr));
        arr = newArr;
        System.out.println(arr.length);

//        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
//        int[] temp = Arrays.copyOf(arr, 5);
//        System.out.println(Arrays.toString(temp));
    }
}
