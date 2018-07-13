package org.alpha.javabase.javaprimer.javaprimer_code.chap18_Generic.src.cn.itcast.p5.generic.advance.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.alpha.javabase.javaprimer.javaprimer_code.chap18_Generic.src.cn.itcast.p2.bean.Person;
import org.alpha.javabase.javaprimer.javaprimer_code.chap18_Generic.src.cn.itcast.p2.bean.Student;

public class GenericAdvanceDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayList<Person> al = new ArrayList<Person>();
		
		al.add(new Person("abc",30));
		al.add(new Person("abc4",34));
		
		ArrayList<Student> al2 = new ArrayList<Student>();
		
		al2.add(new Student("stu1",11));
		al2.add(new Student("stu2",22));
		ArrayList<String> al3 = new ArrayList<String>();
		
		al3.add("stu3331");
		al3.add("stu33332");
		
		printCollection(al2);
		printCollection(al);
	}

	/**
	 * ��������ӡ������Ԫ�ء�
	 * 
	 * ���Զ����ͽ����޶���
	 * ? extends E:����E���ͻ���E�������Ͷ������ޣ�
	 * 
	 * ? super E ������E���ͻ���E�ĸ����͡����ޣ�
	 * @param al
	 */
	/*public static void printCollection(Collection<? extends Person> al) {//Collection<Dog> al = new ArrayList<Dog>()
		Iterator<? extends Person> it = al.iterator();
		
		while(it.hasNext()){
//			T str = it.next();
//			System.out.println(str);
//			System.out.println(it.next().toString());
			Person p = it.next();
			
			System.out.println(p.getName()+":"+p.getAge());
		}
		
	}*/
	
	public static void printCollection(Collection<? super Student> al){
		Iterator<? super Student> it = al.iterator();
		
		while(it.hasNext()){
			
			System.out.println(it.next());
		}
	}

}
