package javase.proxy.cglib.dao;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Test;

/**
 * @author liyazhou1
 * @date 2019/12/17
 */
public class DaoProxyDemo {

    public static void main(String[] args) {

        DaoProxyForMethod daoProxyForMethod = new DaoProxyForMethod();

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(Dao.class);

        enhancer.setCallback(daoProxyForMethod);

        Dao daoProxy = (Dao) enhancer.create();

        daoProxy.update();

        // java.lang.ClassCastException:
        // $javase.proxy.cglib.dao.Dao$$EnhancerByCGLIB$$27153b2f cannot be cast to java.lang.String
        daoProxy.select();

    }


    @Test
    public void callbackFilter() {

        DaoProxyForMethod daoProxyForMethod = new DaoProxyForMethod();

        DaoProxyForMethodV2 daoProxyForMethodV2 = new DaoProxyForMethodV2();

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(Dao.class);

        enhancer.setCallbacks(new Callback[] {daoProxyForMethod, daoProxyForMethodV2, NoOp.INSTANCE});

        enhancer.setCallbackFilter(new DaoMethodProxyFilter());

        // 构造方法不被拦截
        enhancer.setInterceptDuringConstruction(false);

        Dao daoProxyWithFilter = (Dao) enhancer.create();

        daoProxyWithFilter.insert();

        daoProxyWithFilter.update();

        daoProxyWithFilter.select();

    }
}
