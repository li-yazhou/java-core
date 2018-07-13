package org.alpha.javabase.javaenhance.part04_thread.java5thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-15 15:05
 */
public class ThreadPoolTest {

    public static void main(String... args){
        // ExecutorService threadPool = Executors.newFixedThreadPool(3);  // 固定大小的线程池
        // ExecutorService threadPool = Executors.newCachedThreadPool();  // 缓存线程池
        ExecutorService threadPool = Executors.newSingleThreadExecutor();  // 单一线程池，可以保证这个线程死掉以后，重启一个线程
        for (int i = 1; i <= 10; i ++){
            final int task = i;
            threadPool.execute(new Runnable(){
                @Override
                public void run() {
                    for (int j = 1; j <= 5; j ++){
                        System.out.println(Thread.currentThread().getName() + " is looping of " + j + "for task of " + task);
                    }
                }
            });
        }
        System.out.println("all of 10 tasks have committed.");
        threadPool.shutdown();  // 线程池中的所有任务都被完成时，关闭线程
        // threadPool.shutdownNow();

        ScheduledExecutorService scheduledThreadPool02 =  Executors.newScheduledThreadPool(3);
        scheduledThreadPool02.schedule(
                new Runnable(){
                    public void run(){
                        System.out.println("time out, execute it.");
                    }
                },
                10,
                TimeUnit.SECONDS
        );

        scheduledThreadPool02.scheduleAtFixedRate(new Runnable() {  // 固定频率的的调度
            @Override
            public void run() {
                System.out.println("execute....");
            }},
            6,
            2,
            TimeUnit.SECONDS
        );
    }
}
