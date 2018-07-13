package org.alpha.javabase.javaprimer.javaprimer_code.chap28_Reflect_RegExp.src.cn.itcast.reflect.demo;

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
		
		method.invoke(obj, "Сǿ",89);
		
		
	}

	public static void getMethodDemo_2() throws Exception {
		
		Class clazz = Class.forName("cn.itcast.bean.Person");
		
		Method method = clazz.getMethod("show", null);//��ȡ�ղ���һ�㷽����
		
//		Object obj = clazz.newInstance();
		Constructor constructor = clazz.getConstructor(String.class,int.class);
		Object obj = constructor.newInstance("С��",37);
		
		
		method.invoke(obj, null);
		
		
		
	}

	/*
	 * ��ȡָ��Class�е����й���������
	 */
	public static void getMethodDemo() throws Exception {
		
		Class clazz = Class.forName("cn.itcast.bean.Person");
		
		Method[] methods  = clazz.getMethods();//��ȡ�Ķ��ǹ��еķ����� 
		methods = clazz.getDeclaredMethods();//ֻ��ȡ���������з���������˽�С� 
		for(Method method : methods){
			System.out.println(method);
		}
		
		
	}

}
