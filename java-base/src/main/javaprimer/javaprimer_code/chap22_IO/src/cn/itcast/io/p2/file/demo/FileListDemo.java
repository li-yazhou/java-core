package org.alpha.javabase.javaprimer.javaprimer_code.chap22_IO.src.cn.itcast.io.p2.file.demo;

import java.io.File;

import cn.itcast.io.p2.filter.FilterByHidden;
import cn.itcast.io.p2.filter.SuffixFilter;

public class FileListDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		listDemo_2();
	}
	
	

	public static void listDemo_3() {
		
		File dir = new File("c:\\");
		
		File[] files = dir.listFiles(new FilterByHidden());
		
		for(File file : files){
			System.out.println(file);
		}
	}



	public static void listDemo_2() {
		
		File dir = new File("c:\\");
		
		String[] names = dir.list(new SuffixFilter(".txt"));
		
		for(String name : names){
			System.out.println(name);
		}
		
	}



	public static void listDemo() {
		File file = new File("c:\\");
		
		/*
		 * ��ȡ��ǰĿ¼�µ��ļ��Լ��ļ��е����ƣ����������ļ���
		 * ����list������File�����з�װ�ı�����Ŀ¼��
		 * ����ᷢ��NullPointerException
		 * ������ʵ�ϵͳ��Ŀ¼Ҳ�ᷢ����ָ���쳣��
		 * 
		 * ���Ŀ¼���ڵ���û�����ݣ��᷵��һ�����飬���ǳ���Ϊ0.
		 * 
		 */
		String[] names = file.list();
		System.out.println(names.length);
		
		for(String name : names){
			System.out.println(name);
		}
		
		
	}

}
