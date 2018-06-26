package cn.itcast.p5.generic.advance.demo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import cn.itcast.p2.bean.Person;
import cn.itcast.p2.bean.Student;
import cn.itcast.p2.bean.Worker;

public class GenericAdvanceDemo4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TreeSet<Person> al1 = new TreeSet<Person>(new CompByName());
		
		al1.add(new Person("abc4",34));
		al1.add(new Person("abc1",30));
		al1.add(new Person("abc2",38));
		
		TreeSet<Student> al2 = new TreeSet<Student>(new CompByName());
		
		al2.add(new Student("stu1",11));
		al2.add(new Student("stu7",20));
		al2.add(new Student("stu2",22));
		
		
		TreeSet<Worker> al3 = new TreeSet<Worker>();
		
		al3.add(new Worker("stu1",11));
		al3.add(new Worker("stu2",22));
		
		TreeSet<String> al4 = new TreeSet<String>();
		al4.add("abcdeef");
//		al1.addAll(al4);//错误，类型不匹配。
		
//		al1.addAll(al2);
//		al1.addAll(al3);
		
//		System.out.println(al1.size());
		
		
		
		Iterator<Student> it = al2.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}
}


/*
 * class TreeSet<Worker>
 * {
 * 		Tree(Comparator<? super Worker> comp);
 * }
 * 
 * 什么时候用下限呢？通常对集合中的元素进行取出操作时，可以是用下限。
 * 
 */

class CompByName implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		
		int temp = o1.getName().compareTo(o2.getName());
		
		return temp==0? o1.getAge()-o2.getAge():temp;
	}
	
}

class CompByStuName implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		
		int temp = o1.getName().compareTo(o2.getName());
		
		return temp==0? o1.getAge()-o2.getAge():temp;
	}
	
}

class CompByWorkerName implements Comparator<Worker>{

	@Override
	public int compare(Worker o1, Worker o2) {
		
		int temp = o1.getName().compareTo(o2.getName());
		
		return temp==0? o1.getAge()-o2.getAge():temp;
	}
	
}






