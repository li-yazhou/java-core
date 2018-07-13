package org.alpha.javabase.javaprimer.javaprimer_code.chap23_IO.src.cn.itcast.io.p4.print.demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		/*
		 * PrintStream:
		 * 1,�ṩ�˴�ӡ�������ԶԶ�����������ֵ���д�ӡ�����������ݵı�ʾ��ʽ�� 
		 * 2��������IOException.
		 * 
		 * ���캯���������������͵�ֵ��
		 * 1���ַ���·����
		 * 2��File����
		 * 3���ֽ��������
		 */
		
		PrintStream out = new PrintStream("print.txt");
		
//		int by = read();
//		write(by);
		
//		out.write(610);//ֻд���8λ��
		
//		out.print(97);//��97�ȱ���ַ�����ԭ�������ݴ�ӡ��Ŀ�ĵء� 
		
		out.close();
		
		
	}

}
