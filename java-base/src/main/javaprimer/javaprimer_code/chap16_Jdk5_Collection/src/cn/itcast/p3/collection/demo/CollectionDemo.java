package org.alpha.javabase.javaprimer.javaprimer_code.chap16_Jdk5_Collection.src.cn.itcast.p3.collection.demo;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Collection coll = new ArrayList();
		
//		show(coll);
		
		Collection c1 = new ArrayList();
		Collection c2 = new ArrayList();
		show(c1,c2);
		
	}
	
	public static void show(Collection c1,Collection c2){
		
		//��c1���Ԫ�ء�
		c1.add("abc1");
		c1.add("abc2");
		c1.add("abc3");
		c1.add("abc4");
		
		//��c2���Ԫ�ء�
		c2.add("abc1");
		c2.add("abc2");
		c2.add("abc3");
		c2.add("abc4");
		c2.add("abc5");
		
		System.out.println("c1:"+c1);
		System.out.println("c2:"+c2);
		
		//��ʾaddAll
		
//		c1.addAll(c2);//��c2�е�Ԫ����ӵ�c1�С�
		
		
		//��ʾremoveAll
//		boolean b = c1.removeAll(c2);//�����������е���ͬԪ�شӵ���removeAll�ļ�����ɾ����
//		System.out.println("removeAll:"+b);
		
		//��ʾcontainsAll
//		boolean b = c1.containsAll(c2);
//		System.out.println("containsAll:"+b);
		
		//��ʾretainAll
		boolean b = c1.retainAll(c2);//ȡ������������ָ���ļ�����ͬ��Ԫ�أ���ɾ����ͬ��Ԫ�ء�
								//��removeAll�����෴ ��
		System.out.println("retainAll:"+b);
		System.out.println("c1:"+c1);
		
		
	}
	
	public static void show(Collection coll){
		
		//1,���Ԫ�ء�add.
		coll.add("abc1");
		coll.add("abc2");
		coll.add("abc3");
		System.out.println(coll);
		
		
		//2��ɾ��Ԫ�ء�remove
//		coll.remove("abc2");//��ı伯�ϵĳ��� 
		
		//��ռ���.
//		coll.clear();
		
		System.out.println(coll.contains("abc3"));
		
		
		System.out.println(coll);
		
	}

}
