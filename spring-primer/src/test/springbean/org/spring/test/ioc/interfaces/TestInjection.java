package org.spring.test.ioc.interfaces;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.spring.beanannotation.injection.service.InjectionService;
import org.spring.test.base.UnitTestBase;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-17 17:10
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestInjection extends UnitTestBase {

    public TestInjection(){
        super("classpath:spring-injection.xml");
    }

    @Test
    public void testSetter(){
        InjectionService service = super.getBean("injectionService");
        service.save("这是要保存的数据");
    }

    @Test
    public void testCons(){
        InjectionService service = super.getBean("injectionService");
        service.save("这是要保存的数据");
    }
}
