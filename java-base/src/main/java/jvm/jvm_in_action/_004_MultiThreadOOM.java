package jvm.jvm_in_action;

/**
 * @author liyazhou1
 * @date 2020/4/13
 */
public class _004_MultiThreadOOM {

    public static void main(String[] args) {
        for (int i = 0; true; i ++) {
            new Thread(new SleepThread(), "T-" + i).start();
            System.out.println("T-" + i + " created");
        }
    }


    private static class SleepThread implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(1000 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
