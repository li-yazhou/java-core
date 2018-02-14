package cn.itcast.p4.news.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class ForEachDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * foreach语句：
		 * 格式：
		 * for(类型  变量   ：Collection集合|数组)
		 * {
		 * 		
		 * }
		 * 
		 * 传统for和高级for的区别？
		 * 传统for可以完成对语句执行很多次，因为可以定义控制循环的增量和条件。
		 * 
		 * 高级for是一种简化形式。
		 * 它必须有被遍历的目标。该目标要是数组，要么是Collection单列集合。
		 * 
		 * 对数数组的遍历如果仅仅是获取数组中的元素，可以使用高级for。
		 * 如果要对数组的角标进行操作建议使用传统for。 
		 *  
		 */
		
		List<String> list =new ArrayList<String>();
		
		list.add("abc1");
		list.add("abc2");
		list.add("abc3");
		
		for(String s : list){	//简化书写。		
			System.out.println(s);			
		}
		
		
		int[] arr = {3,1,5,7,4};
		
		for(int i : arr){
			System.out.println(i);
		}
		
		
		//可以使用高级for遍历map集合吗？不能直接用，但是可以将map转成单列的set，就可以用了。
		Map<Integer,String> map = new HashMap<Integer,String>();
		
		map.put(3,"zhagsan");
		map.put(1,"wangyi");
		map.put(7,"wagnwu");
		map.put(4,"zhagsansan");
		
		
		for(Integer key : map.keySet()){
			String value = map.get(key);
			System.out.println(key+"::"+value);
		}
		
		for(Map.Entry<Integer,String> me : map.entrySet()){
			Integer key = me.getKey();
			String value = me.getValue();
			
			System.out.println(key+":"+value);
		}
		
		
//		Iterator<String> it = list.iterator();	
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
		
		
	}

}
