package org.spring.test.beannotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.spring.beanannotation.injection.service.InjectionService;
import org.spring.test.base.UnitTestBase;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-18 10:42
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestInjection extends UnitTestBase {
    public TestInjection(){
        super("classpath:spring-beanannotation.xml");
    }

    @Test
    public void testAutowired(){
        InjectionService service = super.getBean("injectionServiceImpl");
        service.save("this is autowired.");
    }

    @Test
    public void testMultiBean(){
//        BeanInvoker invoker = super.getBean("beanInvoker");
//        invoker.say();
    }
}
























