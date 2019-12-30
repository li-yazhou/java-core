package coding.ali;

/**
 * 银行用户账户有一个金额属性，现在要实现存钱，取钱，转账三个功能
 *
 * @author liyazhou1
 * @date 2019/11/25
 */
public class _005_BankAccount {

    private String ID;

    private Double amount;


    public void save(double money) {
        if (money <= 0) {
            throw new IllegalArgumentException("money must be greater than 0");
        }
        amount += money;
    }

    public double take(double money) {
        if (money <= 0) {
            throw new IllegalArgumentException("money must be greater than 0");
        }
        if (amount < money) {
            throw new IllegalArgumentException("money must be greater than amount");
        }
        amount -= money;
        return money;
    }


    public void transfer(_005_BankAccount card, double money) {
        if (money <= 0) {
            throw new IllegalArgumentException("money must be greater than 0");
        }
        if (amount < money) {
            throw new IllegalArgumentException("money must be greater than amount");
        }
        amount -= money;
        card.amount += money;
    }

}

