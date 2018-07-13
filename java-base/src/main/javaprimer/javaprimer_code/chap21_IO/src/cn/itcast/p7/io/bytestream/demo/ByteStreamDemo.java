package org.alpha.javabase.javaprimer.javaprimer_code.chap21_IO.src.cn.itcast.p7.io.bytestream.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		
		demo_read();
	}

	public static void demo_read() throws IOException {
		
		//1������һ����ȡ�����󡣺�ָ���ļ�������
		FileInputStream fis = new FileInputStream("bytedemo.txt");
		
//		System.out.println(fis.available());
//		byte[] buf = new byte[fis.available()];		
//		fis.read(buf);
//		System.out.println(new String(buf));
		
		
		//����ʹ�����ֶ�ȡ���ݵķ�ʽ
//		byte[] buf = new byte[1024];		
//		int len = 0;
//		
//		while((len=fis.read(buf))!=-1){
//			System.out.println(new String(buf,0,len));
//		}
		
		
//		int ch = 0;
//		while((ch=fis.read())!=-1){
//			System.out.println((char)ch);
//		}
		
		//һ�ζ�ȡһ���ֽڡ�
//		int ch = fis.read();		
//		System.out.println(ch);
		
		fis.close();
		
	}

	public static void demo_write() throws IOException {
		
		//1�������ֽ�������������ڲ����ļ�.
		FileOutputStream fos = new FileOutputStream("bytedemo.txt");
		
		//2,д���ݡ�ֱ��д�뵽��Ŀ�ĵ��С� 
		fos.write("abcdefg".getBytes());
		
//		fos.flush();
		fos.close();//�ر���Դ����Ҫ��ɡ� 
	}

}
