package org.alpha.javabase.javabook.fkjava.ch14_annotation.demo01;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-18 19:26
 */
@Description("I am a class annotation.")
public class Child implements Person {
    @Description("I am a method annotation, name = zz")
    @Override
    public String name() {
        return null;
    }

    @Description("i am a method annotation, age = 18")
    @Override
    public int age() {
        return 0;
    }
}
