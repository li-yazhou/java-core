package javase.test;


import javase.lang.AccessPermission;

/**
 * @author liyazhou1
 * @desc TODO
 * @date 2019/6/4
 */
public class AccessPermissionTest {

    public static void main(String[] args) {
        /*
            在不同的包下，无法访问包访问权限的类
         */
//        DefaultClass defaultClass = new DefaultClass(); // ERR

        /*
            默认构造方法的访问权限和类的访问权限相同
         */
        AccessPermission accessPermission = new AccessPermission();
    }
}
