package org.alpha.javabase.javaprimer.javaprimer_code.chap20_Util_IO.src.cn.itcast.p1.otherapi;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class SystemDemo {

	
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		
		
		
		/*
		 * System:���еķ��������Զ��Ǿ�̬�ġ�
		 * 
		 * 
		 * ����������
		 * long currentTimeMillis();��ȡ��ǰʱ��ĺ���ֵ�� 
		 * 
		 */
		
//		long l1 = 1335664696656l;//System.currentTimeMillis();
//		System.out.println(l1/1000/60/60/24);//1335664696656
//		code..
//		long l2 = System.currentTimeMillis();
//		System.out.println(l2-l1);

		
		System.out.println("hello-"+LINE_SEPARATOR+" world");
//		demo_1();
		//��ϵͳ����һЩ������Ϣ����Щ��Ϣ��ȫ�֣��������򶼿���ʹ�á� 
//		System.setProperty("myclasspath", "c:\myclass");
		
	}
	
	public static void demo_1(){
		//��ȡϵͳ��������Ϣ�����洢����Properties�����С� 
		/*
		 * properties�����д洢����String���͵ļ���ֵ��
		 * ���ʹ�����Լ��Ĵ洢��ȡ���ķ��������Ԫ�صĲ�����
		 */
		Properties prop = System.getProperties();
		
		Set<String> nameSet = prop.stringPropertyNames();
		
		for(String name : nameSet){
			String value = prop.getProperty(name);
			
			System.out.println(name+"::"+value);
		}
		
	}
	
}












