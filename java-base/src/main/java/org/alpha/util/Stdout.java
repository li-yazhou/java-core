package org.alpha.util;

/**
 * <p>Description: <p/>
 *
 * @author liyazhou1
 * @date 2018/7/27 18:54
 */
public class Stdout {

    public static void println(Object obj) {
        System.out.println("obj = " + obj);
    }

    public static void println(String repeatContent, int cnt) {
        if (cnt <= 0) { return; }
        for (int i = 0; i < cnt; i ++) {
            System.out.print(repeatContent);
        }
        System.out.println();
    }
}
