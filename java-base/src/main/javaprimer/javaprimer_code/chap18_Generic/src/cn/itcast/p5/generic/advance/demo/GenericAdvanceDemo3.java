package org.alpha.javabase.javaprimer.javaprimer_code.chap18_Generic.src.cn.itcast.p5.generic.advance.demo;

import java.util.ArrayList;

import org.alpha.javabase.javaprimer.javaprimer_code.chap18_Generic.src.cn.itcast.p2.bean.Person;
import org.alpha.javabase.javaprimer.javaprimer_code.chap18_Generic.src.cn.itcast.p2.bean.Student;
import org.alpha.javabase.javaprimer.javaprimer_code.chap18_Generic.src.cn.itcast.p2.bean.Worker;

public class GenericAdvanceDemo3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayList<Person> al1 = new ArrayList<Person>();
		
		al1.add(new Person("abc",30));
		al1.add(new Person("abc4",34));
		
		ArrayList<Student> al2 = new ArrayList<Student>();
		
		al2.add(new Student("stu1",11));
		al2.add(new Student("stu2",22));
		
		
		ArrayList<Worker> al3 = new ArrayList<Worker>();
		
		al3.add(new Worker("stu1",11));
		al3.add(new Worker("stu2",22));
		
		ArrayList<String> al4 = new ArrayList<String>();
		al4.add("abcdeef");
//		al1.addAll(al4);//�������Ͳ�ƥ�䡣
		
		al1.addAll(al2);
		al1.addAll(al3);
		
		System.out.println(al1.size());
		
		
//		printCollection(al2);
//		printCollection(al);
	}
	
	

}

/*
 * һ���ڴ洢Ԫ�ص�ʱ���������ޣ���Ϊ����ȡ�����ǰ�����������������ġ�����������Ͱ�ȫ������ 
 * 
 */

class MyCollection<E>{
	public void add(E e){
	
	}
	public void addAll(MyCollection<? extends E> e){
		
	}
}
