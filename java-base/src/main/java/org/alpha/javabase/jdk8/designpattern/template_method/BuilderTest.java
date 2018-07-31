package org.alpha.javabase.jdk8.designpattern.template_method;

import org.alpha.javabase.jdk8.designpattern.template_method.impl.BuilderA;
import org.alpha.javabase.jdk8.designpattern.template_method.impl.BuilderB;
import org.junit.Test;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @date 2018/7/31 21:37
 */
public class BuilderTest {

    public static void main(String[] args) {
        IBuilder builderA = new BuilderA();
        IBuilder builderB = new BuilderB();

        System.out.println("builderA = " + builderA.build("a"));
        System.out.println();
        System.out.println("builderB = " + builderB.build("b"));
    }

}
