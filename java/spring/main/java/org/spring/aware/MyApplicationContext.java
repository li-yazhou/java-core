package org.spring.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-17 21:13
 */
public class MyApplicationContext implements ApplicationContextAware{
    // 该类实现了XxxAware接口，覆写了setter方法，
    // 当容器创建该类的对象时，会自动调用setApplicationContext方法
    // ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // this.applicationContext = applicationContext;
        System.out.println("MyApplicationContext : " + applicationContext.getBean("myApplicationContext").hashCode());
    }
}
