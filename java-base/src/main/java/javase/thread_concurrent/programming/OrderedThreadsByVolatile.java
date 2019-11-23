package javase.thread_concurrent.programming;

/**
 * @author liyazhou1
 * @desc TODO
 * @date 2019/8/28
 */

public class OrderedThreadsByVolatile {

    private volatile int ordinal = 0;
    private volatile boolean executale = true;


    public synchronized void firstTask() {
        while (this.ordinal != 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("ordinal = " + ordinal);
        for (int i = 0; i < 10; i ++) {
            System.out.println(i + ", 1111....");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.ordinal = 1;
        System.out.println("ordinal = " + ordinal);
        this.notifyAll();
    }


    public synchronized void secondTask() {
        while (this.ordinal != 1) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("ordinal = " + ordinal);
        for (int i = 0; i < 10; i ++) {
            System.out.println(i + ", 2222....");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.ordinal = 2;
        System.out.println("ordinal = " + ordinal);
        this.notifyAll();
        throw new RuntimeException("抛出异常。。。");
    }


    public synchronized void thirdTask() {
        while (this.ordinal != 2) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("ordinal = " + ordinal);
        for (int i = 0; i < 10; i ++) {
            System.out.println(i + ", 3333....");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.ordinal = 3;
        System.out.println("ordinal = " + ordinal);
        this.notifyAll();
    }
}


class FirstTask implements Runnable {

    private OrderedThreadsByVolatile orderedThreadsByVolatile;

    FirstTask (OrderedThreadsByVolatile orderedThreadsByVolatile) {
        this.orderedThreadsByVolatile = orderedThreadsByVolatile;
    }

    @Override
    public void run() {
        orderedThreadsByVolatile.firstTask();
    }
}


class SecondTask implements Runnable {

    private OrderedThreadsByVolatile orderedThreadsByVolatile;

    SecondTask(OrderedThreadsByVolatile orderedThreadsByVolatile) {
        this.orderedThreadsByVolatile = orderedThreadsByVolatile;
    }

    @Override
    public void run() {
        orderedThreadsByVolatile.secondTask();
    }
}


class ThirdTask implements Runnable {

    private OrderedThreadsByVolatile orderedThreadsByVolatile;

    ThirdTask (OrderedThreadsByVolatile orderedThreadsByVolatile) {
        this.orderedThreadsByVolatile = orderedThreadsByVolatile;
    }

    @Override
    public void run() {
        orderedThreadsByVolatile.thirdTask();
    }
}


class Test {
    public static void main(String[] args) {
        OrderedThreadsByVolatile orderedThreadsByVolatile = new OrderedThreadsByVolatile();
        Thread firstTask = new Thread(new FirstTask(orderedThreadsByVolatile));
        Thread secondTask = new Thread(new SecondTask(orderedThreadsByVolatile));
        Thread thirdTask = new Thread(new ThirdTask(orderedThreadsByVolatile));

        firstTask.start();
        secondTask.start();
        thirdTask.start();
    }
}


