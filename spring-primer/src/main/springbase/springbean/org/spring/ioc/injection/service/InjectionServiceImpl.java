package springbean.org.spring.ioc.injection.service;


import org.spring.beanannotation.injection.dao.InjectionDAO;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-17 16:58
 */
public class InjectionServiceImpl implements InjectionService {
    private InjectionDAO injectionDAO;

    public InjectionServiceImpl(){}

    // 构造器注入依赖的对象
    public InjectionServiceImpl(InjectionDAO injectionDAO){
        this.injectionDAO = injectionDAO;
    }

    // 设置注入
    public void setInjectionDAO(InjectionDAO _injectionDAO){
        injectionDAO = _injectionDAO;
    }
    // @Override
    public void save(String arg) {
        // 模拟业务操作
        System.out.println("service接受参数：" + arg);
        arg = arg + " : " + this.hashCode();
        injectionDAO.save(arg);
    }
}












