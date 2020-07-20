package javase.thread.exchange;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * Created by ji  .
 * 一对线程之间交换数据，一个线程调用exchange方法后，会被阻塞，等待另一个线程exchange后才会唤醒
 */
public class ExchangeTest {
    static Exchanger<String> exchanger = new Exchanger<String>();

    public static void main(String[] args) {

        new Thread(new Runnable() {
            public void run() {
                String A = "thread A";
                try {
                    String result = exchanger.exchange(A);
                    System.out.println("[thread A] " + result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                String B = "thread B";
                try {
                    TimeUnit.SECONDS.sleep(5);
                    String result = exchanger.exchange(B);
                    System.out.println("[thread B] " + result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
