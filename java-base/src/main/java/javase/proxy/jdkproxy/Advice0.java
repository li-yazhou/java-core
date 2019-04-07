package javase.proxy.jdkproxy;

import java.lang.reflect.Method;

/**
 * 该接口一般有四个方法，分别是在方法之前、之后、之前之后以及异常中执行的代码
 * @author Administrator
 *
 */
public interface Advice0 {
	//void beforeMethod();
	//void afterMethod();
	void beforeMethod(Method method);
	void afterMethod(Method method);
}
