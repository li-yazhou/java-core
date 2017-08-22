package javacore.proxy_imooc.cglibproxy;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-22 14:24
 */
public class CglibProxyTest {

    @Test
    public void testMove(){
        CglibProxy cglibProxy = new CglibProxy();
        Train train = (Train)cglibProxy.getProxy(Train.class);
        train.move();
    }
}
