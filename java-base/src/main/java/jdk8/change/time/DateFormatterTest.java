package jdk8.change.time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @date 2018/7/24 23:57
 */
public class DateFormatterTest {

    /**
     * LocalDate LocalDateTime
     *      format
     */
    @Test
    public void test01() {
        LocalDate localDate = LocalDate.of(2018, 7, 24);

        String s1 = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("s1 = " + s1);
        String s2 = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("s2 = " + s2);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);

        String s3 = localDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println("s3 = " + s3);
        String s4 = localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println("s4 = " + s4);
    }


    /**
     * LocalDate
     *      parse()
     */
    @Test
    public void test02() {
        LocalDate localDate = LocalDate.parse("20180725", DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("localDate = " + localDate);

        LocalDate localDate1 = LocalDate.parse("2018-07-25", DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("localDate1 = " + localDate1);
    }


    /**
     * DateTimeFormatter object
     */
    @Test
    public void test03() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

        LocalDate localDate = LocalDate.now();

        String s = localDate.format(dateTimeFormatter);
        System.out.println("s = " + s);

        LocalDate localDate1 = LocalDate.parse("2018.07.26", dateTimeFormatter);
        System.out.println("localDate1 = " + localDate1);
    }


    @Test
    public void test04() {
        String formattedDateTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
        System.out.println("formattedDateTime = " + formattedDateTime);
    }

}
