package springbean.org.spring.ioc.injection.dao;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-17 16:56
 */
public class InjectionDAOImpl implements InjectionDAO {
    @Override
    public void save(String arg) {
        System.out.println("保存数据：" + arg);
    }
}
