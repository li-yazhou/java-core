package jdk8.change.time;

import org.junit.Test;

import java.time.*;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @date 2018/7/23 22:49
 */
public class DurationTest {


    /**
     * 处理以秒为单位的时间
     */
    @Test
    public void test01() throws InterruptedException {
        Instant start = Instant.now();
        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(2018, Month.JULY, 24);
        LocalTime localTime1 = LocalTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.now();

        Thread.sleep(5000);
        Instant end = Instant.now();
        LocalTime localTime2 = LocalTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.now();

        /* POSITIVE */
        Duration duration = Duration.between(start, end);
        System.out.println("duration = " + duration);

        /* NEGATIVE */
        Duration duration1 = Duration.between(end, start);
        System.out.println("duration1 = " + duration1);

        /* ERROR */
        // Duration duration2 = Duration.between(localDate1, localDate2);
        // System.out.println("duration2 = " + duration2);

        Duration duration3 = Duration.between(localTime1, localTime2);
        System.out.println("duration3 = " + duration3);

        Duration duration4 = Duration.between(localDateTime1, localDateTime2);
        System.out.println("duration4 = " + duration4);
    }

}
