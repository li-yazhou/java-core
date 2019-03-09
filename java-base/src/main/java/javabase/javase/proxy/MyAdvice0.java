package javabase.javase.proxy;

import java.lang.reflect.Method;

public class MyAdvice0 implements Advice0 {
	private long startTime = 0;

	@Override
	public void beforeMethod(Method method) {
		System.out.println(method.getName() + " start executing...");
		startTime = System.currentTimeMillis();
	}

	@Override
	public void afterMethod(Method method) {
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		System.out.println(method.getName() + " finished...");
		System.out.println(method.getName() + " execute time is " + time);
	}
}
