package org.spring.test.aware;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.spring.test.base.UnitTestBase;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-17 21:09
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestAware extends UnitTestBase {

    public TestAware(){
        super("classpath:spring-aware.xml");
    }
    @Test
    public void testMyApplicationContext(){
        System.out.println("testMyApplicationContext : " + super.getBean("myApplicationContext").hashCode());
    }

    @Test
    public void textBeanName(){
        System.out.println("testMyBeanName : " + super.getBean("myBeanName").hashCode());
    }
}
