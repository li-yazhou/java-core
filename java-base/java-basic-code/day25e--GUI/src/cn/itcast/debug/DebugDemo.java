package cn.itcast.debug;

import java.util.ArrayList;
import java.util.Arrays;

public class DebugDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayList<String> al = new ArrayList<String>();
		al.add("abc");
		
		System.out.println(al.get(0));
		
		System.out.println("hahahh");
	}

	/**
	 * 
	 */
	public static void arraydemo() {
		int[] arr = {4,1,5,17,2,9};
		
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i]>arr[j]){
					swap(arr,i,j);
				}
			}
			
		}
		
		System.out.println(Arrays.toString(arr));
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
