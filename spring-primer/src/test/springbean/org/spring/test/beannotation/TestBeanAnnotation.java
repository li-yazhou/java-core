package org.spring.test.beannotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.spring.beanannotation.BeanAnnotation;
import org.spring.test.base.UnitTestBase;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-18 10:00
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestBeanAnnotation extends UnitTestBase {

    public TestBeanAnnotation(){
        super("classpath*:spring-beanannotation.xml");
    }

    @Test
    public void testSay(){
        String beanName = "beanAnnotation";
        String beanName2 = "bean";
        BeanAnnotation bean = super.getBean(beanName);
        bean.say("this is a test");

        bean = super.getBean(beanName);
        bean.say("this is a test");
    }

    @Test
    public void testScope(){
        String beanName = "beanAnnotation";
        BeanAnnotation bean = super.getBean(beanName);
        bean.myHashCode();

        bean = super.getBean(beanName);
        bean.myHashCode();
    }
}























