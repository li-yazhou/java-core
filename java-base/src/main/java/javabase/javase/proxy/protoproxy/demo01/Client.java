package javabase.javase.proxy.protoproxy.demo01;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-22 11:13
 */
public class Client {

    @Test
    public void testCarMove(){
        Movable car = new Car();
        car.move();
    }


    @Test
    public void testEnhanceCarMove(){
        Movable car = new EnhanceCarByExtends();
        car.move();
    }

    @Test
    public void testEnhanceCarByCombination(){
        Movable car = new Car();
        Movable enhanceCar = new EnhanceCarByCombination(car);
        enhanceCar.move();
    }

}
