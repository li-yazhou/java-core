package javase.thread_concurrent.producer_consumer_model.pc_with_lock;

import lombok.extern.slf4j.Slf4j;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liyazhou1
 * @desc TODO
 * @date 2019/4/21
 */
@Slf4j
public class PCWithLock {

    private int SIZE = 10;
    private PriorityQueue<String> sharedQueue = new PriorityQueue<>(SIZE);

    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();


    public PCWithLock() {

    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (sharedQueue.isEmpty()) {
                        try {
                            notEmpty.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    String product = sharedQueue.poll();
                    log.info("消费: {}，size = {}", product, sharedQueue.size());
//                    try {
//                        Thread.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

                    notFull.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }


    class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while(sharedQueue.size() == SIZE) {
                        try {
                            notFull.await();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                    String product = "商品" + System.currentTimeMillis();
                    boolean success = sharedQueue.offer(product);
                    log.info("生产: {}，size = {}", product, sharedQueue.size());
//                    try {
//                        Thread.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    notEmpty.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }


    private void validate() {
        Thread producerThread = new Thread(new Producer(), "producer");
        Thread consumerThread = new Thread(new Consumer(), "consumer");
        producerThread.start();
        consumerThread.start();
    }


    public static void main(String[] args) {
        new PCWithLock().validate();
    }
}


