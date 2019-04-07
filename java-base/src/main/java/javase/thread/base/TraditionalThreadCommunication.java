package javase.thread.base;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-14 14:31
 */

class Business{
    boolean shouldSub = true;
    public synchronized void submethod(int i) {
//        if (!shouldSub){  // 可能存在自唤醒的情况，所以使用while更好，可以当线程被唤醒时，可以检查一遍
//            this.wait();
//        }
        while (!shouldSub){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int k = 0; k < 2; k ++)
            System.out.println("submethod " + k + ", loop of " + i);
        shouldSub = false;
        this.notify();
    }

    public synchronized void mainmethod(int i) {
        if (shouldSub){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int k = 0; k < 3; k ++)
            System.out.println("mainmethod " + k + ", loop of " + i);
        shouldSub = true;
        this.notify();

    }
}


public class TraditionalThreadCommunication {
    public static void main(String ... args){
        Business business = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i ++){
                    business.submethod(i);
                }
            }
        }).start();

        for (int i = 0; i < 5; i ++){
            business.mainmethod(i);
        }
    }
}
