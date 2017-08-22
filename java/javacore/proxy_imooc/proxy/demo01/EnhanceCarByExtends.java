package javacore.proxy_imooc.proxy.demo01;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-22 11:17
 */
public class EnhanceCarByExtends extends Car{

    @Override
    public void move(){
        long startTime = System.currentTimeMillis();
        super.move();  // 使用继承的方式实现代理
        long endTime = System.currentTimeMillis();
        System.out.println("汽车行驶时间为 " + (endTime - startTime) + " ms.");
    }
}
