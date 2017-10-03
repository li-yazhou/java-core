package javaenhance.part04_thread.traditionalthread;


/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-13 19:24
 */
public class TraditionalThread {

    public static void main(String... args){


        Thread thread1 = new Thread(){
            int counter = 0;
            @Override
            public void run(){
                String threadName = Thread.currentThread().getName();
                while(true) {
                     System.out.println(threadName + "-" + counter);
                     counter++;
                     if (counter >= 1000) break;
                }
            }
        };
        thread1.start();



        Thread thread2 = new Thread(new Runnable() {  //宿主
            int counter = 0;
            @Override
            public void run() {
                while (true){
                    System.out.println(Thread.currentThread().getName());
                    if (counter ++ >= 10) break;
                }
            }
        });
        thread2.start();

    }


}
