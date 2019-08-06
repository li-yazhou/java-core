package javase.thread_concurrent.base;

import java.util.Random;
import java.util.concurrent.*;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-15 16:00
 */
public class CallableAndFuture {

    public static void main(String ... args){
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future<String> future = threadPool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return "return result.";
            }
        });

        System.out.println("waiting for result of callable....");
        try {
            System.out.println("this result is, " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        threadPool.shutdown();


        System.out.println("\n\n");
        System.out.println("--------------------------");
        System.out.println("\n\n");
        ExecutorService threadPool03 = Executors.newFixedThreadPool(10);
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(threadPool03);
        for (int i = 0; i < 10; i ++){
            final int seq = i;
            completionService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(1000 + new Random().nextInt(5000));
                    return seq;
                }
            });
        }

        for (int i = 0; i < 10; i ++){
            try {
                Future<Integer> future1 = completionService.take();
                int result = future1.get();
                System.out.println("result = " + result);
            } catch (InterruptedException |ExecutionException e) {
                e.printStackTrace();
            }
        }

        threadPool03.shutdown();

    }
}
