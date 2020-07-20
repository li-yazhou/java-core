package javase.thread.forkjoin;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by ji.
 */
public class ForkJoinTest extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 2;

    private int start;
    private int end;

    public ForkJoinTest(int start, int end) {
        this.start = start;
        this.end = end;
    }

    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end - start) <= THRESHOLD;
        System.out.println(canCompute+";"+start+";"+end);
        if (canCompute) {
            System.out.println("["+ Thread.currentThread().getName()+"]");
            for (int i = start; i <=end ; i++) {
                sum += i;
            }
        } else {
            int middle = (end +start) / 2;
            ForkJoinTest left = new ForkJoinTest(start, middle);
            ForkJoinTest right = new ForkJoinTest(middle + 1, end);
            left.fork();
            right.fork();
            System.out.println("[=="+ Thread.currentThread().getName()+"]");
            int leftResult = left.join();
            int rightResult = right.join();
            sum = leftResult + rightResult;
        }
        return sum;
    }


    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        ForkJoinTest job = new ForkJoinTest(1, 10);
        ForkJoinTask<Integer> future = forkJoinPool.submit(job);
        try {
            Integer result = future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
