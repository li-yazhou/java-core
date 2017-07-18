package org.spring.beanannotation.injection.service;

import org.spring.beanannotation.injection.dao.InjectionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-17 16:58
 */
@Service
public class InjectionServiceImpl implements InjectionService {
    @Autowired
    private InjectionDAO injectionDAO;

    public InjectionServiceImpl(){}

    // 构造器注入依赖的对象
    // @Autowired
    public InjectionServiceImpl(InjectionDAO injectionDAO){
        this.injectionDAO = injectionDAO;
    }

    // 设置注入
    // @Autowired
    public void setInjectionDAO(InjectionDAO _injectionDAO){
        injectionDAO = _injectionDAO;
    }

    @Override
    public void save(String arg) {
        // 模拟业务操作
        System.out.println("service接受参数：" + arg);
        arg = arg + " : " + this.hashCode();
        injectionDAO.save(arg);
    }
}












