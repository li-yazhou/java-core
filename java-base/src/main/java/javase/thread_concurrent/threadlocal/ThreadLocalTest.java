package javase.thread_concurrent.threadlocal;

import java.util.Random;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-14 21:03
 */
public class ThreadLocalTest {
    private static ThreadLocal<Integer> x = new ThreadLocal<Integer>();

    public static void main(String... args){
        for (int i = 0; i < 2; i ++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + " put data, " + data);
                    x.set(data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }

    static class A{
        void get(){
            int data = x.get();  // ThreadLocal的成员方法get()
            System.out.println("A from " + Thread.currentThread().getName() + " get data : " + data);
        }
    }

    static class B{
        void get(){
            int data = x.get();  // ThreadLocal的成员方法get()
            System.out.println("B from " + Thread.currentThread().getName() + " get data : " + data);
        }
    }

    /*
        Thread-0 put data, -1698175580
        Thread-1 put data, 881572399
        A from Thread-0 get data : -1698175580
        A from Thread-1 get data : 881572399
        B from Thread-0 get data : -1698175580
        B from Thread-1 get data : 881572399
     */

}
