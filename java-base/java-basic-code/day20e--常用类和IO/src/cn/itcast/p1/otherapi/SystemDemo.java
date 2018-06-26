package cn.itcast.p1.otherapi;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class SystemDemo {

	
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		
		
		
		/*
		 * System:类中的方法和属性都是静态的。
		 * 
		 * 
		 * 常见方法：
		 * long currentTimeMillis();获取当前时间的毫秒值。 
		 * 
		 */
		
//		long l1 = 1335664696656l;//System.currentTimeMillis();
//		System.out.println(l1/1000/60/60/24);//1335664696656
//		code..
//		long l2 = System.currentTimeMillis();
//		System.out.println(l2-l1);

		
		System.out.println("hello-"+LINE_SEPARATOR+" world");
//		demo_1();
		//给系统设置一些属性信息。这些信息是全局，其他程序都可以使用。 
//		System.setProperty("myclasspath", "c:\myclass");
		
	}
	
	public static void demo_1(){
		//获取系统的属性信息，并存储到了Properties集合中。 
		/*
		 * properties集合中存储都是String类型的键和值。
		 * 最好使用它自己的存储和取出的方法来完成元素的操作。
		 */
		Properties prop = System.getProperties();
		
		Set<String> nameSet = prop.stringPropertyNames();
		
		for(String name : nameSet){
			String value = prop.getProperty(name);
			
			System.out.println(name+"::"+value);
		}
		
	}
	
}












