package jdk8.change.time;

import org.junit.Test;

import java.time.Duration;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @date 2018/7/23 23:03
 */
public class PeriodTest {

    @Test
    public void test01() {
        Duration _3Minutes = Duration.ofMinutes(3);
        System.out.println("_3Minutes = " + _3Minutes);

        Duration _3Minutes2 = Duration.of(3, ChronoUnit.MINUTES);
        System.out.println("_3Minute2 = " + _3Minutes2);

        Period _10Days = Period.ofDays(10);
        System.out.println("_10Days = " + _10Days);

        Period _3Weeks = Period.ofWeeks(3);
        System.out.println("_3Weeks = " + _3Weeks);

        Period _2Year6Months5Days = Period.of(2, 6, 5);
        System.out.println("_2Year6Months5Days = " + _2Year6Months5Days);

        /*
            _3Minutes = PT3M
            _3Minute2 = PT3M
            _10Days = P10D
            _3Weeks = P21D
            _2Year6Months5Days = P2Y6M5D
         */
    }


}
