package org.spring.test.base;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

/**
 * description:单元测试类基类
 *
 * @author liyazhou
 * @since 2017-07-16 22:24
 */
public class UnitTestBase {
    private ClassPathXmlApplicationContext context;
    private String springXmlPath;
    public UnitTestBase(){}
    public UnitTestBase(String _springXmlPath){
        springXmlPath = _springXmlPath;
    }

    @Before
    public void before(){
        if (StringUtils.isEmpty(springXmlPath)){
            springXmlPath = "classpath*:spring-*xml";
        }
        context = new ClassPathXmlApplicationContext(springXmlPath.split("[,\\s]+"));
        context.start();
    }

    @After
    public void after(){
        context.destroy();
    }

    protected <T extends Object> T getBean(String beanId){
        return (T) context.getBean(beanId);
    }

    protected <T extends Object> T getBean(Class<T> clazz){
        return context.getBean(clazz);
    }


}
