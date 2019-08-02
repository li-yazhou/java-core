package javase.lang;

import lombok.ToString;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * description:
 * author: liyazhou1
 * datetime: 2018/5/18 18:21
 */
public class StringDemo {


    @Test
    public void separators(){
        String[] separators = {
                "\\|",
                "\\.",
                "#",
        };

        String[] texts = {
                "lyz|22|male",
                "lyz.22.male",
                "lyz#22#male"
        };

        for (int i = 0; i < texts.length; i ++) {
            String text = texts[i];
            String separator = separators[i];
            String[] subtexts = text.split(separator);
            String log = text + ", " + separator + " ==> " + Arrays.toString(subtexts);
            System.out.println("log = " + log);
        }
        /*
            log = lyz|22|male, \| ==> [lyz, 22, male]
            log = lyz.22.male, \. ==> [lyz, 22, male]
            log = lyz#22#male, # ==> [lyz, 22, male]
         */
    }


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


    @Test
    public void testIntern() {
        String str = "BEIJING";
        /* fetch value from constant pool */
        String cpy = str.intern();
        boolean eq = str == cpy;
        System.out.println("eq = " + eq);  // true

        String s1 = new String("BEIJING");
        String s2 = new String("BEIJING");
        eq = s1 == s2;
        System.out.println("eq = " + eq);  // false

        eq = s1.intern() == s2.intern();
        System.out.println("eq = " + eq);  // true

        String s3 = "BEIJING";
        String s4 = "BEIJING";
        eq = s3 == s4;
        System.out.println("eq = " + eq);  // true

        System.out.println("(s1 == s3) = " + (s1 == s3)); // false
    }


    @Test
    public void testMethod() {
        String str1 = "China";
        String str2 = new String("China");

        /* equals() */
        boolean eq = str1.compareTo(str2) == 0;
        System.out.println("eq = " + eq);
    }

    @Test
    public void testToUpperCase() {
        String s = "ht5";
        System.out.println("s.toUpperCase() = " + s.toUpperCase());;
    }


}
