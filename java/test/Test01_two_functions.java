package test;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-08 21:47
 */
public class Test01_two_functions {

    /**
     * 编译时不会出现异常，无法判断是否可能有返回值
     */
    public int test01(int x){
        int i = x;
        if (x > 10) return 1;

        while(true){
            if (i < 10) return 1;
            i ++;
        }

    }


    /**
     * 编译时异常，可以判断出可能不存在返回值
     */
//    public int test02(int x){
//        int i = x;
//        if (x > 10) return 1;
//
//        while(x > 100){
//            if (i < 10) return 1;
//            i --;
//        }
//    }
    Integer integer = null;

}
