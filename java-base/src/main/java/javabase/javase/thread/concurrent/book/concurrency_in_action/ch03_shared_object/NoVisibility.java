package javabase.javase.thread.concurrent.book.concurrency_in_action.ch03_shared_object;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-06-28 15:48
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private final Integer num;  // 在定义或者构造方法中初始化final变量
    public NoVisibility(){
        num = 10;
    }

    private static class ReaderThread extends Thread{
        public void run(){
            while (!ready){
                Thread.yield();
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args){
        new ReaderThread().start();
        number = 42;
        ready = true;
    }


}
