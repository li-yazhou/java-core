package cn.itcast.io.p7.encode;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class LianTong {

	/**
	 * @param args
	 * @throws IOException 
	 */

	
	public static void main(String[] args) throws IOException {
		
		String str = "ÁªÍ¨";
		/*
		11000001
		10101010
		11001101
		10101000
		*/

		
		byte[] buf = str.getBytes("gbk");
		
		for(byte b :buf){
			System.out.println(Integer.toBinaryString(b&255));
		}
	}
	
}
