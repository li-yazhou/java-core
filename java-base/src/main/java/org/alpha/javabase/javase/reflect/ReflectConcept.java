package org.alpha.javabase.javase.reflect;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;

import org.junit.Test;

public class ReflectConcept {	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test_reflectDemo() throws Exception{
		InputStream ips = new FileInputStream("config.properties");
		Properties property = new Properties();
		property.load(ips);
		ips.close();
		
		String className = property.getProperty("className");
		Collection coll = (Collection)Class.forName(className).newInstance();
		coll.add(new ReflectPoint(1,2));
		coll.add(new ReflectPoint(1,2));
		coll.add(new ReflectPoint(2,2));
		coll.add(new ReflectPoint(3,2));
		System.out.println(coll.size());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void test_HashCode() throws Exception{
		@SuppressWarnings("rawtypes")
		Collection coll = new HashSet();
		ReflectPoint rp = new ReflectPoint(1,2);
		coll.add(rp);
		coll.add(new ReflectPoint(1,2));
		coll.add(new ReflectPoint(2,2));
		coll.add(new ReflectPoint(3,2));
		
		//rp.y = 3;
		System.out.println(coll.contains(rp));
		
		System.out.println(coll.size());
		System.out.println(coll.remove(rp));
		System.out.println(coll.size());
	}

	@SuppressWarnings("unused")
	@Test
	public void test_Array() throws Exception{
		Object obj_01 = new int[3];
		// Object[] obj_02 = new int[5];
		Object[] obj_03 = new int[2][5];
		
		Object obj_04 = new int[]{1,2,3};
		
		printObject(obj_04);
		printObject("src/test");
	}
	
	/**
	 * 打印对象，或者数组
	 * @param obj
	 */
	private void printObject(Object obj) {
		@SuppressWarnings("rawtypes")
		Class clazz = obj.getClass();
		if(clazz.isArray()){
			int len = Array.getLength(obj);
			for(int i = 0; i < len; i++){
				System.out.print(Array.get(obj, i) + "\t");
			}
			System.out.println();
		}else{
			System.out.println(obj);
		}
	}


	@Test
	public void test_Method() throws Exception{
		Method method = String.class.getMethod("charAt",int.class);
		char ch = (char) method.invoke("abc", 1);
		System.out.println(ch);
	}

	
	/**
	 * 暴力反射字段
	 * @throws Exception
	 */
	@Test 
	public void test_Filed() throws Exception{
		ReflectPoint rp = new ReflectPoint(1,2);
		Field field = rp.getClass().getDeclaredField("x");
		field.setAccessible(true);
		int tmp = (int) field.get(rp);
		System.out.println(tmp);
	}
	
	
	/**
	 * 一个程序可以修改很多数据，更加通用
	 * @throws Exception
	 */
	@Test 
	public void test_changeStringValue() throws Exception{
		ReflectPoint rp = new ReflectPoint(1,2);
		for(Field field : rp.getClass().getDeclaredFields()){
			if(field.getType() == String.class){
				field.setAccessible(true);
				String oldValue = (String)field.get(rp);
				String newValue = oldValue.replace("b", "X");
				field.set(rp, newValue);
			}
		}
		System.out.println(rp);
		
	}
	
	@Test
	public void test_Constructor() throws Exception{
		// new String(new StringBuffer("test"))
		Constructor<String> constructor = String.class.getConstructor(StringBuffer.class);
		// 此处必须强转，因为编译时期编译器无法知道newInstance的返回类型
		// 参数是"test"会出现运行时异常，上下两句参数类型必须完全一致
		String str = constructor.newInstance(/*"test"*/new StringBuffer("src/test"));
		System.out.println(str.charAt(2));
	}
	
	
	@Test
	public void test_01(){
		Class<Integer> clazz_01 = int.class;
		System.out.println(clazz_01);
		System.out.println(clazz_01.getName());
		System.out.println(clazz_01.isPrimitive());
		
		System.out.println("-----------");
		Class<Integer> clazz_02 = Integer.TYPE;
		System.out.println(clazz_02.getSimpleName());
	}
	
	
	
}
