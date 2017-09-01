package book.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by liyazhou on 2017/5/31.
 *
 * Lambda表达式的语法
 * 基本语法:
 * (parameters) -> expression
 * 或
 * (parameters) ->{ statements; }
 *
 */
public class LambdaExpression {

    @Test
    public void test01(){
        String[] strs = {
                "abc",
                "bcd",
                "bac",
                "cab",
        };

        Comparator<String> cmp = (String str1, String str2) -> (-str1.compareTo(str2));
        System.out.println(Arrays.toString(strs));
        Arrays.sort(strs, cmp);
        // Arrays.sort(strs, (String str1, String str2) -> (str2.compareTo(str1)));
        System.out.println(Arrays.toString(strs));
    }


    @Test
    public void test02(){
        String[] strs = {
                "abc",
                "bcd",
                "bac",
                "bac",
                "cab",
        };
        List<String> list = Arrays.asList(strs);
        list.forEach((String str) -> System.out.println(str));
    }


}
