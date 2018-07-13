package org.alpha.javabase.javaprimer.javaprimer_code.chap22_IO.src.cn.itcast.io.p1.transstream.demo;

import java.io.IOException;
import java.io.InputStream;



/*
 * ��ȡһ������¼������ݣ�����ӡ�ڿ���̨�ϡ�
 * 
 * ���̱������һ����׼�������豸��
 * ����java���ԣ��������������豸���ж�Ӧ�Ķ���
 * 
 * 
 */
public class ReadKey {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

//		readKey();
//		System.out.println((int)'\r');
//		System.out.println((int)'\n');
		
		readKey2();
		
	}

	public static void readKey2() throws IOException {
		
		/*
		 * ��ȡ�û�����¼������ݣ�
		 * �������ݱ�ɴ�д��ʾ�ڿ���̨�ϣ�
		 * ����û��������over����������¼�롣
		 * 
		 * ˼·��
		 * 1����Ϊ����¼��ֻ��ȡһ���ֽڣ�Ҫ�ж��Ƿ���over����Ҫ����ȡ�����ֽ�ƴ���ַ�����
		 * 2���Ǿ���Ҫһ��������StringBuilder.
		 * 3�����û��س�֮ǰ��¼������ݱ���ַ����жϼ��ɡ� 
		 * 
		 */
		
		//1������������
		StringBuilder sb = new StringBuilder();
		
		//2����ȡ���̶�ȡ����		
		InputStream in = System.in;
		
		//3�����������¼��ȡ�����ֽڣ���ѭ����ȡ�� 		
		int ch = 0;
		
		while((ch=in.read())!=-1){
			
//			�ڴ洢֮ǰ��Ҫ�ж��Ƿ��ǻ��б�� ,��Ϊ���б�ǲ��洢�� 
			if(ch=='\r')
				continue;
			if(ch=='\n'){
				String temp = sb.toString();
				if("over".equals(temp))
					break;
				System.out.println(temp.toUpperCase());
				sb.delete(0, sb.length());
			}
			else
			//����ȡ�����ֽڴ洢��StringBuilder�С�
			sb.append((char)ch);
			
//			System.out.println(ch);
		}
		
	}

	public static void readKey() throws IOException {
		
		InputStream in = System.in;
		
		int ch = in.read();//����ʽ������		
		System.out.println(ch);
		int ch1 = in.read();//����ʽ������		
		System.out.println(ch1);
		int ch2 = in.read();//����ʽ������		
		System.out.println(ch2);
		
//		in.close();
		
//		InputStream in2 = System.in;
//		int ch3 = in2.read();
		
	}
	

}
