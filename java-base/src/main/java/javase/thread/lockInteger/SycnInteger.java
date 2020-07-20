package javase.thread.lockInteger;

import java.util.concurrent.TimeUnit;

public class SycnInteger {

//    Integer a = 1;
//    Integer b = 1;


//    Integer a = new Integer(1);
//    Integer b = new Integer(1);

    Integer a = -129;
    Integer b = -129;
    public static void main(String[] args) {
        new SycnInteger().test();

    }

    public void test(){
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                synchronized (a) {
                    System.out.println("t1");
                    try {
                        TimeUnit.MINUTES.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                synchronized (b) {
                    System.out.println("t2");
                    try {
                        TimeUnit.MINUTES.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
