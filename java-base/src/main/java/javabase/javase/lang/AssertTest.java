package javabase.javase.lang;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-02 20:30
 */
public class AssertTest {

    public static void main(String[] args){
        // assert("it is true".isEmpty());
        // assert("".isEmpty());
        boolean bool = true;
        assert bool;

        boolean flag = false;
        assert flag: "it is wrong.";

        assert(flag);

        int num = 10;
        assert num != 2 : "num doesn't equal 2";
    }
}
