package javase.thread.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * Created by ji  .
 */
public class ThreadLocalExample {

    static int i = 1;
    static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {//重写该方法,所有线程都可见这个初始化值
            return 1;
        }
    };

    public static class MyRunnable implements Runnable {
        public void run() {

            Integer value = threadLocal.get();
            threadLocal.set(value == null ? 0 : value + 1);
            System.out.println("[" + Thread.currentThread().getName() + "]threadLocal值：" + threadLocal.get());


            i++;
            System.out.println("[" + Thread.currentThread().getName() + "]i：" + i);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable myRunnable = new MyRunnable();

        Thread thread1 = new Thread(myRunnable, "t1");
        Thread thread2 = new Thread(myRunnable, "t2");
        Thread thread3 = new Thread(myRunnable, "t3");

        thread1.start();
        thread2.start();
        thread3.start();

        TimeUnit.SECONDS.sleep(1);
    }
}
