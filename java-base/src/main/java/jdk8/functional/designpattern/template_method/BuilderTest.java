package jdk8.functional.designpattern.template_method;

import jdk8.functional.designpattern.template_method.impl.BuilderA;
import jdk8.functional.designpattern.template_method.impl.BuilderB;

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
