package org.alpha.javabase.javaprimer.javaprimer_code.chap16_Jdk5_Collection.src.cn.itcast.p2.wrapper.demo;

public class WrapperDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int num = 4;
		num = num + 5;
		
		Integer i =  4;//i = new Integer(4);�Զ�װ��  ����д��
		i = i + 6;// i = new Integer(i.intValue() + 6); //i.intValue() �Զ�����
		
		
//		show(55);//
		
		
		Integer a = new Integer(128);
		Integer b = new Integer(128);
		
		System.out.println(a==b);//false
		System.out.println(a.equals(b));//true
		
		Integer x = 129;//jdk1.5�Ժ��Զ�װ�䣬���װ�����һ���ֽڣ���ô�����ݻᱻ���������¿��ٿռ䡣
		Integer y = 129;
		System.out.println(x==y);//
		System.out.println(x.equals(y));//true
		
		
	}
	
	public static void show(Object a){//Object a = new Integer(55);
		System.out.println("a="+a);
	}

}
