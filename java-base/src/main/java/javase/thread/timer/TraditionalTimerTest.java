package javase.thread.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-13 19:58
 */
public class TraditionalTimerTest {

    private static int counter = 0;
    public static void main(String... args){

        // 内部类不能声明静态变量
        class MyTimerTask extends TimerTask{
            @Override
            public void run() {
                counter = (counter + 1) %2;
                System.out.println("MyTimerTask execute.");
                new Timer().schedule(new MyTimerTask(),  // 递归地调用
                        2000 * counter); // 每个0s或者2s执行
            }
        }
        new Timer().schedule(new MyTimerTask(), 1000);


        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("bombing!" );
            }
        }, 5000);  // 单次执行，延迟5s执行


        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("bombing!" );
            }
        }, 5000, 1000);  // 等间隔时间内连环执行


        while (true){
            System.out.println(new Date().getSeconds());
            try{
                Thread.sleep(1000);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
