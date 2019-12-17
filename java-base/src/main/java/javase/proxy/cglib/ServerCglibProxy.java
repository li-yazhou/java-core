package javase.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-22 14:24
 */
public class ServerCglibProxy {


    /**
     * 生成代理对象
     */
    public Object getProxy(Class<?> clazz){

        Enhancer enhancer = new Enhancer();

        Server target = new Server();

        // 待增强的目标类对象
        enhancer.setSuperclass(clazz);

        // 增强目标类的方法
        enhancer.setCallback(new TargetInterceptor(target));

        return enhancer.create();
    }


    @Test
    public void testServer(){
        Server server = (Server) getProxy(Server.class);
        server.start();
        System.out.println("-------------------------");
        server.running();
        System.out.println("-------------------------");
        server.stop();
    }
}
