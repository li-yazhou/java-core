package javase.thread.interupt;

import java.util.concurrent.TimeUnit;

/**
 * Created by ji.
 */
public class Interupt {
    public static void main(String[] args) throws InterruptedException {

        Thread sleepThread = new Thread(new SleepRunner());
        sleepThread.setDaemon(true);
        Thread bussyThread = new Thread(new BussyRunner());
        bussyThread.setDaemon(true);

        sleepThread.start();
        bussyThread.start();

        TimeUnit.SECONDS.sleep(2);

        sleepThread.interrupt();
        bussyThread.interrupt();

        System.out.println("sleep isInterrupted:" + sleepThread.isInterrupted());
        System.out.println("busy isInterrupted:" + bussyThread.isInterrupted());

        TimeUnit.SECONDS.sleep(2);
    }

    static class SleepRunner implements Runnable {

        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class BussyRunner implements Runnable {

        public void run() {
            while (true) {
            }
        }
    }
}
