package org.alpha.javabase.javaprimer.javaprimer_code.chap20_Util_IO.src.cn.itcast.p2.io.filewriter;

import java.io.FileWriter;
import java.io.IOException;

//���󣺽�һЩ���ִ洢��Ӳ��һ���ļ��С�

public class FileWriterDemo {

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		//����һ���������ļ���д���ַ����ݵ��ַ����������
		/*
		 * ��Ȼ����һ���ļ���д���������ݣ���ô�ڴ�������ʱ���ͱ�����ȷ���ļ�(���ڴ洢���ݵ�Ŀ�ĵ�)��
		 * 
		 * ����ļ������ڣ�����Զ�������
		 * ����ļ����ڣ���ᱻ���ǡ�
		 * 
		 * ������캯���м���true������ʵ�ֶ��ļ�������д��
		 */
		FileWriter fw = new FileWriter("demo.txt",true);
		
		/*
		 * ����Writer�����е�write(string)������д�����ݡ� 
		 * 
		 * ��ʵ����д�뵽��ʱ�洢�������С�
		 * 
		 */
		fw.write("abcde"+LINE_SEPARATOR+"hahaha");
//		fw.write("xixi");
		
		/*
		 * ����ˢ�£�������ֱ��д��Ŀ�ĵ��С�
		 */
		
//		fw.flush();
		
		/*
		 * �ر������ر���Դ���ڹر�ǰ���ȵ���flushˢ�»����е����ݵ�Ŀ�ĵء�
		 */
		fw.close();
		
//		fw.write("haha");// java.io.IOException: Stream closed
		
		
		
	}

}
