package cn.itcast.p5.generic.advance.demo;

import java.util.ArrayList;

import cn.itcast.p2.bean.Person;
import cn.itcast.p2.bean.Student;
import cn.itcast.p2.bean.Worker;

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
//		al1.addAll(al4);//错误，类型不匹配。
		
		al1.addAll(al2);
		al1.addAll(al3);
		
		System.out.println(al1.size());
		
		
//		printCollection(al2);
//		printCollection(al);
	}
	
	

}

/*
 * 一般在存储元素的时候都是用上限，因为这样取出都是按照上限类型来运算的。不会出现类型安全隐患。 
 * 
 */

class MyCollection<E>{
	public void add(E e){
	
	}
	public void addAll(MyCollection<? extends E> e){
		
	}
}
