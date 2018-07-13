package org.alpha.javabase.javaprimer.javaprimer_code.chap15_String.p1.string.demo;

public class StringObjectDemo {


	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		String s1 = "abc";
//		String s2 = "abc";
		
		//intern():���ַ����ؽ��в����� 
		
		String s1 = new String("abc");
		String s2 = s1.intern();
		
		System.out.println(s1==s2);
		
		
		
	}

}
