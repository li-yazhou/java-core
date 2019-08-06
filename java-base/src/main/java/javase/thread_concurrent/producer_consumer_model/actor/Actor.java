package javase.thread_concurrent.producer_consumer_model.actor;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-15 17:15
 */
public class Actor extends Thread {
    @Override
    public void run(){
        int counter = 0;
        boolean keepRunning = true;
        System.out.println(this.getName() + " 开始演出了");
        while (keepRunning){
            System.out.println(this.getName() + " 演出次数 " + (++counter));
            if (counter == 100) keepRunning = false;
            try{
                Thread.sleep(100);
            } catch (InterruptedException exception){
                exception.printStackTrace();
            }

        }
        System.out.println(this.getName() + " 结束演出");
    }

    public static void main(String[] args){
        Thread thread = new Actor();
        thread.setName("actor xiaobai");
        thread.start();

        Thread actress = new Thread(new Actress(), "actress xiaohei");
        actress.start();
    }
}

class Actress implements Runnable{
    @Override
    public void run(){
        int counter = 0;
        boolean keepRunning = true;
        System.out.println(Thread.currentThread().getName() + " 开始表演");
        while (keepRunning){
            System.out.println(Thread.currentThread().getName() + " 表演 " + (++ counter));
            try{
                Thread.sleep(200);
            } catch (InterruptedException ex){
                ex.printStackTrace();
            }
            if (counter == 100) keepRunning = false;
        }
        System.out.println(Thread.currentThread().getName() + " 结束表演");
     }
}
