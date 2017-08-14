package javaenhance.part04_thread;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-14 14:31
 */
public class TraditionalThreadSynchronized {

    /**
     * 模拟打印机
     */
    class Outputer{
        public void output1(String content){
            for(int i = 0; i < content.length(); i ++){
                System.out.print(content.charAt(i));
            }
            System.out.println();
        }

        public synchronized void output(String content){
            for(int i = 0; i < content.length(); i ++){
                System.out.print(content.charAt(i));
            }
            System.out.println();
        }
    }

    private void init(){
        Outputer outputer = new Outputer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    outputer.output("xxxxxxx");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    outputer.output("yyyyyyyyy");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        /*
        xxxxxxx
        yyyyyyyyy
        yyyyyyxxxyyy
        xxxx
        xxxyyyyyyxxxyyyx

         */

    }



    public static void main(String[] args){
        new TraditionalThreadSynchronized().init();
    }
}
