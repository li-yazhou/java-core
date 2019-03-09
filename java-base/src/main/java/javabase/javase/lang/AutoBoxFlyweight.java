package javabase.javase.lang;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-11 20:26
 */
public class AutoBoxFlyweight {

    @Test
    public void autobox(){
        int i = 10;
        int j = 128;

        Integer ii1 = i;
        Integer ii2 = i;
        System.out.println("ii == ij ? " + (ii1 == ii2));  // true，它们都是包装类型的对象，但是是同一个对象

        Integer ij1 = j;
        Integer ij2 = j;
        System.out.println("ii == ij ? " + (ij1 == ij2)); // false，它们都是包装类型的对象，但是不是同一个对象

        /*
        自动装箱拆箱AutoBox和享元模式flyweight
        Integer ii1 = i;
        Integer ii2 = i;
        以-128~127之间的整数初始化包装类型，自动装箱时，因为这些数字使用频率较高且可能不被改变，内存可以缓存起来，这样就可以节省内存

        享元模式：
            经常使用一些在一定范围内的对象，而且这些对象一般不被改变，当使用该对象时，就把它创建并缓存起来，以后其他地方再次使用时，
            直接从缓存中取出来即可，不用再次创建，这样可以避免创建新对象而造成的资源浪费（cpu和内存等资源）。

            比如，文本编辑器中字符，对于英文字母的话，就创建52个字母对象，没必要每写一个字符就创建一个对象，只是显示的位置不一样而已。
            还有，操作系统中的文件夹的图标，也都是一个对象，只是文件名和位置不同而已。

            这就是享元设计模式，它简单，正因为它很简单，所以它是设计模式，如果它很复杂，那么它就是设计模式了。

        */
    }
}
