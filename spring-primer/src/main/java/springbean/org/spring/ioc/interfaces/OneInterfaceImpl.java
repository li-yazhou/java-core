package springbean.org.spring.ioc.interfaces;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-17 15:43
 */
public class OneInterfaceImpl implements OneInterface {
    @Override
    public void say(String arg) {
        System.out.println("ServiceImpl say: " + arg);
    }
}
