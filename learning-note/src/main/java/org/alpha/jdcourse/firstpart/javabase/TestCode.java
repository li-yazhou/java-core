package org.alpha.jdcourse.firstpart.javabase;

import org.junit.Test;

/**
 * <p>Description: <p/>
 *
 * @author liyazhou1
 * @date 2018/7/16
 */
public class TestCode {

    @Test
    public void map() {
        String[] strs = {"0", "1", "2"};
    }


    @Test
    public void string() {
        String str1 = "aaa" + "bbb";
        String str2 = new String(str1);
        if (str1 == str2) {
            System.out.println("==");
        } else {
            System.out.println("!=");
        }
    }
}
