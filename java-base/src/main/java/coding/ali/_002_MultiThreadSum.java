package coding.ali;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 启5个线程，并发对1-10000之间的数字进行求和，并打印结果。
 *
 * @author liyazhou1
 * @date 2019/11/25
 */
public class _002_MultiThreadSum {


    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Future<Integer> s1 = executorService.submit(new SumThread(1, 2000, "sum-task-1"));
        Future<Integer> s2 = executorService.submit(new SumThread(2001, 4000, "sum-task-2"));
        Future<Integer> s3 = executorService.submit(new SumThread(4001, 6000, "sum-task-3"));
        Future<Integer> s4 = executorService.submit(new SumThread(6001, 8000, "sum-task-4"));
        Future<Integer> s5= executorService.submit(new SumThread(8001, 10000, "sum-task-5"));

        int sum = s1.get() + s2.get() + s3.get() + s4.get() + s5.get();
        System.out.println("sum = " + sum);

        executorService.shutdown();
    }


}

class SumThread implements Callable<Integer>{

    private String  name;
    private int     start;
    private int     end;

    public SumThread(int start, int end, String name) {
        this.name = name;
        this.start = start;
        this.end = end;
    }


    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int element = start; element <= end; element ++) {
            sum += element;
        }
        System.out.println(name + " :: " + sum);
        return sum;
    }
}
