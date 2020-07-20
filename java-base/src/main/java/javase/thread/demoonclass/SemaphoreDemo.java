package javase.thread.demoonclass;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    private static final ExecutorService pool = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(5);

        for (int i = 1; i <= 100; i++) {
            final int finalI = i;
            pool.execute(new Runnable() {
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(finalI + " 开始买票");
                        long time = (long) (Math.random() * 10 + 1);
                        TimeUnit.SECONDS.sleep(time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println(finalI + " 买票完成");
                        semaphore.release();
                    }
                }
            });
        }
    }
}
