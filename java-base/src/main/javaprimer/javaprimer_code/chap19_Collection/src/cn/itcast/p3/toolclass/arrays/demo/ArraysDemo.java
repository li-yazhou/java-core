package org.alpha.javabase.javaprimer.javaprimer_code.chap19_Collection.src.cn.itcast.p3.toolclass.arrays.demo;

import java.util.Arrays;
import java.util.List;


//����ת�ɼ��ϡ�
public class ArraysDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Arrays�����Ͽ�ܵĹ����ࡣ����ķ������Ǿ�̬�ġ�
		 * 
		 */
		
//		int[] arr = {3,1,5,6,3,6};		
//		System.out.println(Arrays.toString(arr));
		
		demo_2();
	}

	public static void demo_2() {
		
		/*
		 * ��������е�Ԫ���Ƕ�����ôת�ɼ���ʱ��ֱ�ӽ������е�Ԫ����Ϊ�����е�Ԫ�ؽ��м��ϴ洢��
		 * 
		 * ��������е�Ԫ���ǻ���������ֵ����ô�Ὣ��������Ϊ�����е�Ԫ�ؽ��д洢��
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
		 * �ص㣺List asList(����)������ת�ɼ��ϡ�
		 * 
		 * �ô�����ʵ����ʹ�ü��ϵķ������������е�Ԫ�ء�
		 * ע�⣺����ĳ����ǹ̶��ģ����Զ��ڼ��ϵ���ɾ�����ǲ�����ʹ�õ�
		 * ����ᷢ��UnsupportedOperationException
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
	
	//toString�ľ���ʵ�֡�
	public static String myToString(int[] a){
		int iMax = a.length - 1;
		if (iMax == -1)
	            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0;  ; i++) {//�м�ʡ�������жϣ������Ч�ʡ�
            b.append(a[i]);
	    if (i == iMax)
	    	return b.append(']').toString();
           b.append(", ");
        }
	}

}
