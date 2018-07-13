package org.alpha.javabase.javaprimer.javaprimer_code.chap15_String.p1.string.demo;

public class StringConstructorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * ���ֽ���������ַ�����ת���ַ�������ͨ��String��Ĺ��캯����ɡ�
		 */
		
		stringConstructorDemo2();
	}

	private static void stringConstructorDemo2() {
		char[] arr = {'w','a','p','q','x'};
		String s = new String(arr,1,3);
		
		System.out.println("s="+s);
	}

	public static void stringConstructorDemo() {
		String s = new String();//��Ч��String s = "";  ����ЧString s = null;
		
		byte[] arr = {97,66,67,68};
		
		String s1 = new String(arr);
		System.out.println("s1="+s1);
		
	}



}
