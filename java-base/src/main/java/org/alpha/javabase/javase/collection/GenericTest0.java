package org.alpha.javabase.javase.collection;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * 泛型的好处：
 * 	1.编译时期的类型检查
 *  2.省去强制类型转化，编程更加简洁
 *  
 * @author Administrator
 *
 */
public class GenericTest0 {
	
	
	
	@Test
	public void test_GenericMethod(){
		Collection<String> coll = new ArrayList<String>();
		addElement(coll, "abc");
		System.out.println(coll);
		
		// List<?> wildCardList = new ArrayList<Integer>();
		// wildCardList.add(123);
	}
	
	
	/*
	private <T extends Number> T add(T a, T b){
		double retval = (double)a + (double)b;
		return (T)retval;
	}
	*/
	
	
	private <T> void addElement(Collection<T> coll, T obj){
		coll.add(obj);
	}
	
	@Test
	public void test_GenericT(){
		int retval = (int)add(1,2);
		System.out.println(retval);
	}
	
	private double add(double first, double second){
		double result = first + second;
		return result;
	}
	@Test
	public void test_MapGeneric(){
		// Map<Character, Integer> map = new TreeMap<Character, Integer>();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char ch = 'a';
		int value = 65;
		for(int i = 0; i < 26; i++){
			map.put(ch++, value++);
		}
		//System.out.println(map);
		for(Iterator<Character> iter = map.keySet().iterator(); iter.hasNext();){
			char key = iter.next();
			int val = map.get(key);
			System.out.println(key + "-" + val);
		}
		
		System.out.println("===============================");
		for(Map.Entry<Character, Integer> entry: map.entrySet()){
			char key = entry.getKey();
			int val = entry.getValue();
			System.out.println(key +" :: "+ val);
		}
		
	}
	
	@SuppressWarnings("unused")
	@Test
	public void test_wildcard(){
		List<?> list = new ArrayList<Integer>();
		list = new ArrayList<String>();
		
		List<Double> tmpList = new ArrayList<Double>();
		tmpList.add(new Double("123.4"));
		List<? extends Number> numList = tmpList;
		// numList.add(new Double("123"));
		Number retval = numList.get(0);
		System.out.println(retval);
		
		List<? super String> strList = new ArrayList<Object>();
		strList.size();
	}
	
	@Test
	public void test_GenericType() throws Exception{
		List<String> strList = new ArrayList<String>();
		strList.add("abc");
		
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(123);
		
		System.out.println(strList.getClass() == intList.getClass());
		// return true
		
		intList.getClass().getMethod("add", Object.class).invoke(intList, "abc");
		System.out.println(intList);
	}

	@Test
	public void test_Generic() throws Exception{
		Constructor<String> constructor = String.class.getConstructor(StringBuffer.class);
		// 有了泛型，此处不用再使用强制类型转换
		String str = constructor.newInstance(new StringBuffer("123"));
		System.out.println(str);
	}
}
