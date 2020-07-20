package javase.thread.futuretask;

import java.util.concurrent.*;

/**
 * Created by ji.
 */
public class FutureTest {
    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(1);
        try {
            FutureTask<Integer> futureTask= new FutureTask<Integer>(new Callable<Integer>() {
                public Integer call() throws Exception {
                    TimeUnit.SECONDS.sleep(5);
                    return 1;
                }
            });
            pool.submit(futureTask);
            System.out.println("abc");
            TimeUnit.SECONDS.sleep(10);
            int result = futureTask.get(20L, TimeUnit.SECONDS);
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }
}
