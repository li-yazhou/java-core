package org.alpha.javabase.javase.lang;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * description:
 * author: liyazhou1
 * datetime: 2018/5/18 18:21
 */
public class StringTest {


    /*
        分析 List.toString() 方法

        result
            [aaa, bbb, ccc]
     */
    @Test
    public void testListToString() {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        System.out.println(list);
    }


    /*
        result
            null
     */
    @Test
    public void testStringBuilder() {
        StringBuilder sBuilder = new StringBuilder();
        String s = null;
        sBuilder.append(s);
        System.out.println(sBuilder);
    }


    /*
        result
            null_null
     */
    @Test
    public void testString() {
        String s1 = null;
        String s2 = null;
        System.out.println(s1 + "_" + s2);
    }

}
