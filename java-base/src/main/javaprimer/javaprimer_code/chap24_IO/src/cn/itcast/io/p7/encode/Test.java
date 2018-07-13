package org.alpha.javabase.javaprimer.javaprimer_code.chap24_IO.src.cn.itcast.io.p7.encode;

import java.io.IOException;


public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		String str = "ab���cdлл";
//		str = "ab�i�icd�i�i";
		
//		int len = str.getBytes("gbk").length;		
//		for(int x=0; x<len; x++){
//			System.out.println("��ȡ"+(x+1)+"���ֽڽ���ǣ�"+cutStringByByte(str, x+1));
//		}
		
		int len = str.getBytes("utf-8").length;		
		for(int x=0; x<len; x++){
			System.out.println("��ȡ"+(x+1)+"���ֽڽ���ǣ�"+cutStringByU8Byte(str, x+1));
		}
		
		
		
//		String str = "�i";
//		byte[] buf = str.getBytes("gbk");
//		for(byte b : buf){
//			System.out.println(b);//-84  105 
//		}
			
	}
	
	/*
	  	��java�У��ַ�����abcd�����ַ�����ab��á��ĳ�����һ���������ĸ��ַ���
		����Ӧ���ֽ�����ͬ��һ������ռ�����ֽڡ�
		����һ�����������������ֽ�����ȡ�Ӵ���
		�磺���ڡ�ab��á������ȡ�����ֽڣ���ô�Ӵ�����ab�롰�㡱�ֵİ����
		��ô�����Ҫ���������ȥ�ĸ��ֽھ��ǡ�ab�㡱��ȡ����ֽڻ��ǡ�ab�㡱.
		
		
	 */
	
	public static String cutStringByU8Byte(String str, int len) throws IOException {
		
		byte[] buf = str.getBytes("utf-8");
		
		int count = 0;
		for(int x=len-1; x>=0; x--){
			if(buf[x]<0)
				count++;
			else
				break;
		}
		
		if(count%3==0)
			return new String(buf,0,len,"utf-8");
		else if(count%3==1)
			return new String(buf,0,len-1,"utf-8");
		else 
			return new String(buf,0,len-2,"utf-8");
		
	}

	public static String cutStringByByte(String str,int len) throws IOException{
		
		byte[] buf = str.getBytes("gbk");
		
		int count = 0;
		for(int x=len-1; x>=0; x--){
			if(buf[x]<0)
				count++;
			else
				break;
		}
		
		if(count%2==0)
			return new String(buf,0,len,"gbk");
		else
			return new String(buf,0,len-1,"gbk");
	}
}










