package javase.thread.Volatile;

import java.util.concurrent.TimeUnit;

/**
 * Created by ji  .
 * <p>
 * cpu使用高速缓存，缓存中的数据何时失效：
 * 1. 超时未使用
 * 2. 通知
 */
public class VolatileTest {
    static boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            public void run() {
                int i = 1;
                while (!stop) {
                    i++;

                    /************ 不sleep 结果是什么?**************/
                    try {
                        TimeUnit.NANOSECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("i=" + i);
            }
        });
        t.start();
        Thread.sleep(2000);
        stop = true;
        System.out.println("main");
    }
}
