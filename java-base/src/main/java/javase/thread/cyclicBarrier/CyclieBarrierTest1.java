package javase.thread.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by ji  .
 */
public class CyclieBarrierTest1 {
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                System.out.println("thread1");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }, "thread1").start();

        Thread t2=new Thread(new Runnable() {
            public void run() {
                System.out.println("thread1");
                try {
                    cyclicBarrier.await(5, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }, "thread2");
        t2.start();

        System.out.println("mainThread");
        try {
//            Thread.sleep(1000);
//            t2.interrupt();
            Thread.sleep(1000 * 50);
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }
}
