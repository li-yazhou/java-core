package org.spring.test.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.spring.bean.BeanScope;
import org.spring.test.base.UnitTestBase;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-17 19:49
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestBeanScope extends UnitTestBase{

    public TestBeanScope(){
        super("classpath*:spring-beanscope.xml");
    }

    @Test
    public void testSay(){
        BeanScope bean = super.getBean("beanScope");
        bean.say();

        BeanScope bean2 = super.getBean("beanScope");
        bean2.say();
    }
}
