package javase.thread_concurrent.threadpool.threadpool_principle;

import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @author liyazhou1
 * @date 2019/12/20
 */
public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 2, TimeUnit.SECONDS, new LinkedBlockingDeque<>());

        for (int i = 0; i < 100; i ++) {
            pool.execute(new ThreadPoolExecutor.Task(i) {
                //  @Override
                public void run() {
                    String taskId = "task-" + getId();

                    System.out.println(taskId + " start");

                    int second = new Random().nextInt(20);
                    System.out.println(taskId  + " sleep " + second + " s");
                    try {
                        Thread.sleep(second * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(taskId+ " finished");
                }
            });
        }
    }
}
