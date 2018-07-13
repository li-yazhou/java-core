package org.alpha.javabase.javaprimer.javaprimer_code.chap20_Util_IO.src.cn.itcast.p1.otherapi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {

		methodDemo_3();

		
	}
	

	/**
	 * �����ڸ�ʽ���ַ���-->���ڶ���
	 * 	ʹ�õ���DateFormat���е�parse()������ 
	 * 
	 * @throws ParseException 
	 */
	public  static void methodDemo_3() throws ParseException {
		
		String str_date = "2012��4��19��";
		str_date = "2011---8---17";
		
				
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
		
		dateFormat = new SimpleDateFormat("yyyy---MM---dd");
		
		
		Date date = dateFormat.parse(str_date);
		
		System.out.println(date);
		
		
	}


	/**
	 * �����ڶ�����и�ʽ����
	 * �����ڶ���-->���ڸ�ʽ���ַ�����
	 * 	ʹ�õ���DateFormat���е�format������
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public static void methodDemo_2() {
		
		Date date = new Date();
		
		//��ȡ���ڸ�ʽ���󡣾�����Ĭ�ϵķ�� FULL LONG�ȿ���ָ�����
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
		dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
//		System.out.println(dateFormat);
		
		//���������Զ������ν���أ�
		dateFormat = new SimpleDateFormat("yyyy--MM--dd");
		
		String str_date = dateFormat.format(date);
		
		System.out.println(str_date);
	}
	
	
	
	/**
	 * ���ڶ���ͺ���ֵ֮���ת����
	 * 
	 * ����ֵ-->���ڶ��� �� 
	 * 	1��ͨ��Date����Ĺ��췽��  new Date(timeMillis);
	 *  2��������ͨ��setTime���á� 
	 *  ��Ϊ����ͨ��Date����ķ����Ը������еĸ����ֶ�(�����յ�)���в�����
	 *  
	 * 
	 * ���ڶ���-->����ֵ��
	 * 	2��getTime������
	 * ��Ϊ����ͨ���������ֵ�������㡣 
	 * 
	 * 
	 */
	public static void methodDemo_1() {
		long time = System.currentTimeMillis();//
//		System.out.println(time);//1335671230671
		
		Date date = new Date();//����ǰ���ں�ʱ���װ��Date����
		System.out.println(date);//Sun Apr 29 11:48:02 CST 2012
		
		Date date2 = new Date(1335664696656l);//��ָ������ֵ��װ��Date����
		System.out.println(date2);
	}
	
	

}
