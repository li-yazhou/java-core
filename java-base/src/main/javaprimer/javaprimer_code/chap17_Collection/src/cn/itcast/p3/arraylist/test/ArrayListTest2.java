package org.alpha.javabase.javaprimer.javaprimer_code.chap17_Collection.src.cn.itcast.p3.arraylist.test;

import java.util.ArrayList;
import java.util.Iterator;

import org.alpha.javabase.javaprimer.javaprimer_code.chap17_Collection.src.cn.itcast.p.bean.Person;

/*
 * ���幦��ȥ��ArrayList�е��ظ�Ԫ�ء�
 */

public class ArrayListTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
//		demo();
		
//		singleDemo();
		
		
		ArrayList al = new ArrayList();
		al.add(new Person("lisi1",21));
		al.add(new Person("lisi2",22));
		al.add(new Person("lisi3",23));
		al.add(new Person("lisi4",24));
		al.add(new Person("lisi2",22));
		al.add(new Person("lisi3",23));
		System.out.println(al);
		
		al = getSingleElement(al);
		
		
		System.out.println(al.remove(new Person("lisi2",22)));
		System.out.println(al);
		
		
		
		
	}

	/**
	 * 
	 */
	public static void singleDemo() {
		ArrayList al = new ArrayList();
		al.add("abc1");
		al.add("abc2");
		al.add("abc2");
		al.add("abc1");
		al.add("abc");
		System.out.println(al);
		
		al = getSingleElement(al);
		
		System.out.println(al);
		
		
	}

	public static ArrayList getSingleElement(ArrayList al) {
		
		//1,����һ����ʱ������
		ArrayList temp = new ArrayList();
		
		//2,����al���ϡ�
		Iterator it = al.iterator();
		
		while(it.hasNext()){
			Object obj = it.next();
			
			//3,�жϱ���������Ԫ���Ƿ�����ʱ�������ڡ�
			if(!temp.contains(obj)){
				temp.add(obj);
			}
		}
		
		return temp;
	}

	/**
	 * 
	 */
	public static void demo() {
		
//		al.add(5);//al.add(new Integer(5));
	}
	

}
