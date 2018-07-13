package org.alpha.javabase.javaprimer.javaprimer_code.chap16_Jdk5_Collection.src.cn.itcast.p4.list.demo;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List list = new ArrayList();
		show(list);
	}

	public static void show(List list) {
		
		//���Ԫ��
		list.add("abc1");
		list.add("abc2");
		list.add("abc3");
		System.out.println(list);
		
		//����Ԫ�ء�		
//		list.add(1,"abc9");
		
		//ɾ��Ԫ�ء�
//		System.out.println("remove:"+list.remove(2));
		
		//�޸�Ԫ�ء�
//		System.out.println("set:"+list.set(1, "abc8"));
		
		//��ȡԪ�ء�
//		System.out.println("get:"+list.get(0));
		
		//��ȡ���б�
//		System.out.println("sublist:"+list.subList(1, 2));
		
		
		System.out.println(list);
		
		
	}

}
