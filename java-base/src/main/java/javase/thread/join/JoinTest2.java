package javase.thread.join;

import java.util.concurrent.TimeUnit;

/**
 */
public class JoinTest2 {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runner(), "t1");
        Thread t2 = new Thread(new Runner(), "t2");
        Thread t3 = new Thread(new Runner(), "t3");

        t1.start();
        t2.start();
        t3.start();

        //等待t1,t2结束后输出 end
        t1.join();
        t2.join();
        t3.join();

        System.out.println("end");
    }

    static class Runner implements Runnable {

        public void run() {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("[" + Thread.currentThread().getName() + "]结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
