package javase.thread;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 */
public class A {

    static ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 10, TimeUnit.MINUTES, new SynchronousQueue<Runnable>(), new Po() {
    });

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            executor.execute(new Runner(i));
        }
    }

    static class Runner implements Runnable {

        int num;

        public Runner(int num) {
            this.num = num;
        }

        public void run() {
            try {
                System.out.println(num);
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Po implements RejectedExecutionHandler {

        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("aaa");
        }
    }
}
