package org.alpha.javabase.javaprimer.javaprimer_code.chap24_IO.src.cn.itcast.io.p7.encode;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class EncodeDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		/*
		 * �ַ��� --> �ֽ����飺���롣
		 * �ֽ����� --> �ַ��������롣
		 * 
		 * ��ã�GBK:  -60 -29 -70 -61
		 * 
		 * ���: utf-8: -28 -67 -96 -27 -91 -67 
		 * 
		 * 
		 * ��������ˣ��ⲻ������
		 * �������ˣ�����ˣ��п����оȡ�
		 */
		
		String str = "лл";
		
		byte[] buf = str.getBytes("gbk");
		
		String s1 = new String(buf,"UTF-8");
		
		System.out.println("s1="+s1);
		
		
		byte[] buf2 = s1.getBytes("UTF-8");//��ȡԴ�ֽ�.
		
		printBytes(buf2);//-17 -65 -67 -17 -65 -67 -17 -65 -67 
					//-17 -65 -67 -17 -65 -67 -17 -65 -67 -17 -65 -67
					//-48 -69 -48 -69 
		String s2 = new String(buf2,"GBK");
		
		System.out.println("s2="+s2);
		
		
//		encodeDemo(str);
		
		
		
	}

	/**
	 * @param str
	 * @throws UnsupportedEncodingException
	 */
	public static void encodeDemo(String str)
			throws UnsupportedEncodingException {
		//���룻
		byte[] buf = str.getBytes("UTF-8");
		
//		printBytes(buf);
		
		//���룺
		String s1 = new String(buf,"UTF-8");
		
		System.out.println("s1="+s1);
	}

	private static void printBytes(byte[] buf) {
		for(byte b : buf){
			System.out.print(b +" ");
		}
	}

}
