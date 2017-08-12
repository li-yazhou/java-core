package javaenhance.part02;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-12 8:54
 */
public class ReflectTest {

    @Test
    public void test01(){
        boolean result = int[].class.isArray();
        System.out.println(result);
    }


}
