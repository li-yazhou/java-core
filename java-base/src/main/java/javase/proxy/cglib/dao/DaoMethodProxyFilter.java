package javase.proxy.cglib.dao;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * @author liyazhou1
 * @date 2019/12/17
 */
public class DaoMethodProxyFilter implements CallbackFilter {


    /**
     * 每个方法使用的Callback对应的下标，可以使每个方法使用不同的拦截器
     *
     * @param method 拦截的方法
     * @return Callback索引
     */
    @Override
    public int accept(Method method) {

        switch (method.getName()) {
            case "select":
                return 2;
            case "update":
                return 1;
            case "insert":
                return 0;
        }

        return 2;
    }
}
