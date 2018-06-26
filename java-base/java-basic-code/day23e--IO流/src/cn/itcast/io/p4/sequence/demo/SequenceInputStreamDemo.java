package cn.itcast.io.p4.sequence.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;

public class SequenceInputStreamDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		
		/*
		 * 需求：将1.txt 2.txt 3.txt文件中的数据合并到一个文件中。
		 */
		
//		Vector<FileInputStream> v = new Vector<FileInputStream>();		
//		v.add(new FileInputStream("1.txt"));
//		v.add(new FileInputStream("2.txt"));
//		v.add(new FileInputStream("3.txt"));
//		Enumeration<FileInputStream> en = v.elements();
		
		ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
		for(int x=1; x<=3; x++){
			al.add(new FileInputStream(x+".txt"));
		}
		
		Enumeration<FileInputStream> en = Collections.enumeration(al);
		
		
		
		/*
		final Iterator<FileInputStream> it = al.iterator();
		Enumeration<FileInputStream> en = new Enumeration<FileInputStream>(){

			@Override
			public boolean hasMoreElements() {
				
				return it.hasNext();
			}

			@Override
			public FileInputStream nextElement() {
				
				return it.next();
			}
			
		};*/
		
		SequenceInputStream sis = new SequenceInputStream(en);
		
		FileOutputStream fos = new FileOutputStream("1234.txt");
		
		byte[] buf = new byte[1024];
		
		int len = 0;
		
		while((len=sis.read(buf))!=-1){
			fos.write(buf,0,len);
		}
		
		fos.close();
		sis.close();
		
	}

}
