package jdk8.change.time;

import org.junit.Test;

import java.time.Instant;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @date 2018/7/23 22:46
 */
public class InstantTest {

    @Test
    public void test() {
        Instant instant = Instant.ofEpochSecond(2);
        System.out.println("instant = " + instant);
    }

}
