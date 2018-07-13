package org.alpha.javabase.javaprimer.javaprimer_code.chap19_Collection.src.cn.itcast.p4.news.demo;

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
		 * foreach��䣺
		 * ��ʽ��
		 * for(����  ����   ��Collection����|����)
		 * {
		 * 		
		 * }
		 * 
		 * ��ͳfor�͸߼�for������
		 * ��ͳfor������ɶ����ִ�кܶ�Σ���Ϊ���Զ������ѭ����������������
		 * 
		 * �߼�for��һ�ּ���ʽ��
		 * �������б�������Ŀ�ꡣ��Ŀ��Ҫ�����飬Ҫô��Collection���м��ϡ�
		 * 
		 * ��������ı�����������ǻ�ȡ�����е�Ԫ�أ�����ʹ�ø߼�for��
		 * ���Ҫ������ĽǱ���в�������ʹ�ô�ͳfor�� 
		 *  
		 */
		
		List<String> list =new ArrayList<String>();
		
		list.add("abc1");
		list.add("abc2");
		list.add("abc3");
		
		for(String s : list){	//����д��		
			System.out.println(s);			
		}
		
		
		int[] arr = {3,1,5,7,4};
		
		for(int i : arr){
			System.out.println(i);
		}
		
		
		//����ʹ�ø߼�for����map�����𣿲���ֱ���ã����ǿ��Խ�mapת�ɵ��е�set���Ϳ������ˡ�
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
