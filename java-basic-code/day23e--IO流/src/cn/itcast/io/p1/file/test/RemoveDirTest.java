package cn.itcast.io.p1.file.test;

import java.io.File;


/*
 * 删除一个带内容的目录。 
 * 
 * 原理：必须从最里面往外删。 
 * 需要进行深度遍历。
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
