package javase.thread.daemon;

import java.util.concurrent.TimeUnit;

/**
 * Created by ji  .
 * 守护线程和用户线程唯一的区别在于虚拟机的离开：
 * 如果所有用户线程都退出了，那么虚拟机就会退出。
 *
 * </p>
 * 例如下面的例子，改一下两个线程sleep的时间，结果就会不同。
 */
public class Daemon {
    public static void main(String[] args) throws InterruptedException {
        Thread daemonThread = new Thread(new DaemonRunner(), "DaemonRunner");
        daemonThread.setDaemon(true);
        daemonThread.start();

        Thread thread = new Thread(new WorkRunner(), "WorkRunner");
        thread.start();
        System.out.println("test");

    }

    private static class DaemonRunner implements Runnable {
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("Daemon runner finally run");
            }
        }
    }

    private static class WorkRunner implements Runnable {
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("Work runner finally run");
            }
        }
    }
}
