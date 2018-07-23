package org.alpha.javabase.jdk8.time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 * <p>Description: </p>
 *
 * @author  lyz
 * @date  2018/7/23 22:26
 */
public class LocalDateTimeTest {


    /**
     * create LocalDateTime object from LocalDate and LocalTime
     */
    @Test
    public void test01() {
        LocalDateTime localDateTime = LocalDateTime.of(2018, Month.JULY, 23, 22, 35, 55);
        System.out.println("localDateTime = " + localDateTime);

        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(localDate, localTime);
        System.out.println("localDateTime1 = " + localDateTime1);


        LocalDateTime localDateTime2 = localDate.atTime(localTime);
        System.out.println("localDateTime2 = " + localDateTime2);

        LocalDateTime localDateTime3 = localDate.atTime(22, 39, 50);
        System.out.println("localDateTime3 = " + localDateTime3);


        LocalDateTime localDateTime4 = localTime.atDate(localDate);
        System.out.println("localDateTime4 = " + localDateTime4);
    }


    /**
     * generate LocalDate and LocalTime object from LocalDateTime
     */
    @Test
    public void test02() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);

        LocalDate localDate = localDateTime.toLocalDate();
        System.out.println("localDate = " + localDate);

        LocalTime localTime = localDateTime.toLocalTime();
        System.out.println("localTime = " + localTime);
    }



}
