package org.spring.test.ioc.interfaces;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.spring.ioc.interfaces.OneInterface;
import org.spring.test.base.UnitTestBase;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-17 15:50
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestOneInterface extends UnitTestBase{

    public TestOneInterface(){
        super("classpath*:spring-ioc.xml");
    }

    @Test
    public void testSay(){
        OneInterface oneInterface = super.getBean("oneInterface");
        oneInterface.say("This is a test.");
    }
}
