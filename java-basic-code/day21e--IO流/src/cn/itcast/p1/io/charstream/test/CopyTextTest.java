package cn.itcast.p1.io.charstream.test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 需求：作业：将c盘的一个文本文件复制到d盘。
 * 
 * 思路：
 * 1，需要读取源，
 * 2，将读到的源数据写入到目的地。
 * 3，既然是操作文本数据，使用字符流。 
 * 
 */

public class CopyTextTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		//1,读取一个已有的文本文件，使用字符读取流和文件相关联。
		FileReader fr = new FileReader("IO流_2.txt");
		//2,创建一个目的，用于存储读到数据。
		FileWriter fw = new FileWriter("copytext_1.txt");
		//3,频繁的读写操作。
		int ch = 0;
		while((ch=fr.read())!=-1){
			fw.write(ch);
		}
		//4,关闭流资源。 
		
		fw.close();
		fr.close();
	}

}
