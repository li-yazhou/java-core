package javase.thread.yield;

public class YieldTest {

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("thread-A-" + i);
                    Thread.yield();
                }

            }
        }, "threadA");
        threadA.setPriority(Thread.MAX_PRIORITY);

        Thread threadB = new Thread(new Runnable() {
            public void run() {
                System.out.println("thread-B");
            }
        }, "thread-B");

        threadB.setPriority(Thread.MIN_PRIORITY);

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();
    }
}
