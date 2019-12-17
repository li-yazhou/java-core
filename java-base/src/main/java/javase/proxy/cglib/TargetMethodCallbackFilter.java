package javase.proxy.cglib;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * @author liyazhou1
 * @date 2019/12/16
 */
public class TargetMethodCallbackFilter implements CallbackFilter {

    @Override
    public int accept(Method method) {
        return 0;
    }

}
