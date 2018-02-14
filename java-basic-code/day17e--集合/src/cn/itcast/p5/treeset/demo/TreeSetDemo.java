package cn.itcast.p5.treeset.demo;

import java.util.Iterator;
import java.util.TreeSet;

import cn.itcast.p.bean.Person;
import cn.itcast.p5.comparator.ComparatorByName;

public class TreeSetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TreeSet ts = new TreeSet(new ComparatorByName());
		
		/*
		 * 以Person对象年龄进行从小到大的排序。
		 * 
		 */
		
		ts.add(new Person("zhangsan",28));
		ts.add(new Person("lisi",21));
		ts.add(new Person("zhouqi",29));
		ts.add(new Person("zhaoliu",25));
		ts.add(new Person("wangu",24));
		
		Iterator it = ts.iterator();
		
		while(it.hasNext()){
			Person p = (Person)it.next();
			
			System.out.println(p.getName()+":"+p.getAge());
		}
	
	}



	/**
	 * 
	 */
	public static void demo1() {
		TreeSet ts = new TreeSet();
		
		ts.add("abc");
		ts.add("zaa");
		ts.add("aa");
		ts.add("nba");
		ts.add("cba");
		
		Iterator it = ts.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
