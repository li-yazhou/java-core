package proxy_imooc.proxy.demo01;

import java.util.Random;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-22 11:08
 */
public class Car implements Movable {
    @Override
    public void move() {
        System.out.println("汽车开始行驶....");
        try {
            System.out.println("汽车正在行驶...");
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("汽车结束行驶....");
    }


    public void move0() {
        long startTime = System.currentTimeMillis();
        System.out.println("汽车开始行驶....");
        try {
            System.out.println("汽车正在行驶...");
            Thread.sleep(new Random().nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("汽车结束行驶....");
        System.out.println("汽车行驶时间为 " + (endTime - startTime) + " ms.");
    }
}
