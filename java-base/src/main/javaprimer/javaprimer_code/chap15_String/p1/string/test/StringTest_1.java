package org.alpha.javabase.javaprimer.javaprimer_code.chap15_String.p1.string.test;

/*
 * 1������һ���ַ������顣�����ֵ�˳����д�С���������
 * {"nba","abc","cba","zz","qq","haha"}
 * 
 * ˼·��
 * 1,���������򡣿�����ѡ��ð�ݶ��С�
 * 2,forǶ�׺ͱȽ��Լ���λ��
 * 3,���⣺��ǰ�ŵ����������Ƚ��õıȽ�������������������ַ�������
 *   �ַ���������ô�Ƚ��أ�ˬ�ˣ��������ṩ�������ַ�������ȽϵĹ��ܡ�
 * 
 * 
 */
public class StringTest_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String[] arr = { "nba", "abc", "cba", "zz", "qq", "haha" };

		printArray(arr);

		sortString(arr);

		printArray(arr);

	}

	public static void sortString(String[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {

				if(arr[i].compareTo(arr[j])>0)//�ַ����Ƚ���compareTo����
					swap(arr,i,j);
			}
		}
	}

	private static void swap(String[] arr, int i, int j) {
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void printArray(String[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			if (i != arr.length - 1)
				System.out.print(arr[i] + ", ");
			else
				System.out.println(arr[i] + "]");
		}
	}

}
