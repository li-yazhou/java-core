package org.alpha.javabase.test.test201709;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-09-01 10:04
 */
public class Test20170901 {

    @Test
    public void fib(){
        int n = 20;
        int first = 0;
        int second = 1;
        int tmp = 0;
        System.out.print(first + "\t" + second + "\t");
        int counter = 2;
        for (int i = 2; i < n; i ++){
            tmp = first + second;
            first = second;
            second = tmp;
            System.out.print(second + "\t");
            counter ++;
            if (counter % 5 == 0) System.out.println();
        }
    }

    public static void main(String... args){
        new Thread(new Runnable() {
            int n = 10;
            @Override
            public void run() {
                while(n-- > 0){
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                }
            }
        }, "thread name").start();
    }
}
