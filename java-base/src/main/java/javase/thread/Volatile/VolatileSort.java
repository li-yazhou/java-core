package javase.thread.Volatile;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ji  .
 */
public class VolatileSort {
    ReentrantLock lock = new ReentrantLock();

    public int a = 0;
    public int b = 0;

    public void funA() {
        try {
            lock.lock();
            System.out.println("a++:" + (++a) + ",b++:" + (++b));
            Thread.sleep(1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void funB() {
        try {
            lock.lock();
            System.out.println("a=" + a + ",b=" + b);
            Thread.sleep(1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {

        final VolatileSort volatileSort = new VolatileSort();

        Thread thread = new Thread(new Runnable() {

            public void run() {
                while (true) {
                    volatileSort.funA();
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    volatileSort.funB();
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();
        thread1.start();

    }
}
