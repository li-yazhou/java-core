package javase.thread.stop;

import java.util.concurrent.TimeUnit;

/**
 * Created by ji.
 */
public class Shutdown {

    static volatile boolean isStop = false;

    public static void main(String[] args) throws InterruptedException {

        Runner runner = new Runner();
        Thread t = new Thread(runner);
        t.start();

        TimeUnit.SECONDS.sleep(2);
//        isStop = true;
        t.interrupt();

    }

    static class Runner implements Runnable {

        private long i;


        public void run() {
            while (!isStop&&!Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println(i);
        }

    }

}
