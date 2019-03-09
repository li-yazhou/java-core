package javabase.test.test201708;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-08 21:47
 */
public class Test01_two_functions {


    public static void main(String[] args) {

    }

    /**
     * 编译时不会出现异常，无法判断是否可能有返回值
     * 当 x = 10 死循环
     */
    public int test01(int x){
        if (x > 10) return 1;

        /* 无法判断是否可能有返回值 */
        while(true){
            if (x > 10) return 1;
        }
    }


    /**
     * 编译时异常，可以判断出可能不存在返回值
     */
    public int test02(int x){
        if (x > 10) return 1;

        while(x > 5){
            if (x > 10) return 1;
        }
        /* 必须 */
        return -1;
    }

    /**
     * 编译时异常，可以判断出可能不存在返回值
     */
    public int test03(int x){
        if (x < 10) return 1;

        while(x >= 10){
            return 1;
        }
        /* 必须 */
        return -1;
    }
}
