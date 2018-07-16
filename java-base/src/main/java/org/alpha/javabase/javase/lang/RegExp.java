package org.alpha.javabase.javase.lang;

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
