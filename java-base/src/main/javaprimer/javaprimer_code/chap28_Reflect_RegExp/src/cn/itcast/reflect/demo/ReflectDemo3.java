package org.alpha.javabase.javaprimer.javaprimer_code.chap28_Reflect_RegExp.src.cn.itcast.reflect.demo;

import java.lang.reflect.Field;

public class ReflectDemo3 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		getFieldDemo();
		
	}

	/*
	 * ��ȡ�ֽ����ļ��е��ֶΡ�
	 */
	public static void getFieldDemo() throws Exception {
		
		Class clazz = Class.forName("cn.itcast.bean.Person");
		
		Field field = null;//clazz.getField("age");//ֻ�ܻ�ȡ���еģ�
		
		field = clazz.getDeclaredField("age");//ֻ��ȡ���࣬������˽�С� 
		
		//��˽���ֶεķ���ȡ��Ȩ�޼�顣�������ʡ�
		field.setAccessible(true);
		
		Object obj = clazz.newInstance();
		
		field.set(obj, 89);
		
		
		Object o = field.get(obj);
		
		System.out.println(o);
		
//		cn.itcast.bean.Person p = new cn.itcast.bean.Person();
//		p.age = 30;
		
	}
	
}
