package cn.itcast.p7.hashmap.demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import cn.itcast.p2.bean.Student;

public class HashMapDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		/*
		 * 将学生对象和学生的归属地通过键与值存储到map集合中。
		 * 
		 */
		
		HashMap<Student,String> hm = new HashMap<Student,String>();

		
		hm.put(new Student("lisi",38),"北京");
		hm.put(new Student("zhaoliu",24),"上海");
		hm.put(new Student("xiaoqiang",31),"沈阳");
		hm.put(new Student("wangcai",28),"大连");
		hm.put(new Student("zhaoliu",24),"铁岭");
		
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
