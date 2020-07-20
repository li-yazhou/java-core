package javase.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ji  .
 */
public class ReenTranLockTest {

    ReentrantLock lock = new ReentrantLock();

    /**
     * lock
     */
    public void method1() {
        lock.lock();
        try {
            System.out.println("[method1] " + Thread.currentThread().getName() + " 获得锁");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("[method1] " + Thread.currentThread().getName() + " 释放锁");
        }
    }

    /**
     * tryLock
     */
    public void method2() {
        if (lock.tryLock()) {
//        if (lock.tryLock(6, TimeUnit.SECONDS)) {
            try {
                System.out.println("[method2] " + Thread.currentThread().getName() + " 获得锁");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("[method2] " + Thread.currentThread().getName() + " 释放锁");
            }
        } else {
            System.out.println("[method2] " + Thread.currentThread().getName() + " 获取锁失败");
        }
    }

    /**
     * 测试重入
     */
    public void method3() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " 获得锁");
    }


    public static void main(String[] args) {

        /*******************************/
//        final ReenTranLockTest reenTranLockTest = new ReenTranLockTest();
//        Thread t1 = new Thread(new Runnable() {
//            public void run() {
//                reenTranLockTest.method1();
//            }
//        });
//        Thread t2 = new Thread(new Runnable() {
//            public void run() {
//                reenTranLockTest.method1();
//            }
//        });
//        t1.start();
//        t2.start();


        /****************************/
//        final ReenTranLockTest reenTranLockTest = new ReenTranLockTest();
//        Thread t1 = new Thread(new Runnable() {
//            public void run() {
//                reenTranLockTest.method2();
//            }
//        });
//        Thread t2 = new Thread(new Runnable() {
//            public void run() {
//                reenTranLockTest.method2();
//            }
//        });
//        t1.start();
//        t2.start();

        /****************************/
        final ReenTranLockTest reenTranLockTest = new ReenTranLockTest();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                reenTranLockTest.method3();
                reenTranLockTest.method3();//如果这地方都调用method1，会是什么结果？
            }
        });
        t1.start();
    }


}
