package org.alpha.javabase.javaprimer.javaprimer_code.chap19_Collection.src.cn.itcast.p4.news.demo;

public class ParamterDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		int sum = add(4,5);
//		System.out.println("sum="+sum);
//		int sum1 = add(4,5,6);
//		System.out.println("sum1="+sum1);
		
		
//		int[] arr = {5,1,4,7,3};
//		int sum = add(arr);
//		System.out.println("sum="+sum);
//		int[] arr1 = {5,1,4,7,3,9,8,7,6};
//		int sum1 = add(arr1);
//		System.out.println("sum1="+sum1);
		
		int sum = newAdd(5,1,4,7,3);
		System.out.println("sum="+sum);
		int sum1 = newAdd(5,1,2,7,3,9,8,7,6);
		System.out.println("sum1="+sum1);
		
	}
	/*
	 * �����Ŀɱ������
	 * ��ʵ����һ�����飬���ǽ��յ��������Ԫ�ء�
	 * �Զ�����ЩԪ�ط�װ�����顣���˵����ߵ���д��
	 * 
	 * ע�⣺�ɱ�������ͣ����붨���ڲ����б�Ľ�β��
	 * 
	 */
	public static int newAdd(int a,int...  arr){
		
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
		}
		return sum;
		
//		System.out.println(arr);		
//		return 0;
	}
	
	public static int add(int[] arr){
		
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
		}
		return sum;
		
	}
	
	
	
	public static int add(int a,int b){
		return a+b;
	}
	
	public static int add(int a,int b,int c){
		return a+b+c;
	}

}
