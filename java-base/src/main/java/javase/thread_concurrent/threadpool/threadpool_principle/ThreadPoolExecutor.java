package javase.thread_concurrent.threadpool.threadpool_principle;


import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liyazhou1
 * @date 2019/12/20
 */
public class ThreadPoolExecutor {


    private volatile Set<Worker> workerSet;

    private volatile BlockingQueue<Task> queue;

    private volatile int poolSize;

    private volatile int state = STATE_RUNNING;

    private final static int STATE_RUNNING = 0;

    private final static int STATE_SHUTDOWN = 1;

    private final static int STATE_SHUTDOWN_NOW = 2;

    private volatile boolean allowThreadTimeout = false;

    private volatile long keepAliveTime;

    private ReentrantLock lock = new ReentrantLock();


    public ThreadPoolExecutor(int poolSize, BlockingQueue<Task> queue) {
        this.poolSize = poolSize;
        this.workerSet = new HashSet<>();
        this.queue = queue;
    }


    public ThreadPoolExecutor(int poolSize, long timeout, TimeUnit timeUnit, BlockingQueue<Task> queue) {
        this.poolSize = poolSize;
        this.workerSet = new HashSet<>();
        this.queue = queue;
        this.keepAliveTime = timeUnit.toMillis(timeout);
        this.allowThreadTimeout = true;
    }


    /**
     *  提交任务
     *      若工作线程数目没达到阈值则创建工作线程并执行任务
     *      若工作线程数目达到阈值则将任务添加到任务队列中，等待其他的工作线程获取
     */
    public void execute(Task task) {

        if (state != STATE_RUNNING) {
            throw new RejectedExecutionException("ThreadPool stopped, cannot commit new task");
        }

        if (workerSet.size() < poolSize) {
            createWorker(task);
        } else {
            this.queue.add(task);
        }
    }


    /**
     * 创建工作线程并执行任务
     */
    private void createWorker(Task task) {
        lock.lock();
        try {
            if (workerSet.size() >= poolSize) {
                if (task != null) {
                    this.queue.add(task);
                }
                return;
            }
            System.out.println("新建工作");
            Worker worker = new Worker(task);
            workerSet.add(worker);
            worker.start();
        } finally {
            lock.unlock();
        }
    }


    /**
     * 标记线程池已经关闭，若有新的任务也不再创建工作线程
     */
    public void shutdown() {
        this.state = STATE_SHUTDOWN;
    }


    /**
     * 标记线程池已经关闭，若有新的任务也不再创建工作线程，并中断所有的工作线程
     */
    public void shutdownNow() {
        this.state = STATE_SHUTDOWN_NOW;
        for (Worker w : workerSet) {
            try {
                w.interrupt();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 从队列中获取待执行的任务
     */
    private Task getTask() throws InterruptedException {

        if (state == STATE_SHUTDOWN_NOW) {
            return null;
        }

        if (state == STATE_RUNNING && queue.isEmpty()) {
            return null;
        }

        if (allowThreadTimeout) {
            // 可中断式地获取任务
            return queue.poll(keepAliveTime, TimeUnit.MILLISECONDS);
        }

        return queue.take();

    }


    /**
     * 处理线程闲置超时或者线程中断
     *
     * @param worker 退出的线程
     * @param timeout 是否超时
     */
    private void processWorkerExit(Worker worker, boolean timeout) {

        // 线程闲置超时不作处理
        if (timeout) {
            return;
        }

        lock.lock();
        try {
            workerSet.remove(worker);
        } finally {
            lock.unlock();
        }

        if (state == STATE_RUNNING) {
            createWorker(null);
        }
    }


    /**
     * 工作线程
     */
    private class Worker implements Runnable {

        private Task task;

        final Thread thread;

        public Worker(Task task) {

            this.task = task;
            // 将本类的run方法作为线程的方法体
            this.thread = new Thread(this);
        }

        @Override
        public void run() {

            boolean timeout = false;
            try {
                // 循环从队列中获取任务并执行
                while (true) {
                    if (task == null) {
                        task = getTask();
                    }

                    // 若getTask()返回null，表示该线程闲置时间超过keepAliveTime，将停止该线程
                    if (task == null) {
                        timeout = true;
                        break;
                    } else {
                        task.run();
                        task = null;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 线程闲置超时或者中断处理
                processWorkerExit(this, timeout);
            }
        }


        /**
         * 启动工作线程
         */
        public void start(){
            // 将执行本类的run方法体
            thread.start();
        }

        /**
         * 中断工作线程
         */
        public void interrupt() {
            thread.interrupt();
        }
    }


    /**
     * 任务
     */
    public static abstract class Task implements Runnable {

        private int id;

        public Task(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

//        @Override
//        public void run() {
//            System.out.println("task-" + id + " start");
//            int second = new Random().nextInt(20);
//            System.out.println("task-" + id  + " sleep " + second + " s");
//            try {
//                Thread.sleep(second * 1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("task-" + id + " finished");
//        }
    }

}
