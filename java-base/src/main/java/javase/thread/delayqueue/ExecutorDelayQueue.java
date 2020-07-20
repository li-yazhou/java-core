package javase.thread.delayqueue;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorDelayQueue {

    private static final ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 20, 10, TimeUnit.SECONDS, new DelayQueue());

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i < 30; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.SECOND, i*2);
            poolExecutor.execute(new RunnableTask("a" + i, calendar.getTime()));
        }

        while (true) {
            System.out.println(poolExecutor.getActiveCount());
            TimeUnit.SECONDS.sleep(1);
        }
    }

    static class RunnableTask extends Task implements Runnable {
        public RunnableTask(String name, Date execTime) {
            super(name, execTime);
        }

        public void run() {
            System.out.println(getName());
            try {
                Thread.sleep(10*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    static class Task implements Delayed {
        String name;
        Date execTime;


        public Task(String name, Date execTime) {
            this.name = name;
            this.execTime = execTime;
        }

        public long getDelay(TimeUnit unit) {
            Date now = new Date();
            long diff = execTime.getTime() - now.getTime();
            return unit.convert(diff, TimeUnit.MILLISECONDS);
        }

        public int compareTo(Delayed o) {
            long result = this.getDelay(TimeUnit.NANOSECONDS)
                    - o.getDelay(TimeUnit.NANOSECONDS);
            if (result < 0) {
                return -1;
            } else if (result > 0) {
                return 1;
            } else {
                return 0;
            }
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getExecTime() {
            return execTime;
        }

        public void setExecTime(Date execTime) {
            this.execTime = execTime;
        }
    }
}
