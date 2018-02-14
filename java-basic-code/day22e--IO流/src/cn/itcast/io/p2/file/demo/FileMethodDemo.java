package cn.itcast.io.p2.file.demo;

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
		 * File对象的常见方法。
		 * 
		 * 1，获取。
		 * 		1.1 获取文件名称。
		 * 		1.2 获取文件路径。
		 * 		1.3 获取文件大小。
		 * 		1.4 获取文件修改时间。
		 * 
		 * 2，创建与删除。
		 * 		
		 * 3，判断。
		 * 
		 * 4， 重命名
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
		// 最好先判断是否存在。 
		System.out.println(f.isFile());
		System.out.println(f.isDirectory());
		
		
	}
	
	
	
	
	public static void createAndDeleteDemo() throws IOException {
		
		File dir = new File("abc\\q\\e\\c\\z\\r\\w\\y\\f\\e\\g\\s");
		
//		boolean b = dir.mkdir();//make directory		
//		System.out.println("b="+b);
//		dir.mkdirs();//创建多级目录
		System.out.println(dir.delete());
		
//		System.out.println(dir.delete());
		
		
//		文件的创建和删除。
//		File file = new File("file.txt");
		
		/*
		 * 和输出流不一样，如果文件不存在，则创建，如果文件存在，则不创建。 
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
		
		String absPath = file.getAbsolutePath();//绝对路径。
		
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
