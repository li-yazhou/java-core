package cn.itcast.io.p6.bytestream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayStreamDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {

		ByteArrayInputStream bis = new ByteArrayInputStream("abcedf".getBytes());
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		int ch = 0;
		
		while((ch=bis.read())!=-1){
			bos.write(ch);
		}
		
		System.out.println(bos.toString());
	}

}
