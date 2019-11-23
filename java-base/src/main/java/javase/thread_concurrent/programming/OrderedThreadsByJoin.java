package javase.thread_concurrent.programming;

/**
 * @author liyazhou1
 * @desc TODO
 * @date 2019/8/28
 */
public class OrderedThreadsByJoin {

    public static void main(String[] args) {
        Thread firstThread = new Thread(new FirstExecutor());
        Thread secondThread = new Thread(new SecondExecutor(firstThread));
        Thread thirdThread = new Thread(new ThirdExecutor(secondThread));

        firstThread.start();
        secondThread.start();
        thirdThread.start();
    }
}


class FirstExecutor implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i ++) {
            System.out.println("111...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SecondExecutor implements Runnable {

    private Thread beforeThread;

    SecondExecutor (Thread beforeThread) {
        this.beforeThread = beforeThread;
    }

    @Override
    public void run() {
        try {
            beforeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i ++) {
            System.out.println("222...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            throw new RuntimeException("中断当前线程");
        }
    }
}

class ThirdExecutor implements Runnable {

    private Thread beforeThread;

    ThirdExecutor(Thread beforeThread) {
        this.beforeThread = beforeThread;
    }

    @Override
    public void run() {
        try {
            beforeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10; i ++) {
            System.out.println("333...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}