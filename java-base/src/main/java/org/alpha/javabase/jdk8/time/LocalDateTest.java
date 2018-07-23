package org.alpha.javabase.jdk8.time;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

/**
 * <p>Description: </p>
 * <p>
 * @author  lyz
 * @date  2018/7/23 21:50
 */
public class LocalDateTest {

    /**
     * LocalDate的基本使用
     */
    @Test
    public void test01(){
        LocalDate localDate = LocalDate.of(2018, 7, 23);

        int year = localDate.getYear();
        System.out.println("year = " + year);

        Month month = localDate.getMonth();
        System.out.println("month = " + month);
        int lengthOfMonth = localDate.lengthOfMonth();
        System.out.println("lengthOfMonth = " + lengthOfMonth);

        int dayOfMonth = localDate.getDayOfMonth();
        System.out.println("dayOfMonth = " + dayOfMonth);
        int dayOfYear = localDate.getDayOfYear();
        System.out.println("dayOfYear = " + dayOfYear);

        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        System.out.println("dayOfWeek = " + dayOfWeek);

        boolean isLeapYear = localDate.isLeapYear();
        System.out.println("isLeapYear = " + isLeapYear);
    }


    /**
     * 获取当前日期
     */
    @Test
    public void test02(){
        LocalDate today = LocalDate.now();
        System.out.println("today = " + today);

        int year = today.get(ChronoField.YEAR);
        int month = today.get(ChronoField.MONTH_OF_YEAR);
        int day = today.get(ChronoField.DAY_OF_MONTH);
        System.out.println("year-month-day = " + year + "-" + month + "-" + day);
    }


    /**
     * 解析字符串为对象
     */
    @Test
    public void test03() {
        LocalDate localDate = LocalDate.parse("2018-07-23");
        System.out.println("localDate = " + localDate);

        /* ERROR, DateTimeFormatter */
        /*
        LocalDate localDate1 = LocalDate.parse("2018-7-23");
        System.out.println("localDate1 = " + localDate1);

        LocalDate localDate2 = LocalDate.parse("2018.07.23");
        System.out.println("localDate2 = " + localDate2);
        */
    }



}
