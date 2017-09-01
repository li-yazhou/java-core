package dp_zen.chap09_factorymethod2;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-06-28 20:12
 */
public class Iphone implements Phone {
    @Override
    public void introduce() {
        System.out.println("i am an iphone.");
    }
}
