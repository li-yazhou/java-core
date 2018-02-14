package cn.itcast.p3.toolclass.arrays.demo;

import java.util.Arrays;
import java.util.List;


//数组转成集合。
public class ArraysDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Arrays：集合框架的工具类。里面的方法都是静态的。
		 * 
		 */
		
//		int[] arr = {3,1,5,6,3,6};		
//		System.out.println(Arrays.toString(arr));
		
		demo_2();
	}

	public static void demo_2() {
		
		/*
		 * 如果数组中的元素是对象，那么转成集合时，直接将数组中的元素作为集合中的元素进行集合存储。
		 * 
		 * 如果数组中的元素是基本类型数值，那么会将该数组作为集合中的元素进行存储。
		 * 
		 */
		int[] arr = {31,11,51,61};
		
		List<int[]> list = Arrays.asList(arr);
		
		System.out.println(list);
	}

	/**
	 * 
	 */
	public static void demo_1() {
		/*
		 * 重点：List asList(数组)将数组转成集合。
		 * 
		 * 好处：其实可以使用集合的方法操作数组中的元素。
		 * 注意：数组的长度是固定的，所以对于集合的增删方法是不可以使用的
		 * 否则会发生UnsupportedOperationException
		 * 
		 * 
		 */
		String[] arr = {"abc","haha","xixi"};
		
		boolean b = myContains(arr, "xixi");
		System.out.println("contains:"+b);
		
		List<String> list = Arrays.asList(arr);
		boolean b1 = list.contains("xixi");
		System.out.println("list contaisn:="+b1);
//		list.add("hiahia");//UnsupportedOperationException
		
		System.out.println(list);
	}
	
	public static boolean myContains(String[] arr,String key){
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].equals(key))
				return true;
		}
		return false;
	}
	
	//toString的经典实现。
	public static String myToString(int[] a){
		int iMax = a.length - 1;
		if (iMax == -1)
	            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0;  ; i++) {//中间省略条件判断，提高了效率。
            b.append(a[i]);
	    if (i == iMax)
	    	return b.append(']').toString();
           b.append(", ");
        }
	}

}
