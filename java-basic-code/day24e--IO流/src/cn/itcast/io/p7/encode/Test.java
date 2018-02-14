package cn.itcast.io.p7.encode;

import java.io.IOException;


public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		String str = "ab你好cd谢谢";
//		str = "ab琲琲cd琲琲";
		
//		int len = str.getBytes("gbk").length;		
//		for(int x=0; x<len; x++){
//			System.out.println("截取"+(x+1)+"个字节结果是："+cutStringByByte(str, x+1));
//		}
		
		int len = str.getBytes("utf-8").length;		
		for(int x=0; x<len; x++){
			System.out.println("截取"+(x+1)+"个字节结果是："+cutStringByU8Byte(str, x+1));
		}
		
		
		
//		String str = "琲";
//		byte[] buf = str.getBytes("gbk");
//		for(byte b : buf){
//			System.out.println(b);//-84  105 
//		}
			
	}
	
	/*
	  	在java中，字符串“abcd”与字符串“ab你好”的长度是一样，都是四个字符。
		但对应的字节数不同，一个汉字占两个字节。
		定义一个方法，按照最大的字节数来取子串。
		如：对于“ab你好”，如果取三个字节，那么子串就是ab与“你”字的半个，
		那么半个就要舍弃。如果去四个字节就是“ab你”，取五个字节还是“ab你”.
		
		
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










