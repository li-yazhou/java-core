package javase.thread.signal;

/**
 * Created by ji.
 */
public class BussyWait {

    static MySignal mySignal = new MySignal();

    public static void main(String[] args) {
        final Thread threadA = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (i < 3) {
                    System.out.println(i);
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                }
                mySignal.setHasDataToProcess();
            }
        });

        Thread threadB = new Thread(new Runnable() {
            public void run() {
                while (!mySignal.hasDataToProcess()) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("begin to process data");

            }
        });

        threadA.start();
        threadB.start();
    }
}
