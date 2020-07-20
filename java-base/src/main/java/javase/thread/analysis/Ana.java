package javase.thread.analysis;

import javase.thread.HttpUtil;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ji.
 */
public class Ana {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    TimeUnit.HOURS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1");
        t1.start();


        /*****************************  死锁 *********************************/

        final Lock lock = new ReentrantLock();
        final Lock lock2 = new ReentrantLock();
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                lock.lock();
                try {
                    TimeUnit.SECONDS.sleep(10);
                    lock2.lock();
                    try {
                        System.out.println("[" + Thread.currentThread().getName() + "]获取到lock2");
                    } finally {
                        lock2.unlock();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "t2");
        t2.start();


        Thread t3 = new Thread(new Runnable() {
            public void run() {
                lock2.lock();
                try {
                    TimeUnit.SECONDS.sleep(5);
                    lock.lock();
                    try {
                        System.out.println("[" + Thread.currentThread().getName() + "]获取到lock1");
                    } finally {
                        lock.unlock();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock2.unlock();
                }
            }
        }, "t3");
        t3.start();

        /********************************* 死循环 ******************************/

        Thread t4 = new Thread(new Runnable() {
            public void run() {
                while (true) {

                }
            }
        }, "t4");
        t4.start();

        /********************************* 调用 ******************************/

        Thread t5 = new Thread(new Runnable() {
            public void run() {
                try {
                    HttpUtil.postBody("http://localhost:8080/arc/user/login", "");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "t5");
        t5.start();


        /********************************* 线程池 ******************************/

        ThreadPoolExecutor executor= new ThreadPoolExecutor(2, 5, 1, TimeUnit.HOURS, new ArrayBlockingQueue<Runnable>(5), new ThreadFactory() {
            public Thread newThread(Runnable r) {
                return new Thread(r, "my-pool-" + r.hashCode());
            }
        });
        for (int i = 0; i < 10; i++) {
            executor.execute(new Runnable() {
                public void run() {
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }



        /******************************** lock *******************************/

        System.out.println("aa");
        final Object synObj = new Object();
        Thread t6 = new Thread(new Runnable() {
            public void run() {
                synchronized (synObj) {
                    try {
                        TimeUnit.HOURS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t6");
        t6.start();

        Thread t7 = new Thread(new Runnable() {
            public void run() {
                synchronized (synObj) {
                    try {
                        TimeUnit.HOURS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t7");
        t7.start();

    }



}
