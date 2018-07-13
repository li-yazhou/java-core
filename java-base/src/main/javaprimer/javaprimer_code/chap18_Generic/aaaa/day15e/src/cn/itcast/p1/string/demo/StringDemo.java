package org.alpha.javabase.javaprimer.javaprimer_code.chap18_Generic.aaaa.day15e.src.cn.itcast.p1.string.demo;

public class StringDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * String����ص㣺
		 * �ַ�������һ������ʼ���Ͳ��ᱻ�ı䡣
		 * 
		 */
		stringDemo2();
	}

	public static void stringDemo2() {
		// TODO Auto-generated method stub
		
		String s = "abc";//����һ���ַ��������ڳ������С�		
		String s1 = new String("abc");//������������һ��newһ���ַ��������ڶ��ڴ��С�
		
		System.out.println(s==s1);//false
		
		System.out.println(s.equals(s1));
		//string���е�equals��дObject�е�equals������string���Լ����ж��ַ��������Ƿ���ͬ�����ݡ�
		//��ʵ���ǱȽ��ַ������ݡ�
		
		
//		System.out.println("s="+s);
//		System.out.println("s1="+s1);
		
	}

	/**
	 * ��ʾ�ַ�������ĵ�һ�ַ�ʽ������ȷ�ַ��������ص��ص�.
	 * ����û�оͽ����������У�ֱ���á�
	 */
	private static void stringDemo1() {
		String s = "abc";//"abc"�洢���ַ����������С�
//		s = "nba";
		String s1 = "abc";		
		System.out.println(s==s1);//true?
//		System.out.println("s="+s);
	}

}
