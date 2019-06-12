package javase.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author liyazhou1
 * @desc TODO
 * @date 2019/6/6
 */
public class ArrayDemo {

    public static void main(String[] args) {

        testArrayTypeConvert();

    }

    @Test
    public void testArraycopy() {
        int[] originArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] destArray = new int[20];

        Arrays.fill(destArray, 22);
        System.out.println("destArray = " + Arrays.toString(destArray));

        System.arraycopy(originArray, 0, destArray, 10, 5);
        System.out.println("destArray = " + Arrays.toString(destArray));

        int[] newArrayWithDoubleSize = Arrays.copyOf(originArray, originArray.length * 2);
        System.out.println("newArrayWithDoubleSize = " + newArrayWithDoubleSize.length);

    }

    private static void testArrayTypeConvert() {
        Object obj = 1;
        Integer integer = (Integer) obj;
        System.out.println("integer = " + integer);

        Integer[] intArray1 = new Integer[]{1, 2};
        Object[] objArray1 =  intArray1;  // OK
        System.out.println("objArray1 = " + Arrays.toString(objArray1));

        Object arrRefObj = new Integer[]{1, 2};
        Integer[] intArray2 = (Integer[]) arrRefObj;
        System.out.println("intArray2 = " + Arrays.toString(intArray2));

        Object[] arrRef = new Integer[]{1, 2};
        Integer[] intArray3 = (Integer[]) arrRef;
        System.out.println("intArray3 = " + Arrays.toString(intArray3));

        Integer[] intArray5 = (Integer[]) new Object[2];

        Object[] objArray4 = new Object[3];
        Integer[] intArray4 = (Integer[]) objArray4;
        intArray4[1] = 1;
        System.out.println("intArray4 = " + Arrays.toString(intArray4));

        Object[] objArray = new Object[]{1, 2, 3};
        Integer[] intArray = (Integer[]) objArray;  // ERR
        // java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.Integer;
        System.out.println("intArray = " + Arrays.toString(intArray));
    }
}
