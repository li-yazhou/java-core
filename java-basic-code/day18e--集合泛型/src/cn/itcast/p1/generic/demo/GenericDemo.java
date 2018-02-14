package cn.itcast.p1.generic.demo;

import java.util.ArrayList;
import java.util.Iterator;

public class GenericDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		int[] arr = new int[4];
//		arr[0] = 3.0;
		
		
		ArrayList<String> al = new ArrayList<String>();
		
		al.add("abc");//public boolean add(Object obj)
		al.add("hahah");
//		al.add(4);//al.add(new Integer(4));
		
		Iterator<String> it = al.iterator();
		while(it.hasNext()){
			
			String str = it.next();
			System.out.println(str);
		}
	}

}



