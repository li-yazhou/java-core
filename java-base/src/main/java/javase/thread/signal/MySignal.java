package javase.thread.signal;

/**
 * Created by ji  .
 * 通过 共享对象 来实现信号量(signal)
 */
public class MySignal {
    private boolean hasDataToProcess = false;

    /**
     * 该方法要加同步,比如:一个线程正在同步块中修改这个boolean变量,
     * 如果不加同步块另一个线程就可以在这个期间读取值,此时读取的值是不准确的.
     * 加了同步块,只有修改线程完成后,读取线程才能读取,读取的值就是正确的了.
     * (非静态同步方法锁的是当前对象实例,静态方法锁的是当前类才Class对象)
     * @return
     */
    public synchronized boolean hasDataToProcess() {
        return this.hasDataToProcess;
    }

    public synchronized void setHasDataToProcess() {
        this.hasDataToProcess = true;
    }
}
