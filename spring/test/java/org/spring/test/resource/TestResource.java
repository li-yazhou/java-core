package org.spring.test.resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.spring.resource.MyResource;
import org.spring.test.base.UnitTestBase;

import java.io.IOException;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-18 8:45
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestResource extends UnitTestBase {

    public TestResource(){
        super("classpath:spring-resource.xml");
    }

    @Test
    public void testResource(){
        MyResource resource = super.getBean("myResource");
        try {
            resource.resource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


















}
