package org.alpha.javabase.javaprimer.javaprimer_code.chap18_Generic.src.cn.itcast.p7.hashmap.demo;

import java.util.HashMap;
import java.util.Iterator;

import org.alpha.javabase.javaprimer.javaprimer_code.chap18_Generic.src.cn.itcast.p2.bean.Student;

public class HashMapDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		/*
		 * ��ѧ�������ѧ���Ĺ�����ͨ������ֵ�洢��map�����С�
		 * 
		 */
		
		HashMap<Student,String> hm = new HashMap<Student,String>();

		
		hm.put(new Student("lisi",38),"����");
		hm.put(new Student("zhaoliu",24),"�Ϻ�");
		hm.put(new Student("xiaoqiang",31),"����");
		hm.put(new Student("wangcai",28),"����");
		hm.put(new Student("zhaoliu",24),"����");
		
//		Set<Student> keySet = hm.keySet();		
//		Iterator<Student> it = keySet.iterator();
		
		Iterator<Student> it = hm.keySet().iterator();
		
		while(it.hasNext()){
			Student key = it.next();
			String value = hm.get(key);
			System.out.println(key.getName()+":"+key.getAge()+"---"+value);
		}
		
		
	}

}
