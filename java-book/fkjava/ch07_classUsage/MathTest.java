package fkjava.ch07_classUsage;

import org.junit.Test;

import java.util.Random;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-11 17:04
 */
public class MathTest {
    @Test
    public void testRandom(){
        Random random = new Random(10);
        for (int i = 0; i < 10; i ++) System.out.print(random.nextInt(10) + "\t");
        System.out.println();
        Random random2 = new Random(10);
        for (int i = 0; i < 10; i ++) System.out.print(random2.nextInt() + "\t");
        Double d = new Double("123.0");
        double x = d.doubleValue();

    }
}
