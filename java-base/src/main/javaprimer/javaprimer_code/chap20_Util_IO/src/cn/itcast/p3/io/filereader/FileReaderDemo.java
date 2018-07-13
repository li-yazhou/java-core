package org.alpha.javabase.javaprimer.javaprimer_code.chap20_Util_IO.src.cn.itcast.p3.io.filereader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//���󣺶�ȡһ���ı��ļ�������ȡ�����ַ���ӡ������̨.

public class FileReaderDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		
		//1,������ȡ�ַ����ݵ�������
		/*
		 * �ڴ�����ȡ������ʱ������Ҫ��ȷ����ȡ���ļ���һ��Ҫȷ�����ļ��Ǵ��ڵġ� 
		 * 
		 * ��һ����ȡ������һ���Ѵ����ļ��� 
		 */
		FileReader fr = new FileReader("demo.txt");
		
		int ch = 0;
		
		while((ch=fr.read())!=-1){
			System.out.println((char)ch);
		}
		
		/*
		//��Reader�е�read������ȡ�ַ���
		int ch = fr.read();
		System.out.println((char)ch);
		int ch1 = fr.read();
		System.out.println(ch1);
		int ch2 = fr.read();
		System.out.println(ch2);
		*/
		
		fr.close();
	}

}
