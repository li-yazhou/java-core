package org.spring.test.autowiring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.spring.autowiring.AutoWiringService;
import org.spring.test.base.UnitTestBase;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-18 8:12
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestAutoWiring extends UnitTestBase {

    public TestAutoWiring(){
        super("classpath:spring-autowiring.xml");
    }

    @Test
    public void testSay(){
        AutoWiringService service = super.getBean("autoWiringService");
        service.say("this is a autowiring test");
    }
}













