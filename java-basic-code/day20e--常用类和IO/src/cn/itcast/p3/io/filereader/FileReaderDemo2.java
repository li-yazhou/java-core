package cn.itcast.p3.io.filereader;

import java.io.FileReader;
import java.io.IOException;

//需求：读取一个文本文件。将读取到的字符打印到控制台.

public class FileReaderDemo2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("demo.txt");
		
		/*
		 * 使用read(char[])读取文本文件数据。
		 *  
		 * 先创建字符数组。
		 */
		char[] buf = new char[1024];
		
		int len = 0;
		
		while((len=fr.read(buf))!=-1){
			System.out.println(new String(buf,0,len));
		}
		
		/*
		int num = fr.read(buf);//将读取到的字符存储到数组中。
		System.out.println(num+":"+new String(buf,0,num));
		int num1 = fr.read(buf);//将读取到的字符存储到数组中。
		System.out.println(num1+":"+new String(buf,0,num1));
		int num2 = fr.read(buf);//将读取到的字符存储到数组中。
		System.out.println(num2+":"+new String(buf));
		*/
		
		
		
		
		fr.close();
	}

}
