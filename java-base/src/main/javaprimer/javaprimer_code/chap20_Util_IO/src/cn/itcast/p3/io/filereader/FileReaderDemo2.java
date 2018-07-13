package org.alpha.javabase.javaprimer.javaprimer_code.chap20_Util_IO.src.cn.itcast.p3.io.filereader;

import java.io.FileReader;
import java.io.IOException;

//���󣺶�ȡһ���ı��ļ�������ȡ�����ַ���ӡ������̨.

public class FileReaderDemo2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("demo.txt");
		
		/*
		 * ʹ��read(char[])��ȡ�ı��ļ����ݡ�
		 *  
		 * �ȴ����ַ����顣
		 */
		char[] buf = new char[1024];
		
		int len = 0;
		
		while((len=fr.read(buf))!=-1){
			System.out.println(new String(buf,0,len));
		}
		
		/*
		int num = fr.read(buf);//����ȡ�����ַ��洢�������С�
		System.out.println(num+":"+new String(buf,0,num));
		int num1 = fr.read(buf);//����ȡ�����ַ��洢�������С�
		System.out.println(num1+":"+new String(buf,0,num1));
		int num2 = fr.read(buf);//����ȡ�����ַ��洢�������С�
		System.out.println(num2+":"+new String(buf));
		*/
		
		
		
		
		fr.close();
	}

}
