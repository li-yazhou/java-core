package org.alpha.javabase.javaprimer.javaprimer_code.chap21_IO.src.cn.itcast.p1.io.charstream.test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * ������ҵ����c�̵�һ���ı��ļ����Ƶ�d�̡�
 * 
 * ˼·��
 * 1����Ҫ��ȡԴ��
 * 2����������Դ����д�뵽Ŀ�ĵء�
 * 3����Ȼ�ǲ����ı����ݣ�ʹ���ַ����� 
 * 
 */

public class CopyTextTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		//1,��ȡһ�����е��ı��ļ���ʹ���ַ���ȡ�����ļ��������
		FileReader fr = new FileReader("IO��_2.txt");
		//2,����һ��Ŀ�ģ����ڴ洢�������ݡ�
		FileWriter fw = new FileWriter("copytext_1.txt");
		//3,Ƶ���Ķ�д������
		int ch = 0;
		while((ch=fr.read())!=-1){
			fw.write(ch);
		}
		//4,�ر�����Դ�� 
		
		fw.close();
		fr.close();
	}

}
