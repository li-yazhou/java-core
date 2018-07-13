package org.alpha.javabase.javaprimer.javaprimer_code.chap17_Collection.src.cn.itcast.p5.treeset.test;

import java.util.Iterator;
import java.util.TreeSet;

import cn.itcast.p5.comparator.ComparatorByLength;

/* 
 * ���ַ������г�������
 * 
 * "20 18 -1 89 2 67"
 */

public class TreeSetTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TreeSet ts = new TreeSet(new ComparatorByLength());

		ts.add("aaaaa");
		ts.add("zz");
		ts.add("nbaq");
		ts.add("cba");
		ts.add("abc");
		
		Iterator it = ts.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
