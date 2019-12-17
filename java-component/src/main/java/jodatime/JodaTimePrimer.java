package jodatime;

import org.joda.time.DateTime;

import org.joda.time.LocalDate;
import org.junit.*;

/**
 * <p>Description: <p/>
 *
 * @author liyazhou1
 * @date 2018/7/21 19:13
 */
public class JodaTimePrimer {


    @Test
    public void localDate() {
        LocalDate localDate = new LocalDate();
        System.out.println("localDate = " + localDate);
        // 获取当前日期一个月后的月份的最后一天
        localDate = localDate.plusMonths(1).dayOfMonth().withMaximumValue();
        System.out.println("localDate = " + localDate);

        System.out.println("...........................");
        localDate = new LocalDate();
        System.out.println("localDate = " + localDate);
        // 计算三年前第5个月最后一天的日期（三年前的五月份最后一天）
        localDate = localDate.minusYears(3).monthOfYear().setCopy(5).dayOfMonth().withMaximumValue();
        System.out.println("localDate = " + localDate.toString("yyyy-MM-dd"));
    }


    @Test
    public void localTime() {
        DateTime dateTime = new DateTime();
        System.out.println("dateTime = " + dateTime);
        System.out.println("dateTime = " + dateTime.toString("yyyy.MM.dd"));
        System.out.println("...........................");
    }
}
