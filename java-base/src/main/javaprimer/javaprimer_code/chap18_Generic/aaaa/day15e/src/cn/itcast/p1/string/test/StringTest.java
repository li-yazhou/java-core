package org.alpha.javabase.javaprimer.javaprimer_code.chap18_Generic.aaaa.day15e.src.cn.itcast.p1.string.test;



/*
 * 1������һ���ַ������顣�����ֵ�˳����д�С���������
 * {"nba","abc","cba","zz","qq","haha"}
 * 
 * 
 * 2��һ���Ӵ��������г��ֵĴ�����
 * "nbaernbatynbauinbaopnba"
 * 
 * 
 * 
 * 3�������ַ����������ͬ���Ӵ���
 * 
 * 
 * 
 * 4��ģ��һ��trim����һ�µķ�����
 * 
 * 
 */
public class StringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s1 = "hello";
		String s2 = "java";
		
		show(s1,s2);
		
		System.out.println(s1+"...."+s2);// hello java
	}
	
	public static void show(String s1,String s2){
		
		s2.replace('a','o');
		s1 = s2;
	}
	

}
