package javase.thread;

/**
 */
public class B {
    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            Thread thread=new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        try {
                            if(1==2){
                                Thread.sleep(10);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            thread.start();
        }
    }

}
