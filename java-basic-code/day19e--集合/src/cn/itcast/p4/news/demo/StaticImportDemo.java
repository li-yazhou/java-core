package cn.itcast.p4.news.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Collections.*;//静态导入，其实到入的是类中的静态成员。
//import static java.util.Collections.max;//静态导入，其实到入的是类中的静态成员。

import static java.lang.System.*;

public class StaticImportDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		
		list.add("abc3");
		list.add("abc7");
		list.add("abc1");
		
		out.println(list);
		
		sort(list);
		
		System.out.println(list);
		
		
		String max = max(list);
		System.out.println("max="+max);
		
	}

}
