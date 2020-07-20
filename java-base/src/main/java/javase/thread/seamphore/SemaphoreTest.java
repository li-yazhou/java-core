package javase.thread.seamphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by ji.
 */
public class SemaphoreTest {
    static final Semaphore semaphore = new Semaphore(5);


    public static void main(String[] args) throws InterruptedException {
        Thread t = null;
        for (int i = 0; i < 20; i++) {
            t = new Thread(new Runner(), "thread-" + i);
            t.start();
        }
        Thread.sleep(2000);
        t.interrupt();
    }

    static class Runner implements Runnable {

        public void run() {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " start");
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + " end");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupt");
            }
            semaphore.release(5);
        }
    }
}
