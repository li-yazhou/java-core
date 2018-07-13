package org.alpha.javabase.javaenhance.part04_thread.demo01_draw_deposit_money;


/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-19 14:16
 */
public class Account {
    private String accountNo;
    private double balance;

    private boolean flag = false; // 表示是否有存款

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public synchronized void draw(double drawAmount){
        try {
            if (!flag){  // 没有存款，则等待
                this.wait();
            } else{     // 有存款，则进行取钱操作
                balance -= drawAmount;
                flag = false;  // 将账户标识为没有存款的状态
                System.out.println(Thread.currentThread().getName() + " 取钱 " + drawAmount);
                System.out.println(accountNo + " 余额为 " + balance);
                System.out.println("-------------------------\n");

                this.notify();  // 唤醒同一个同步监视器对象上其他的等待着的线程
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public synchronized void deposit(double depositAmount){
        try{
            if (flag){   // 有存款，不能再次存款，则等待
                this.wait();
            } else {
                balance += depositAmount;
                flag = true;
                System.out.println(Thread.currentThread().getName() + " 存钱 " + depositAmount);
                System.out.println(accountNo + " 余额为 " + balance);
                System.out.println();

                this.notify();  // 唤醒同一个同步监视器上对象上其他的等待着的线程
            }

        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
