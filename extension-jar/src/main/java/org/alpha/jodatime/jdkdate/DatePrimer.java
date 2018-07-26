package org.alpha.jodatime.jdkdate;

import org.junit.Test;

/**
 * <p>Description: <p/>
 *
 * @author liyazhou1
 * @date 2018/7/23 19:22
 */
public class DatePrimer {

    @Test
    public void currentTime() {
        System.out.println(System.currentTimeMillis());
        System.out.println(String.valueOf(System.currentTimeMillis()).length());
    }
}
