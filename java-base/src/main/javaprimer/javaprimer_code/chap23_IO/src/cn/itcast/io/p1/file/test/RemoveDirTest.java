package org.alpha.javabase.javaprimer.javaprimer_code.chap23_IO.src.cn.itcast.io.p1.file.test;

import java.io.File;


/*
 * ɾ��һ�������ݵ�Ŀ¼�� 
 * 
 * ԭ�����������������ɾ�� 
 * ��Ҫ������ȱ�����
 * 
 * 
 * 
 */
public class RemoveDirTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		File dir  = new File("e:\\demodir");
//		dir.delete();
		removeDir(dir);
	}

	public static void removeDir(File dir) {
		
		File[] files = dir.listFiles();
		
		for(File file : files){
			
			if(file.isDirectory()){
				removeDir(file);
			}else{
				System.out.println(file+":"+file.delete());
			}
		}
		System.out.println(dir+":"+dir.delete());
	}
	

}
