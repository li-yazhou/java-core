package javase.thread.conditioin;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ji.
 * <p></p>
 * 调用await后会释放锁，进入沉睡状态，后面的逻辑不会执行，等待唤醒[signal]
 */
public class ConditionUseCase {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void conditionWait() throws InterruptedException {
        lock.lock();
        try {
            System.out.println("[conditionWait] before await");
            //调用await后会释放锁，进入沉睡状态，后面的逻辑不会执行，等待唤醒[signal]
            condition.await();
            System.out.println("[conditionWait] after signal");
        } finally {
            System.out.println("unlock");
            lock.unlock();
        }
    }

    public void conditionWait2() throws InterruptedException {
        lock.lock();
        try {
            System.out.println("[conditionWait2] before wait");
            condition.await();
            System.out.println("[conditionWait2] after signal");
        } finally {
            System.out.printf("unlock");
            lock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        final ConditionUseCase useCase = new ConditionUseCase();

        Thread waitThread = new Thread(new Runnable() {
            public void run() {
                try {
                    useCase.conditionWait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "waitThread");


        Thread waitThread2 = new Thread(new Runnable() {
            public void run() {
                try {
                    useCase.conditionWait2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "waitThread2");


        waitThread.start();
        waitThread2.start();

        Thread.sleep(1000);
        useCase.lock.lock();
        try {
//            useCase.condition.signal();
            useCase.condition.signalAll();
        } finally {
            useCase.lock.unlock();
        }
    }
}
