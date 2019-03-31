package javase.thread.jdk5thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-15 16:40
 */
public class LockTest {
    class Outputer{
        Lock lock = new ReentrantLock();
        public void output(String content){
            lock.lock();
            try{
                for (int i = 0; i < content.length(); i ++)
                    System.out.print(content.charAt(i));
                System.out.println();
            } finally {
                lock.unlock();
            }
        }
    }

    class MyRunnable implements Runnable{
        private String content;
        private Outputer outputer;

        public MyRunnable(String _content, Outputer _outputer){
            content = _content;
            outputer = _outputer;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i ++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                outputer.output(content);
            }
        }
    }


    private void init(){
        Outputer outputer = new Outputer();
        new Thread(new MyRunnable("llllllllll", outputer)).start();
        new Thread(new MyRunnable("oooooooooo", outputer)).start();
    }

    public static void main(String[] args){
        new LockTest().init();
    }
}
