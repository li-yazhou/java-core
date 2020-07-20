package javase.thread.demoonclass;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CountDownLatchDemo {


    private static final ExecutorService pool = Executors.newFixedThreadPool(10);


    public static void main(String[] args) throws InterruptedException {

        final ReentrantLock reentrantLock = new ReentrantLock();

        final Condition condition = reentrantLock.newCondition();
        Thread thread = new Thread(new Runnable() {
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    reentrantLock.lock();
                    condition.awaitUninterruptibly();
                }
            }
        });
        thread.start();

        TimeUnit.SECONDS.sleep(1);

        thread.interrupt();
        System.out.println("result");

//        String result = request(10);
//        System.out.println(result);
    }

    private static String request(Integer count) throws InterruptedException {
        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            pool.execute(new Worker(i, countDownLatch));
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        return "处理完成,耗时：" + (end - start);

    }

    static class Worker implements Runnable {
        Integer data;
        CountDownLatch countDownLatch;

        public Worker(Integer data, CountDownLatch countDownLatch) {
            this.data = data;
            this.countDownLatch = countDownLatch;
        }

        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println("countDown");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }

        }
    }
}
