package javase.thread.Volatile;

/**
 * Created by ji  .
 */
public class ReorderExample {
    int a = 0;
    boolean flag = false;

    public void writer() {
        a = 1;
        flag = true;
    }

    public void reader() {
        while (!flag) {
        }
        int i = a;
        System.out.println(i);
    }

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {

            final ReorderExample reorderExample = new ReorderExample();

            Thread thread = new Thread(new Runnable() {
                public void run() {
                    reorderExample.writer();
                }
            });

            Thread thread1 = new Thread(new Runnable() {
                public void run() {

                    reorderExample.reader();
                }
            });

            thread.start();
            thread1.start();
        }
    }
}
