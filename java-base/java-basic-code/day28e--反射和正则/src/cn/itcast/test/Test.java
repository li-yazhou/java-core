package cn.itcast.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws Exception 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args)throws Exception{
//		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		
		File file = new File("configFile.txt");
		
		BufferedReader bufr = new BufferedReader(new FileReader(file));
		
		String className = bufr.readLine();
		
		Class clazz = Class.forName(className);
		
		GetDataInter getData = (GetDataInter)clazz.newInstance();//new MyGetDataByFile();MyGetDataByIn();
		
		
		operateData(getData);
	}
	
	public static void operateData(GetDataInter getData){
		int num = getData.getNumber();
		
		if(num>10){
			System.out.println("大了");
		}else{
			System.out.println("小了");
		}
	}

}
