package org.alpha.javabase.javaprimer.javaprimer_code.chap16_Jdk5_Collection.src.cn.itcast.p2.wrapper.demo;

public class WrapperDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * �����������Ͷ����װ�ࡣ
		 * Ϊ�˷������������������ֵ�������װ���˶����ڶ����ж��������Ժ���Ϊ�ḻ�˸����ݵĲ�����
		 * ���������ö������ͳ�Ϊ�����������Ͷ����װ�ࡣ
		 * 
		 * byte		Byte
		 * short	Short
		 * int		Integer
		 * long		Long
		 * float	Float
		 * double	Double
		 * char		Character
		 * boolean	Boolean
		 * 
		 * �ð�װ������Ҫ�û������ͺ��ַ���֮���ת����
		 * 
		 * ��������--->�ַ���
		 * 		1,����������ֵ+""
		 * 		2,��String���еľ�̬����valueOf(����������ֵ);
		 * 		3,��Integer�ľ�̬����valueO(����������ֵ);
		 * 
		 * �ַ���--->��������
		 * 		1,ʹ�ð�װ���еľ�̬����   xxx parseXxx("xxx���͵��ַ���");*****
		 * 			int parseInt("intstring");
		 * 			long parseLong("longstring");
		 * 			boolean parseBoolean("booleanstring");
		 * 			ֻ��Characterû��parse���� 
		 * 		2,����ַ�����Integer���ж���ķ�װ��
		 * 			��ʹ����һ���Ǿ�̬�ķ�����intValue();
		 * 			��һ��Integer����ת�ɻ�����������ֵ��
		 * 
		 * 
		 */
		
		
//		System.out.println(Integer.MAX_VALUE);
		
//		System.out.println(Integer.toBinaryString(-6));
		
//		int num = 4;
//		Integer i = new Integer(5);
		
//		int x = Integer.parseInt("123");
//		System.out.println(Integer.parseInt("123")+1);
		
//		Integer i = new Integer("123");		
//		System.out.println(i.intValue());
		
		
		/*
		 * �����߱���ͬ�Ľ������֡�
		 * 
		 * ʮ����-->�������ơ�
		 * 		toBinaryString
		 * 		toOctalString
		 * 		toHexString
		 * 
		 * ��������-->ʮ���ơ�
		 * 		parseInt("string",radix)
		 * 
		 */
		
//		ʮ����-->�������ơ�
		System.out.println(Integer.toBinaryString(60));
		System.out.println(Integer.toOctalString(60));
		System.out.println(Integer.toHexString(60));
		
		
//		System.out.println(Integer.toString(60,16));
//		��������-->ʮ���ơ�
//		System.out.println(Integer.parseInt("3c",16));
		
		
		Integer a = new Integer("89");
		Integer b = new Integer(300);
		
		System.out.println(a==b);
		
		System.out.println(a.equals(b));
		
//		System.out.println(3>3);
		System.out.println(a.compareTo(b));
		
		
		
	}

}











