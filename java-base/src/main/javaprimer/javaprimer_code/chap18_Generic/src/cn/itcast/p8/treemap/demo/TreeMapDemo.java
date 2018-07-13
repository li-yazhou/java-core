package org.alpha.javabase.javaprimer.javaprimer_code.chap18_Generic.src.cn.itcast.p8.treemap.demo;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.alpha.javabase.javaprimer.javaprimer_code.chap18_Generic.src.cn.itcast.p2.bean.Student;
import org.alpha.javabase.javaprimer.javaprimer_code.chap18_Generic.src.cn.itcast.p3.comparator.ComparatorByName;

public class TreeMapDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TreeMap<Student,String> tm = new TreeMap<Student,String>(new ComparatorByName());
		
		tm.put(new Student("lisi",38),"����");
		tm.put(new Student("zhaoliu",24),"�Ϻ�");
		tm.put(new Student("xiaoqiang",31),"����");
		tm.put(new Student("wangcai",28),"����");
		tm.put(new Student("zhaoliu",24),"����");
		
		
		Iterator<Map.Entry<Student, String>> it = tm.entrySet().iterator();
		
		while(it.hasNext()){
			Map.Entry<Student,String> me = it.next();
			Student key = me.getKey();
			String value = me.getValue();
			
			System.out.println(key.getName()+":"+key.getAge()+"---"+value);
		}
		
	}

}
