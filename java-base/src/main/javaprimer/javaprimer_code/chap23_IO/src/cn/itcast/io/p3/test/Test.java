package org.alpha.javabase.javaprimer.javaprimer_code.chap23_IO.src.cn.itcast.io.p3.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * 
 * ��ȡָ��Ŀ¼�£�ָ����չ�����ļ�(������Ŀ¼�е�)
 * ��Щ�ļ��ľ���·��д�뵽һ���ı��ļ��С�
 * 
 * ��˵�����ǽ���һ��ָ����չ�����ļ����б� 
 * 
 * ˼·��
 * 1�����������ȱ�����
 * 2��Ҫ�ڱ����Ĺ����н��й��ˡ����������������ݶ��洢�������С�
 * 3���������е����ݽ��б�����������·��д�뵽�ļ��С� 
 * 
 *
 */
public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
			
		File dir = new File("e:\\java0331");
		
		FilenameFilter filter = new FilenameFilter(){
			@Override
			public boolean accept(File dir, String name) {
				
				return name.endsWith(".java");
			}			
		};
		
		List<File> list = new ArrayList<File>();
		
		getFiles(dir,filter,list);
		
		File destFile = new File(dir,"javalist.txt");
		
		write2File(list,destFile);
		
	}
	/**
	 * ��ָ��Ŀ¼�е����ݽ�����ȱ�����������ָ�������������й��ˣ�
	 * �����˺�����ݴ洢��ָ������List�С�
	 * @param dir
	 * @param filter
	 * @param list
	 */
	public static void getFiles(File dir,FilenameFilter filter,List<File> list){
		
		File[] files = dir.listFiles();
		
		for(File file : files){
			if(file.isDirectory()){
				//�ݹ�����
				getFiles(file,filter,list);
			}else{
				//�Ա��������ļ����й������Ĺ��ˡ�����������File���󣬴洢��List�����С� 
				if(filter.accept(dir, file.getName())){
					list.add(file);
				}
			}
		}
		
	}
	
	public static void write2File(List<File> list,File destFile)throws IOException{
		
		BufferedWriter bufw = null;
		try {
			bufw = new BufferedWriter(new FileWriter(destFile));
			for(File file : list){
				bufw.write(file.getAbsolutePath());
				bufw.newLine();
				bufw.flush();
			}
			
			
		} /*catch(IOException e){
			
			throw new RuntimeException("д��ʧ��");
		}*/finally{
			if(bufw!=null)
				try {
					bufw.close();
				} catch (IOException e) {
					
					throw new RuntimeException("�ر�ʧ��");
				}
		}
	}

}
