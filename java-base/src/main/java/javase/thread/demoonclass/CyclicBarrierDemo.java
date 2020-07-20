package javase.thread.demoonclass;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {

    private static final ExecutorService pool = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

        for (int i = 1; i <= 100; i++) {
            final int finalI = i;
            pool.execute(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(1000);
                        System.out.println(finalI + " 进站");
                        cyclicBarrier.await();
                        System.out.println("-");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
    }

}
