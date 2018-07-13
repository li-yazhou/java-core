package org.alpha.javabase.javaprimer.javaprimer_code.chap18_Generic.src.cn.itcast.p5.generic.advance.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.alpha.javabase.javaprimer.javaprimer_code.chap18_Generic.src.cn.itcast.p2.bean.Person;

public class GenericAdvanceDemo5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayList<Person> al1 = new ArrayList<Person>();
		
		al1.add(new Person("abc",30));
		al1.add(new Person("abc4",34));
		ArrayList<Person> al2 = new ArrayList<Person>();
		
		al2.add(new Person("abc22222",30));
		al2.add(new Person("abc42222222",34));
		
		
		ArrayList<String> al4 = new ArrayList<String>();
		al4.add("abcdeef");
		al4.add("abc");
		
		al1.containsAll(al4);
		
		
//		"abc".equals(new Person("ahahah",20));
		
		
		
		
	}
	public static void printCollection(Collection<?> al){
		Iterator<?> it = al.iterator();
		
		while(it.hasNext()){
			
			System.out.println(it.next().toString());
		}
	}
}

class MyCollection2<E>{
	public boolean containsAll(Collection<?> coll){
		
		
		return true;
	}
}
