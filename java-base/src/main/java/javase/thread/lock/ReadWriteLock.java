package javase.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by ji  .
 */
public class ReadWriteLock {

    ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void write() {
        try {
            ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
            ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
            readWriteLock.writeLock().lock();
            System.out.println("[write] " + Thread.currentThread().getName() + " 获得写锁");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
            System.out.println("[write] " + Thread.currentThread().getName() + " 释放写锁");
        }
    }

    public void read() {
        try {
            readWriteLock.readLock().lock();
            System.out.println("[read] " + Thread.currentThread().getName() + " 获得读锁");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
            System.out.println("[read] " + Thread.currentThread().getName() + " 释放读锁");
        }
    }

    public static void main(String[] args) {

        final ReadWriteLock readWriteLock = new ReadWriteLock();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                readWriteLock.write();
            }
        }, "thread-0");

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                readWriteLock.read();
            }
        }, "thread-1");

        Thread t3 = new Thread(new Runnable() {
            public void run() {
                readWriteLock.read();
            }
        }, "thread-2");

        Thread t4 = new Thread(new Runnable() {
            public void run() {
                readWriteLock.write();
            }
        }, "thread-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
