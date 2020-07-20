package javase.thread.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by ji.
 */
public class ForkJoinTest2 extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 2;


    private int start;
    private int end;

    public ForkJoinTest2(int start ,int end){
        this.start = start;
        this.end = end;
    }

    protected Integer compute() {
        int sum=0;
        boolean canCompute = (end - start) >= 2;
        if(canCompute){
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        }else {
            int middle = (end - start) / 2;
            ForkJoinTest2 left = new ForkJoinTest2(start, middle);
            ForkJoinTest2 right = new ForkJoinTest2(middle, end);

            left.fork();
            right.fork();

            int leftResult = left.join();
            int rightResult = right.join();
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(5);
        ForkJoinTest2 job = new ForkJoinTest2(1, 10);
        ForkJoinTask<Integer> future = forkJoinPool.submit(job);
        try {
            int result = future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
