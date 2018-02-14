package cn.itcast.p2.io.charstream.buffer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("buf.txt");
		
		BufferedReader bufr = new BufferedReader(fr);
		
		String line = null;
		
		while((line=bufr.readLine())!=null){
			System.out.println(line);
		}
		/*
		String line1 = bufr.readLine();
		System.out.println(line1);
		String line2 = bufr.readLine();
		System.out.println(line2);
		String line3 = bufr.readLine();
		System.out.println(line3);
		String line4 = bufr.readLine();
		System.out.println(line4);
		String line5 = bufr.readLine();
		System.out.println(line5);
		*/
		
		
		bufr.close();
		
		
	}

	/**
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void demo() throws FileNotFoundException, IOException {
		FileReader fr = new FileReader("buf.txt");
		
		char[] buf = new char[1024];
		
		int len = 0;
		while((len=fr.read(buf))!=-1){
			System.out.println(new String(buf,0,len));
		}
		
		fr.close();
	}

}
