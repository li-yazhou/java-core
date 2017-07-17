package org.spring.test.lifecycle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.spring.test.base.UnitTestBase;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-17 20:30
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestBeanLifecycle extends UnitTestBase {
    public TestBeanLifecycle(){
        super("classpath:spring-lifecycle.xml");
    }

    @Test
    public void test01(){
        super.getBean("beanLifeCycle");
    }

}









