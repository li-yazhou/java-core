package org.alpha.javabase.javaprimer.javaprimer_code.chap16_Jdk5_Collection.src.cn.itcast.p2.wrapper.test;

import java.util.Arrays;

/*
 * ��һ���ַ����е���ֵ���д�С���������
 * 
 * "20 78 9 -7 88 36 29"
 * 
 * ˼·��
 * 1�������Һ��졣������ֻ��int��
 * 2����λ�ȡ������ַ����е���Щ��Ҫ�������ֵ��
 * ��������ַ�������ʵ���ǿո�������ֵ���зָ��ġ�
 * ���Ծ��뵽���ַ���������и�����󴮱�ɶ��С����
 * 3����ֵ���ձ��С�ַ�������ô���һ��int���أ�
 * �ַ���-->�������� ����ʹ�ð�װ�ࡣ
 * 
 * 
 */

public class WrapperTest {

	private static final String SPACE_SEPARATOR = " ";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String numStr = "20 78 9 -7 88 36 29";
		
		System.out.println(numStr);
		numStr = sortStringNumber(numStr);
		System.out.println(numStr);
		
	}
	/**
	 * 
	 * @param numStr
	 * @return
	 */
	public static String sortStringNumber(String numStr) {
		
		//1,���ַ�������ַ������顣
		String[] str_arr = stringToArray(numStr);
		
		//2,���ַ���������int���顣
		
		int[] num_arr = toIntArray(str_arr);
		
		//3,��int��������
		mySortArray(num_arr);
		
		//4,��������int�������ַ�����
		
		String temp = arrayToString(num_arr);
		
		return temp;
	}

	public static String arrayToString(int[] num_arr) {
		
		StringBuilder sb = new StringBuilder();
		for(int x = 0; x<num_arr.length; x++){
			if(x!=num_arr.length-1)
				sb.append(num_arr[x]+SPACE_SEPARATOR);
			else
				sb.append(num_arr[x]);
		}
		
		return sb.toString();
	}

	public static void mySortArray(int[] num_arr) {
		
		Arrays.sort(num_arr);
	}

	public static int[] toIntArray(String[] str_arr) {
		
		int[] arr = new int[str_arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(str_arr[i]);
		}
		
		return arr;
	}

	/**
	 * @param numStr
	 */
	public static String[] stringToArray(String numStr) {
		String[] str_arr = numStr.split(SPACE_SEPARATOR);
		
		
		return str_arr;
	}

}
