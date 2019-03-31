package javase.lang;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-11 20:11
 */
public class VariableParameter {

    public int add(int... args){
        int sum = 0;
        for (int i : args) sum += i;
        return sum;
    }

    @Test
    public void addTest(){
        int result = add();
        System.out.println(result);

        result = add(1,2,3,4);
        System.out.println(result);
    }
}
