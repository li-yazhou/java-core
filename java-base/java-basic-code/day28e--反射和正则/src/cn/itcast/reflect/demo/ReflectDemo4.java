package cn.itcast.reflect.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectDemo4 {

	public ReflectDemo4() {
	}

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		getMethodDemo_3();
		
	}
	
	

	public static void getMethodDemo_3() throws Exception {
		
		Class clazz = Class.forName("cn.itcast.bean.Person");
		
		Method method = clazz.getMethod("paramMethod", String.class,int.class);
		
		Object obj = clazz.newInstance();
		
		method.invoke(obj, "小强",89);
		
		
	}

	public static void getMethodDemo_2() throws Exception {
		
		Class clazz = Class.forName("cn.itcast.bean.Person");
		
		Method method = clazz.getMethod("show", null);//获取空参数一般方法。
		
//		Object obj = clazz.newInstance();
		Constructor constructor = clazz.getConstructor(String.class,int.class);
		Object obj = constructor.newInstance("小明",37);
		
		
		method.invoke(obj, null);
		
		
		
	}

	/*
	 * 获取指定Class中的所有公共函数。
	 */
	public static void getMethodDemo() throws Exception {
		
		Class clazz = Class.forName("cn.itcast.bean.Person");
		
		Method[] methods  = clazz.getMethods();//获取的都是公有的方法。 
		methods = clazz.getDeclaredMethods();//只获取本类中所有方法，包含私有。 
		for(Method method : methods){
			System.out.println(method);
		}
		
		
	}

}
