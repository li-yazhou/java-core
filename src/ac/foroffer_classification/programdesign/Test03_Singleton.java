package ac.foroffer_classification.programdesign;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-06-30 14:56
 */
public class Test03_Singleton {
    @Test
    public void test(){
        Singleton01.test();
    }
}


class Singleton01{
    private final static Singleton01 INSTANCE = new Singleton01();
    private Singleton01(){}
    public static Singleton01 getInstance(){
        return INSTANCE;
    }

    public static void test(){
        Singleton01 instance01 = Singleton01.getInstance();
        Singleton01 instance02 = Singleton01.getInstance();
        System.out.println(instance01);
        System.out.println(instance02);
        if (instance01.equals(instance02))
            System.out.println("equals.");
    }
}
