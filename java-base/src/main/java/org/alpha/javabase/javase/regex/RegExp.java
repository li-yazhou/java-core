package org.alpha.javabase.javase.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>Description: <p/>
 *
 * @author liyazhou1
 * @date 2018/7/16
 */
public class RegExp {



    /*
        ? 表示0或者1次，相当于{0,1}
        + 表示1-n次，相当于{1,10}
        * 表示0-n次，相当于{0,10}
     */
    @Test
    public void pattern() {
        String regExp = "(.*)\\.log((\\.out)?)$";
        String[] filenames = {
                "flink.log",
                "flink.log.out",
                "flink.log.out.out",
                "flink.log.1"
        };

        System.out.println("regExp = " + regExp);
        for (String filename : filenames) {
            System.out.println("filename = " + filename);
            boolean matched = Pattern.matches(regExp, filename);
            System.out.println("matched = " + matched);
        }
    }
    /*
        Pattern
            static boolean matches(arg1, arg2)


        Boundary matchers
            ^ The beginning of a line
            $ The end of a line

            String regExp = "(.*)\\.(log)([0-9\\.\\-]{0,})$";
            $ 匹配文本的“后缀”
            {n,} 至少匹配 n 次，{0,} 相当于 *
            {n} 正好匹配 n 次

            () 文本的单元
            {} 出现次数
            [] 匹配内容的并集，组合


            (.*)                .可以匹配任何字符，*表示匹配0或者多次
            \\.                 匹配.
            (log)               匹配log
            ([0-9\\.\\-]{0,})   匹配由数字、圆点和横杠混合组成的字符串，可以为空字符串
     */
    @Test
    public void patternMatches() {
        /*
            (.*)\.(log)([0-9\.\-]{0,})$
            匹配文本的后一段，其中
                包含.log字符串，
                .log之前包括0个多个字符，
                .log之后包含由数字、圆点和横杠混合组成的字符串，可以为空字符串
         */
        String regExp = "(.*)\\.(log)([0-9\\.\\-]{0,})$";
        // String regExp = "(.*)\\.(log)([0-9.\\-]{0,})$";
        String[] texts = {
                "test.log",
                "test.log1",
                "test.log1-",
                "test.log1.-",
                "test.log12.-",
                "test.log123.-",
                "test.log1aaa"
        };


        for (String text : texts) {
            boolean matched = Pattern.matches(regExp, text);
            System.out.println("regExp = " + regExp);
            System.out.println("text = " + text);
            System.out.println("matched = " + matched);
            System.out.println("---------------\n");
        }

    }


    /*
        Pattern
            compile()
            matcher()

        Matcher
            matches()
            find()/group(index[1-x])
     */
    @Test
    public void matchesAndFind() {
        boolean result = Pattern.matches("a*b", "aaaab");
        System.out.println("result = " + result);

        String text = "aaaaaaaabb";

        Pattern p = Pattern.compile("a*b");
        Matcher m = p.matcher(text);

        boolean b = m.matches();
        System.out.println("b = " + b);


        String regExp = "(a*b)";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(text);
        boolean found = matcher.find();
        System.out.println("found = " + found);
        if (found) {
            System.out.println("matcher.group(1) = " + matcher.group(1));
            System.out.println("matcher.group(0) = " + matcher.group(0));
            System.out.println("matcher.group() = " + matcher.group());
        }
    }


    /*
        matcher.find()
        matcher.appendReplacement()
     */
    @Test
    public void matcher() {
        Pattern p = Pattern.compile("cat");
        Matcher m = p.matcher("one cat two cat in the yard");
        StringBuffer sb = new StringBuffer();
        while(m.find()) {
            m.appendReplacement(sb, "dog");
            System.out.println(sb.toString());
        }
        m.appendTail(sb);
        System.out.println(sb.toString());
        /*
            one dog
            one dog two dog
            one dog two dog in the yard
         */
    }



    /*
        1. 正则表达式中以'()'标记的子表达式所匹配的内容就是一个分组(group).
        2. 类似于(?:pattern)格式的子表达式不能算是一个分组

        m.group(g)
            s.substring(m.start(g), m.end(g)) are equivalent

        group从 1 开始索引
     */
    @Test
    public void matcherGroup() {

        String regExp = "(a+)";
        Pattern p = Pattern.compile(regExp);
        String text = "a,ab,aa,bb";


        System.out.println("-------------------------");
        Matcher m = p.matcher(text);
        while (m.find()) {
            System.out.print(text + "[" + m.start() + ", " + m.end() + ") = ");
            System.out.println(m.group());
        }

        System.out.println("-------------------------");
        m = p.matcher(text);
        if (m.find()){
            System.out.println(m.group(1));
        }

        m.find();
        System.out.println(m.group(1));

        m.find();
        System.out.println(m.group(1));

        m.find();
        System.out.println(m.group(1));

        m.find();
        System.out.println(m.group(1));

        /*
            a,ab,aa,bb[0, 1) = a
            a,ab,aa,bb[2, 3) = a
            a,ab,aa,bb[5, 7) = aa
            -------------------------
            a
            a
            aa

            java.lang.IllegalStateException: No match found
         */
    }

}
