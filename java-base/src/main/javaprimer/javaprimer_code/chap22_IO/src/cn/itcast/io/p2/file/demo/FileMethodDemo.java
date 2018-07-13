package org.alpha.javabase.javaprimer.javaprimer_code.chap22_IO.src.cn.itcast.io.p2.file.demo;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class FileMethodDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		
		/*
		 * File����ĳ���������
		 * 
		 * 1����ȡ��
		 * 		1.1 ��ȡ�ļ����ơ�
		 * 		1.2 ��ȡ�ļ�·����
		 * 		1.3 ��ȡ�ļ���С��
		 * 		1.4 ��ȡ�ļ��޸�ʱ�䡣
		 * 
		 * 2��������ɾ����
		 * 		
		 * 3���жϡ�
		 * 
		 * 4�� ������
		 * 		
		 */
//		getDemo();
//		createAndDeleteDemo();
//		isDemo();
//		renameToDemo();
		
//		listRootsDemo();
	}
	
	
	
	
	
	public static void listRootsDemo() {
		
		File file = new File("d:\\");
		
		System.out.println("getFreeSpace:"+file.getFreeSpace());
		System.out.println("getTotalSpace:"+file.getTotalSpace());
		System.out.println("getUsableSpace:"+file.getUsableSpace());
		
//		File[] files  = File.listRoots();		
//		for(File file : files){
//			System.out.println(file);
//		}
	}

	public static void renameToDemo() {
		
		File f1 = new File("c:\\9.mp3");
		
		File f2 = new File("d:\\aa.mp3");
		
		boolean b = f1.renameTo(f2);
		
		System.out.println("b="+b);
	}

	public static void isDemo() throws IOException{
		File f = new File("aaa");
		
//		f.mkdir();
		f.createNewFile();
		
//		boolean b = f.exists();		
//		System.out.println("b="+b);
		// ������ж��Ƿ���ڡ� 
		System.out.println(f.isFile());
		System.out.println(f.isDirectory());
		
		
	}
	
	
	
	
	public static void createAndDeleteDemo() throws IOException {
		
		File dir = new File("abc\\q\\e\\c\\z\\r\\w\\y\\f\\e\\g\\s");
		
//		boolean b = dir.mkdir();//make directory		
//		System.out.println("b="+b);
//		dir.mkdirs();//�����༶Ŀ¼
		System.out.println(dir.delete());
		
//		System.out.println(dir.delete());
		
		
//		�ļ��Ĵ�����ɾ����
//		File file = new File("file.txt");
		
		/*
		 * ���������һ��������ļ������ڣ��򴴽�������ļ����ڣ��򲻴����� 
		 * 
		 */
//		boolean b = file.createNewFile();		
//		System.out.println("b="+b);
		
//		boolean b = file.delete();
//		System.out.println("b="+b);
		
	}



	public static void getDemo(){
//		File file = new File("E:\\java0331\\day22e\\a.txt");
		File file = new File("a.txt");
		
		String name = file.getName();
		
		String absPath = file.getAbsolutePath();//����·����
		
		String path = file.getPath();
		
		long len = file.length();
		
		long time = file.lastModified();
		
		Date date = new Date(time);
		
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
		
		String str_time = dateFormat.format(date);
		
		
		System.out.println("parent:"+file.getParent());
		
		System.out.println("name:"+name);
		System.out.println("absPath:"+absPath);
		System.out.println("path:"+path);
		System.out.println("len:"+len);
		System.out.println("time:"+time);
		System.out.println("str_time:"+str_time);
		
	}

}
