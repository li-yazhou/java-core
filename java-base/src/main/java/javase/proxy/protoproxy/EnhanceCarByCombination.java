package javase.proxy.protoproxy;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-22 11:20
 */
public class EnhanceCarByCombination implements Movable{
    private Movable car;

    public EnhanceCarByCombination(Movable car){
        this.car = car;
    }

    @Override
    public void move(){
        long startTime = System.currentTimeMillis();
        car.move();  // 使用组合的方式实现代理
        long endTime = System.currentTimeMillis();
        System.out.println("汽车行驶时间为 " + (endTime - startTime) + " ms.");
    }
}
