package javase.thread.traditionalthread;

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
        public void output(String content){
            for(int i = 0; i < content.length(); i ++){
                System.out.print(content.charAt(i));
            }
            System.out.println();
        }

        public synchronized void outputSafely(String content){
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
                    // outputer.output("llllllll");
                    outputer.outputSafely("llllllll");
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
                    // outputer.output("oooooooo");
                    outputer.outputSafely("oooooooo");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        /*
        llllllll
        oooooooo
        ooollllllll
        ooooo
        llllllooooooll
        oo
        lllllloooooooo
        ll
        ooolllooooo
        lllll
        llllllll
        oooooooo

         */

    }



    public static void main(String[] args){
        new TraditionalThreadSynchronized().init();
    }
}
