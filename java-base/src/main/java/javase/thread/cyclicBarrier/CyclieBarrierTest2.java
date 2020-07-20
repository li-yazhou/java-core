package javase.thread.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * Created by ji  .
 *
 * CyclicBarrier和CountDownLatch功能类似，可以用来实现 "等待多个线程完成" 的场景。
 * 比如等待A,B两个线程都执行完，才继续后续的操作。
 * </p>
 *  CyclicBarrier比CountDownLatch提供了另外一个功能：
 *  你可以传递一个外加的 Runnable 对象作为初始参数，并且当全部线程都到达同一个点时，CyclicBarrier类 会把这个对象当做线程来执行。
 *  只有这个Runnable执行完成后，await才会被唤醒
 */
public class CyclieBarrierTest2 {
    static CyclicBarrier barrier = new CyclicBarrier(2,new A());

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                System.out.println("thread1");
                try {
                    Thread.sleep(5000L);
                    //此时进入等待条件（CyclicBarrier到0的条件），只有满足条件后，后面的操作才会执行
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }, "thread1").start();

        System.out.println("mainThread");
        try {
            //同样进入等待条件
            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }

    /**
     * 只有执行完该方法后，await才会被唤醒
     */
    private static class A implements Runnable {
        public void run() {
            System.out.println("thread A");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(3);
        }
    }
}
