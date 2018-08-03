package org.alpha.javabase.jdk8.designpattern.responsibility_chain;

import org.junit.Test;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @date 2018/8/2 23:28
 */
public class ResponsibilityChainTest {

    @Test
    public void test() {
        ProcessingObject<String> processing1 = new HeadTextProcessing();
        ProcessingObject<String> processing2 = new TailTextProcessing();

        processing1.setSuccessor(processing2);

        String result = processing1.handle("This is a string");
        System.out.println(result);
    }
}
