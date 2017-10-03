package fkjava.ch07_classUsage;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-11 18:31
 */
public class CalendarTest {

    @Test
    public void testCalendarToDate() throws InterruptedException{
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        Date date = calendar.getTime();
        System.out.println(date);

        Thread.sleep(1000);
        date.setTime(System.currentTimeMillis());
        calendar.setTime(date);
        System.out.println(calendar);
        System.out.println(date);
    }

}
