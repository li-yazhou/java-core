package designpattern.factorymethod;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-06-28 11:04
 */
public class HumanFactory extends AbstractHumanFactory {
    @Override
    public <T extends Human> T createHuman(Class<T> clazz) {
        T man = null;
        try {
            man = (T)Class.forName(clazz.getName()).newInstance();  // 强制类型转换
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("program goes wrong when creating human.");
        }
        return man;
    }
}
