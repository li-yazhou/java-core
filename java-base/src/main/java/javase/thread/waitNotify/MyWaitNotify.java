package javase.thread.waitNotify;

import java.util.concurrent.TimeUnit;

/**
 * Created by ji  .
 * wait,notify,notifyAll 是java.lang.Object的方法,每个Object都有这几个方法,
 * 但是使用这几个方法必须先获得这个对象的锁,也就是说必须在同步块里执行,否则会抛出java.lang.IllegalMonitorStateException.
 * 一个线程在同步块里执行wait方法后,会释放同步块的锁,这样其他要使用该对象的wait ,notify,notifyAll方法的线程可以获得锁,来执行.
 * 一个线程执行notify会唤醒该对象的wait方法的其中一个线程,但是该线程不会立马执行,因为notify线程有可能还没有释放该对象的锁,必须notify线程该对象的同步块执行完成释放锁后,wait线程才可以获得锁继续执行.
 * notifyAll会唤醒执行的wait方法的所有线程,notifyAll线程释放锁后,这些wait线程会竞争锁,谁先获得谁先执行,并不能同时执行.
 */
public class MyWaitNotify {
    Object wnObj = new Object();

    public void doWait() throws InterruptedException {
        synchronized (wnObj) {
            System.out.println("Doing wait Operation");
            wnObj.wait();
            System.out.println("Waited Thread Is Notified");
            Thread.sleep(10000L);
        }
    }

    public void doNotify() {
        synchronized (wnObj) {
            wnObj.notify();
            System.out.println("Did notify");
        }
    }

    public void doNotifyAll() throws InterruptedException {
        synchronized (wnObj) {
            wnObj.notifyAll();
            System.out.println("Did NotifyAll");
//            Thread.sleep(10000L);
            System.out.println("NotifyAll completed");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        final MyWaitNotify myWaitNotify = new MyWaitNotify();
        final Thread waitThread = new Thread(new Runnable() {
            public void run() {
                try {
                    myWaitNotify.doWait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        waitThread.start();

        Thread waitThread2 = new Thread(new Runnable() {
            public void run() {
                try {
                    myWaitNotify.doWait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        waitThread2.start();

        Thread notifyThread = new Thread(new Runnable() {
            public void run() {
                try {
//                    myWaitNotify.doNotify();

//                    myWaitNotify.doNotify();

                    waitThread.interrupt();
                    TimeUnit.SECONDS.sleep(10);
                    myWaitNotify.doNotifyAll();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        notifyThread.start();
    }
}
