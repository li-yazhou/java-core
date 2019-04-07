package javase.thread.base;

import org.junit.Test;

import java.util.Arrays;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-09 18:42
 */
public class Test1 {
    @Test
    public void test(){
        char a = '\u0000';
        System.out.println(a);
        String[][] strs = {{"aaa"},{"bbb"}};
        test("aaa", "bbb", "ccc");
        int x = 0;
        double y = 1/0.0;
        Integer X = Integer.valueOf("123");
        Integer Y = x;
        // String str = new String(1);
        for (SeasonEnum ele : SeasonEnum.values()){
            System.out.println(ele);
        }
        System.out.println(SeasonEnum.SPRING.name());
        System.out.println(SeasonEnum.SPRING);


    }

    public void test(String... names){
        System.out.println(Arrays.toString(names));
    }
}


class Base{
    //private Base(int x){}
    // public Base(){}
}
class Sub extends Base{
    public Sub(int x){
        //super(x);
    }

}

class Singleton{
    private final static Singleton INSTANCE;
    static {
        INSTANCE = new Singleton();
    }
}

enum SeasonEnum{
    SPRING, SUMMER, AUTUMN, WINTER
}