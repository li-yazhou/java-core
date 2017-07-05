package spring.springaction4.ch01;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-05 13:27
 */
public class HuaweiPhone {
    private Card card;

    public void call(Card _card){
        card = _card;
        communicate();
    }

    public void communicate(){
        System.out.println("通话。。。");
    }
}
