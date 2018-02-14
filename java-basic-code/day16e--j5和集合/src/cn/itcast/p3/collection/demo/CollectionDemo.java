package cn.itcast.p3.collection.demo;

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
		
		//给c1添加元素。
		c1.add("abc1");
		c1.add("abc2");
		c1.add("abc3");
		c1.add("abc4");
		
		//给c2添加元素。
		c2.add("abc1");
		c2.add("abc2");
		c2.add("abc3");
		c2.add("abc4");
		c2.add("abc5");
		
		System.out.println("c1:"+c1);
		System.out.println("c2:"+c2);
		
		//演示addAll
		
//		c1.addAll(c2);//将c2中的元素添加到c1中。
		
		
		//演示removeAll
//		boolean b = c1.removeAll(c2);//将两个集合中的相同元素从调用removeAll的集合中删除。
//		System.out.println("removeAll:"+b);
		
		//演示containsAll
//		boolean b = c1.containsAll(c2);
//		System.out.println("containsAll:"+b);
		
		//演示retainAll
		boolean b = c1.retainAll(c2);//取交集，保留和指定的集合相同的元素，而删除不同的元素。
								//和removeAll功能相反 。
		System.out.println("retainAll:"+b);
		System.out.println("c1:"+c1);
		
		
	}
	
	public static void show(Collection coll){
		
		//1,添加元素。add.
		coll.add("abc1");
		coll.add("abc2");
		coll.add("abc3");
		System.out.println(coll);
		
		
		//2，删除元素。remove
//		coll.remove("abc2");//会改变集合的长度 
		
		//清空集合.
//		coll.clear();
		
		System.out.println(coll.contains("abc3"));
		
		
		System.out.println(coll);
		
	}

}
