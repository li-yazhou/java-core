package javabase.jdk8.time;

import org.junit.Test;

import java.time.LocalTime;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @date 2018/7/23 22:13
 */
public class LocalTimeTest {

    @Test
    public void test01() {
        LocalTime localTime = LocalTime.of(22, 13, 55);
        System.out.println("localTime = " + localTime);

        int hour = localTime.getHour();
        int minute = localTime.getMinute();
        int second = localTime.getSecond();
        String hourMinuteSecond = hour + ":" + minute + ":" + second;
        System.out.println("hour:minute:second = " + hourMinuteSecond);
    }

    /**
     * 解析字符串为对象
     */
    @Test
    public void test03() {
        LocalTime localTime = LocalTime.parse("22:23:22");
        System.out.println("localTime = " + localTime);

        /* ERROR, DateTimeFormatter */
        LocalTime localTime1 = LocalTime.parse("25:61:00");
        System.out.println("localTime1 = " + localTime1);
    }

}
