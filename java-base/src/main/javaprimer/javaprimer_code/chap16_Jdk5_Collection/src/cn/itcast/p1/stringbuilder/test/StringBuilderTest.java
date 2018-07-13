package org.alpha.javabase.javaprimer.javaprimer_code.chap16_Jdk5_Collection.src.cn.itcast.p1.stringbuilder.test;

public class StringBuilderTest {
	public static void main(String[] args) {

		StringBuilder s1 = new StringBuilder("hello");
		StringBuilder s2 = new StringBuilder("java");
		
		show(s1,s2);
		
		System.out.println(s1+"......."+s2);
		
	}

	private static void show(StringBuilder s1, StringBuilder s2) {
		
		s1.append(s2);
		s1 = s2;
	}
	
}
