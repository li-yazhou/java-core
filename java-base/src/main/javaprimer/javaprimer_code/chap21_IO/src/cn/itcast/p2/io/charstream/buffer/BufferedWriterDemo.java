package org.alpha.javabase.javaprimer.javaprimer_code.chap21_IO.src.cn.itcast.p2.io.charstream.buffer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo {

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		FileWriter fw = new FileWriter("buf.txt");
		
		//Ϊ�����д���Ч�ʡ�ʹ�����ַ����Ļ�������
		//������һ���ַ�д�����Ļ��������󣬲���ָ��Ҫ������������������
		BufferedWriter bufw = new BufferedWriter(fw);
		
		//ʹ�û�������д�뷽����������д�뵽�������С�
//		bufw.write("abcdefq"+LINE_SEPARATOR+"hahahha");
//		bufw.write("xixiixii");
//		bufw.newLine();
//		bufw.write("heheheheh");
		
		for(int x=1; x<=4; x++){
			bufw.write("abcdef"+x);
			bufw.newLine();
			bufw.flush();
		}
		
		
		//ʹ�û�������ˢ�·���������ˢĿ�ĵ��С�
//		bufw.flush();
		
		
		//�رջ���������ʵ�رյľ��Ǳ������������
		bufw.close();
		
//		fw.write("hehe");
		
//		fw.close();
	}

}

