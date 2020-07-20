package javase.thread.join;

import java.util.concurrent.TimeUnit;

/**
 * Created by ji.
 * 主线程等待其他线程执行完成后再执行后面的逻辑，本例子如何顺序打印t-0,t1 ..... t9
 */
public class JoinTest {

    public static void main(String[] args) {

        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        },"t-0");
        t.start();


        for (int i = 1; i < 10; i++) {
            t = new Thread(new Runner(t), "t-" + i);
            t.start();
        }


    }

    static class Runner implements Runnable {

        Thread t;

        public Runner(Thread t){
            this.t=t;
        }
        public void run() {
            try {
                t.join();
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
}
