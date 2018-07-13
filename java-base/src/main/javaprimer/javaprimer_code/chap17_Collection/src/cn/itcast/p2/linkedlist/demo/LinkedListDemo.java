package org.alpha.javabase.javaprimer.javaprimer_code.chap17_Collection.src.cn.itcast.p2.linkedlist.demo;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LinkedList link = new LinkedList();
		
		link.addFirst("abc1");
		link.addFirst("abc2");
		link.addFirst("abc3");
		link.addFirst("abc4");
//		System.out.println(link);
//		System.out.println(link.getFirst());//��ȡ��һ������ɾ����
//		System.out.println(link.getFirst());
		
//		System.out.println(link.removeFirst());//��ȡԪ�ص��ǻ�ɾ����
//		System.out.println(link.removeFirst());
		
		while(!link.isEmpty()){
			System.out.println(link.removeLast());
		}
		
		
		System.out.println(link);
//		Iterator it = link.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
	}

}





