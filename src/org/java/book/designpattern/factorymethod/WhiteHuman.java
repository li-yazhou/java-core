package org.java.book.designpattern.factorymethod;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-06-28 10:54
 */
public class WhiteHuman implements Human{
    @Override
    public void color() {
        System.out.println("my skin is white.");
    }

    @Override
    public void talk() {
        System.out.println("i am a white man.");
    }
}
