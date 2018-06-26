package cn.itcast.p4.io.charstream.mybuffer;

import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;

public class MyBufferedReaderDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("buf.txt");
		
		MyBufferedReader bufr = new MyBufferedReader(fr);
		
		String line = null;
		
		while((line=bufr.myReadLine())!=null){
			System.out.println(line);
		}
		
		bufr.myClose();
		
		
		Collections.reverseOrder();
		HashMap map = null;
		map.values();
		
		
	}

}
