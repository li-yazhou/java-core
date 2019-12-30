package coding.ali;

/**
 * 实现两个线程，使之交替打印1-100,如：两个线程分别为：Printer1和Printer2,
 * 最后输出结果为： Printer1 — 1 Printer2 一 2 Printer1 一 3 Printer2 一 4
 *
 * @author liyazhou1
 * @date 2019/11/25
 */
public class _001_TwoPrinter {

    private static final Object lock = new Object();
    private static volatile boolean flag = true;
    private static volatile int counter = 1;

    public static void main(String[] args) {


        new Thread(new Runnable() {

            public void run() {
                while (true) {
                    synchronized (lock) {
                        if (counter > 100) {
                            return;
                        }

                        if (flag) {
                            System.out.print(Thread.currentThread().getName() + " ");
                            System.out.println(counter++);
                            flag = false;
                            lock.notify();
                        } else {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }

        }, "Printer-1").start();


        new Thread(new Runnable() {

            public void run() {
                while (true) {
                    synchronized (lock) {
                        if (counter > 100) {
                            return;
                        }

                        if (!flag) {
                            System.out.print(Thread.currentThread().getName() + " ");
                            System.out.println(counter++);
                            flag = true;
                            lock.notify();
                        } else {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }

        }, "Printer-2").start();
    }
}
