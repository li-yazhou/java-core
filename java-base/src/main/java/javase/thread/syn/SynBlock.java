package javase.thread.syn;

import java.util.concurrent.TimeUnit;

/**
 * Created by ji.
 */
public class SynBlock {

    private static Object lock = new Object();

    public void method1() {
        synchronized (lock) {
            System.out.println("[method1] " + Thread.currentThread().getName() + " 进入同步块");
            try {
                System.out.println("method1");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("[method1] " + Thread.currentThread().getName() + " 离开同步块");
    }

    public void method2() {
        synchronized (lock) {
            System.out.println("[method2] " + Thread.currentThread().getName() + " 进入同步块");
            try {
                System.out.println("method2");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("[method2] " + Thread.currentThread().getName() + " 离开同步块");
    }


    public void method3() {
        synchronized (this) {
            System.out.println("[method3] " + Thread.currentThread().getName() + " 进入同步块");
            try {
                System.out.println("method3");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("[method3] " + Thread.currentThread().getName() + " 离开同步块");
    }

    public void method4() {
        synchronized (this.getClass()) {
            System.out.println("[method4] " + Thread.currentThread().getName() + " 进入同步块");
            try {
                System.out.println("method4");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("[method4] " + Thread.currentThread().getName() + " 离开同步块");
    }

    public static void main(String[] args) throws InterruptedException {

        /*********************两个线程执行一个对象的同一个方法**********************/

        final SynBlock synBlock = new SynBlock();
        final SynBlock b2 = new SynBlock();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                synBlock.method1();
            }
        }, "thread-1");

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                b2.method1();
            }
        }, "thread-2");
        t1.start();
        t2.start();
//

        /******************两个线程执行一个对象的不同方法**************************/

//        final SynBlock synBlock = new SynBlock();
//        Thread t1 = new Thread(new Runnable() {
//            public void run() {
//                synBlock.method1();
//            }
//        }, "thread-1");
//
//        Thread t2 = new Thread(new Runnable() {
//            public void run() {
//                synBlock.method2();
//            }
//        }, "thread-2");
//        t1.start();
//        t2.start();

        /*****************两个线程执行两个对象的方法***************************/

//        final SynBlock synBlock_1 = new SynBlock();
//        final SynBlock synBlock_2 = new SynBlock();
//
//        Thread t1 = new Thread(new Runnable() {
//            public void run() {
//                synBlock_1.method3();
//            }
//        }, "thread-1");
//
//        Thread t2 = new Thread(new Runnable() {
//            public void run() {
//                synBlock_2.method3();
//            }
//        }, "thread-2");
//        t1.start();
//        t2.start();

        /********************class************************/

//        final SynBlock synBlock_1 = new SynBlock();
//        final SynBlock synBlock_2 = new SynBlock();
//        Thread t1 = new Thread(new Runnable() {
//            public void run() {
//                synBlock_1.method4();
//            }
//        }, "thread-1");
//
//        Thread t2 = new Thread(new Runnable() {
//            public void run() {
//                synBlock_2.method4();
//            }
//        }, "thread-2");
//        t1.start();
//        t2.start();

    }

}
