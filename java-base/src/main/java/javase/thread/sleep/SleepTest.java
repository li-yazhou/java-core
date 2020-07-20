package javase.thread.sleep;

import java.util.concurrent.TimeUnit;

/**
 * Created by ji.
 */
public class SleepTest {

    static Object lock = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                synchronized (lock) {
                    try {
                        System.out.println("Thread 1");
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                synchronized (lock) {
                    try {
                        System.out.println("Thread 2");
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
        });
        t2.start();

    }


}
