package org.alpha.javabase.javaprimer.javaprimer_code.chap28_Reflect_RegExp.src.cn.itcast.reflect.demo;

import java.io.FileReader;
import java.lang.reflect.Constructor;

public class ReflectDemo2 {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, Exception {

		createNewObject_2();
		
	}
	
	public static void createNewObject_2() throws Exception {
		
//		cn.itcast.bean.Person p = new cn.itcast.bean.Person("Сǿ",39);
		
		/*
		 * ����ȡָ�����ƶ�Ӧ���е������ֵĶ���ʱ��
		 * ���ö����ʼ����ʹ�ÿղ����������ô���أ�
		 * ��Ȼ��ͨ��ָ���Ĺ��� �������ж���ĳ�ʼ����
		 * ����Ӧ���Ȼ�ȡ���ù��캯���� ͨ���ֽ����ļ����󼴿���ɡ�
		 * �÷����ǣ�getConstructor(paramterTypes);
		 * 
		 */
		String name = "cn.itcast.bean.Person";
		//��Ѱ���������ļ��������ؽ��ڴ棬������Class����
		Class clazz = Class.forName(name);
		//��ȡ����ָ���Ĺ��캯����  ��
		Constructor constructor = clazz.getConstructor(String.class,int.class);
		
		//ͨ���ù����������newInstance�������ж���ĳ�ʼ����
		Object obj = constructor.newInstance("С��",38);
		
			
		
	}

	public static void createNewObject() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		
		//���ڣ�newʱ���ȸ��ݱ�new�����������Ѱ������ֽ����ļ��������ؽ��ڴ棬
//		���������ֽ����ļ����󣬲����Ŵ������ֽ��ļ��Ķ�Ӧ��Person����.
//		cn.itcast.bean.Person p = new cn.itcast.bean.Person();
		
		//���ڣ�
		String name = "cn.itcast.bean.Person";
		//��Ѱ���������ļ��������ؽ��ڴ棬������Class����
		Class clazz = Class.forName(name);
		//��β�������Ķ����أ�
		Object obj  = clazz.newInstance();
		
		
		
		
	}
}
