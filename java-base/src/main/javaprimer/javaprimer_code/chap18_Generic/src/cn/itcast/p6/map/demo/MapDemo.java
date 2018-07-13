package org.alpha.javabase.javaprimer.javaprimer_code.chap18_Generic.src.cn.itcast.p6.map.demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo {

	public static void main(String[] args) {
		
		Map<Integer,String> map = new HashMap<Integer,String>();
		method_2(map);
	}
	
	public static void method_2(Map<Integer,String> map){
		
		map.put(8,"zhaoliu");
		map.put(2,"zhaoliu");
		map.put(7,"xiaoqiang");
		map.put(6,"wangcai");
		
		
		Collection<String> values = map.values();
		
		Iterator<String> it2 = values.iterator();
		while(it2.hasNext()){
			System.out.println(it2.next());
		}
		
		
		
		/*
		 * ͨ��Mapת��set�Ϳ��Ե�����
		 * �ҵ�����һ��������entrySet��
		 * �÷���������ֵ��ӳ���ϵ��Ϊ����洢����Set�����У������ӳ���ϵ�����;���Map.Entry����(���֤)
		 * 
		 * 
		 */
		Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
		
		Iterator<Map.Entry<Integer, String>> it = entrySet.iterator();
		
		while(it.hasNext()){
			Map.Entry<Integer, String> me = it.next();
			Integer key = me.getKey();
			String value = me.getValue();
			System.out.println(key+"::::"+value);
			
		}
		
		
		
		
		
		//ȡ��map�е�����Ԫ�ء�
		//ԭ��ͨ��keySet������ȡmap�����еļ����ڵ�Set���ϣ���ͨ��Set�ĵ�������ȡ��ÿһ������
		//�ڶ�ÿһ����ͨ��map���ϵ�get������ȡ���Ӧ��ֵ���ɡ�
		/*
		Set<Integer> keySet = map.keySet();
		Iterator<Integer> it = keySet.iterator();
		
		while(it.hasNext()){
			Integer key = it.next();
			String value = map.get(key);
			System.out.println(key+":"+value);
			
		}
		*/
		
		
		
	}
	
	
	
	
	
	
	public static void method(Map<Integer,String> map){//ѧ�ź�����
		
		
		// ���Ԫ�ء�
		System.out.println(map.put(8, "wangcai"));//null
		System.out.println(map.put(8, "xiaoqiang"));//wangcai ����ͬ����ֵ�Ḳ�ǡ�
		map.put(2,"zhangsan");
		map.put(7,"zhaoliu");
		
		
		//ɾ����
//		System.out.println("remove:"+map.remove(2));
		
		//�жϡ�
//		System.out.println("containskey:"+map.containsKey(7));
		
		//��ȡ�� 
		System.out.println("get:"+map.get(6));
		
		
		System.out.println(map);
		
		Outer.Inner.show();
	}
	
}

interface MyMap{
	public static interface MyEntry{//�ڲ��ӿ�
		void get();
	}
}

class MyDemo implements MyMap.MyEntry{
	public void get(){}
}

class Outer{
	static class Inner{
		static void show(){}
	}
}





