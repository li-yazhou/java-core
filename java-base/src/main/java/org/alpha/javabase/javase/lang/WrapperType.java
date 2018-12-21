package org.alpha.javabase.javase.lang;

import org.junit.Test;

/**
 * <p>
 *
 * @author liyazhou1
 * @date 2018/12/17
 */
public class WrapperType {

    /*

    byte        Byte
    short       Short
    int         Integer
    long        Long
    float       Float
    double      Double
    char        Character
    boolean     Boolean

     */


    @Test
    public void FlyWeightPattern() {

        Integer integer1 = new Integer(127);
        Integer integer2 = new Integer(127);

        System.out.println("(integer1 == integer2) = " + (integer1 == integer2));  // false

        /* 自动装箱时，使用FlyWeight Pattern */
        Integer i1 = 127;
        Integer i2 = 127;
        System.out.println("(i1 == i2) = " + (i1 == i2));
    }
}
