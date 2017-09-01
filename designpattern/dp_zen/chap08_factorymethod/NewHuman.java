package dp_zen.chap08_factorymethod;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-06-28 11:22
 */
public class NewHuman implements Human {
    @Override
    public void color() {
        System.out.println("my skin is red.");
    }

    @Override
    public void talk() {
        System.out.println("i am a new man.");
    }
}
