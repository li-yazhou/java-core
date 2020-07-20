package javase.thread.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by ji  .
 */
public class CallerRunsTest {

    ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 5, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());

    public void doWork() {
//        executor.prestartAllCoreThreads();
        for (int i = 1; i <= 15; i++) {
            executor.execute(new Worker(i));
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        executor.shutdown();
    }

    public static void main(String[] args) {
        new CallerRunsTest().doWork();
    }

    class Worker implements Runnable {

        private int i;

        public Worker(int i) {
            this.i = i;
        }

        public void run() {
            try {
                System.out.println("[" + Thread.currentThread().getName() + "] " + i + " start");
                TimeUnit.SECONDS.sleep(3);
//                System.out.println("[" + Thread.currentThread().getName() + "] " + i + " end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
