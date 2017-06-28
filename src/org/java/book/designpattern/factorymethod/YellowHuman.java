package org.java.book.designpattern.factorymethod;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-06-28 10:53
 */
public class YellowHuman implements Human{
    @Override
    public void color() {
        System.out.println("my skin is yellow.");
    }

    @Override
    public void talk() {
        System.out.println("i am a yellow man.");
    }
}
