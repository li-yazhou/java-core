package javase.thread.producer_consumer_model.drawmoney;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-19 14:34
 */

class DrawThread extends Thread{
    private Account acct;
    private double drawAmount;

    public DrawThread(String name, Account acct, double drawAmount){
        super(name);
        this.acct = acct;
        this.drawAmount = drawAmount;
    }

    /**
     * 线程体，执行取款 100 次
     */
    @Override
    public void run(){
        for (int i = 0; i < 20; i ++){
            acct.draw(drawAmount);
        }
    }
}


class DepositThread extends Thread{
    private Account acct;
    private double depositAmount;

    public DepositThread(String name, Account acct, double depositAmount){
        super(name);
        this.acct = acct;
        this.depositAmount = depositAmount;
    }

    @Override
    public void run(){
        for (int j = 0; j < 20; j ++){
            acct.deposit(depositAmount);
        }
    }
}


public class Demo {
    public static void main(String... args){
        Account acct = new Account("zhouzhou", 0);
        new DrawThread("取钱者1", acct, 600).start();
        new DepositThread("存钱者甲", acct, 600).start();

//        new DrawThread("取钱者2", acct, 600).start();
//        new DrawThread("取钱者3", acct, 600).start();
//        new DepositThread("存钱者乙", acct, 600).start();
//        new DepositThread("存钱者丙", acct, 600).start();
    }
}
