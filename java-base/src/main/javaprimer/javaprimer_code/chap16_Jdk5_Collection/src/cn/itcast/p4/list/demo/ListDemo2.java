package org.alpha.javabase.javaprimer.javaprimer_code.chap16_Jdk5_Collection.src.cn.itcast.p4.list.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class ListDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List list = new ArrayList();
//		show(list);
		
		
		list.add("abc1");
		list.add("abc2");
		list.add("abc3");
		
		System.out.println("list:"+list);
		ListIterator it = list.listIterator();//��ȡ�б����������
		//������ʵ���ڵ�����������ɶ�Ԫ�ص���ɾ�Ĳ顣
		//ע�⣺ֻ��list���Ͼ߱��õ�������.
		
		
		while(it.hasNext()){
			
			Object obj = it.next();
			
			if(obj.equals("abc2")){
				it.set("abc9");
			}
		}
//		System.out.println("hasNext:"+it.hasNext());
//		System.out.println("hasPrevious:"+it.hasPrevious());
		
		
		while(it.hasPrevious()){
			System.out.println("previous:"+it.previous());
		}
		System.out.println("list:"+list);
		
		
		
		
		
		/*Iterator it = list.iterator();
		while(it.hasNext()){
			
			Object obj = it.next();//java.util.ConcurrentModificationException
							//�ڵ����������У���Ҫʹ�ü��ϲ���Ԫ�أ����׳����쳣��
						//����ʹ��Iterator�ӿڵ��ӽӿ�ListIterator������ڵ����ж�Ԫ�ؽ��и���Ĳ����� 
			
			if(obj.equals("abc2")){
				list.add("abc9");
			}
			else
				System.out.println("next:"+obj);
		}
		System.out.println(list);
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	public static void show(List list) {
		
		list.add("abc1");
		list.add("abc2");
		list.add("abc3");
		list.add("abc4");
		
		Iterator it = list.iterator();
		while(it.hasNext()){
			System.out.println("next:"+it.next());
		}
		
		//list���е�ȡ��Ԫ�صķ�ʽ֮һ��
		
		for(int x=0; x<list.size(); x++){
			System.out.println("get:"+list.get(x));
		}
	}

}
