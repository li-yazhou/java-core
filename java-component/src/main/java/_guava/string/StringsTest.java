package _guava.string;

import com.google.common.base.Strings;
import org.junit.Test;

/**
 * <p>Description: <p/>
 *
 * @author: liyazhou1
 * @date: 2018/7/10
 */
public class StringsTest {

    @Test
    public void isNullOrEmpty() {
        final String country = "中国";
        boolean result = Strings.isNullOrEmpty(country);
        System.out.println("country = " + country);
        System.out.println("Strings.isNullOrEmpty(country) = " + result);
        System.out.println("null = " + null);
    }

}
