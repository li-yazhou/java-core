package javaenhance.part04_thread;

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

}
