package dp_zen.chap08_factorymethod;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-06-28 10:54
 */
public class BlackHuman implements Human {
    @Override
    public void color() {
        System.out.println("my skin is black.");
    }

    @Override
    public void talk() {
        System.out.println("i am a black man.");
    }
}
