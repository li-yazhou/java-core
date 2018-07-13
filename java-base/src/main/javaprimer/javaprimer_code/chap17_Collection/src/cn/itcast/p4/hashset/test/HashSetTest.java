package org.alpha.javabase.javaprimer.javaprimer_code.chap17_Collection.src.cn.itcast.p4.hashset.test;

import java.util.HashSet;
import java.util.Iterator;

import org.alpha.javabase.javaprimer.javaprimer_code.chap17_Collection.src.cn.itcast.p.bean.Person;


/*
 * ��hashSet�����д洢Person�������������������ͬ����Ϊͬһ���ˡ���Ϊ��ͬԪ�ء�
 */
public class HashSetTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		HashSet hs = new HashSet();
		
		/*
		 * HashSet�������ݽṹ�ǹ�ϣ�����Դ洢Ԫ�ص�ʱ��
		 * ʹ�õ�Ԫ�ص�hashCode������ȷ��λ�ã����λ����ͬ����ͨ��Ԫ�ص�equals��ȷ���Ƿ���ͬ��
		 * 
		 */
		
		hs.add(new Person("lisi4",24));
		hs.add(new Person("lisi7",27));
		hs.add(new Person("lisi1",21));
		hs.add(new Person("lisi9",29));
		hs.add(new Person("lisi7",27));
		
		
		Iterator it = hs.iterator();
		
		while(it.hasNext()){
			Person p = (Person)it.next();
			System.out.println(p);
//			System.out.println(p.getName()+"...."+p.getAge());
		}
	}

}
