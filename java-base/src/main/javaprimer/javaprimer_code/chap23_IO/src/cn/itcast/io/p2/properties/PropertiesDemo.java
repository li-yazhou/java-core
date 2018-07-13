package org.alpha.javabase.javaprimer.javaprimer_code.chap23_IO.src.cn.itcast.io.p2.properties;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		/*
		 * Map
		 * 	|--Hashtable
		 * 		|--Properties:
		 * 
		 * Properties���ϣ�
		 * �ص㣺
		 * 1���ü����еļ���ֵ�����ַ������͡�
		 * 2�������е����ݿ��Ա��浽���У����ߴ�����ȡ��
		 * 
		 * ͨ���ü������ڲ����Լ�ֵ����ʽ���ڵ������ļ��� 
		 * 
		 * 
		 */
		
//		methodDemo_4();
//		myLoad();
		
		test();
	}
	
	
	//�����е������ļ��е���Ϣ�����޸ġ� 
	/*
	 * ��ȡ����ļ���
	 * ��������ļ��еļ�ֵ���ݴ洢�������С�
	 * ��ͨ�����϶����ݽ����޸ġ�
	 * ��ͨ�������޸ĺ�����ݴ洢���ļ��С� 
	 */
	public static void test() throws IOException{
		//��ȡ����ļ���
		File file = new File("info.txt");
		if(!file.exists()){
			file.createNewFile();
		}
		FileReader fr = new FileReader(file);
		
		
		
		
		//�������ϴ洢������Ϣ��
		Properties prop = new Properties();
		
		//��������Ϣ�洢�������С�
		prop.load(fr);
		
		prop.setProperty("wangwu", "16");
		
		
		
		FileWriter fw = new FileWriter(file);
		
		prop.store(fw,"");
		
//		prop.list(System.out);
		
		fw.close();
		fr.close();
		
		
		
	}
	
	
	
	//ģ��һ��load������
	public static void myLoad() throws IOException{
		
		Properties prop  = new Properties();
		
		BufferedReader bufr = new BufferedReader(new FileReader("info.txt"));
		
		String line = null;
		
		while((line=bufr.readLine())!=null){
			
			if(line.startsWith("#"))
				continue;
			
			String[] arr = line.split("=");
			
//			System.out.println(arr[0]+"::"+arr[1]);
			prop.setProperty(arr[0], arr[1]);
		}
		
		prop.list(System.out);
		
		bufr.close();
		
	}
	
	public static void methodDemo_4() throws IOException {	
		
		Properties prop  = new Properties();
		
		//�����е�����������һ���ļ��� 
		//ע�⣻����Ҫ��֤���ļ��е������Ǽ�ֵ�ԡ�
		//��Ҫʹ�õ���ȡ���� 
		FileInputStream fis = new FileInputStream("info.txt");
		
		//ʹ��load������ 
		prop.load(fis);
		
		prop.list(System.out);
		
		
		
	}

	public static void methodDemo_3() throws IOException {
		Properties prop  = new Properties();
		
		//�洢Ԫ�ء� 
		prop.setProperty("zhangsan","30");
		prop.setProperty("lisi","31");
		prop.setProperty("wangwu","36");
		prop.setProperty("zhaoliu","20");
		
		//��Ҫ����Щ�����е��ַ�����ֵ��Ϣ�־û��洢���ļ��С�
		//��Ҫ�����������
		FileOutputStream fos = new FileOutputStream("info.txt");
		
		//�����������ݴ洢���ļ��У�ʹ��store������
		prop.store(fos, "info");
		
		fos.close();
		
	}

	/**
	 * ��ʾProperties���Ϻ����������ϵĹ��ܡ�
	 */
	
	public static void methodDemo_2(){
		Properties prop  = new Properties();
		
		//�洢Ԫ�ء� 
//		prop.setProperty("zhangsan","30");
//		prop.setProperty("lisi","31");
//		prop.setProperty("wangwu","36");
//		prop.setProperty("zhaoliu","20");
	
		prop = System.getProperties();
		prop.list(System.out);
	}
	
	/*
	 * Properties���ϵĴ��ȡ��
	 */
	
	public static void propertiesDemo(){
		//����һ��Properties���ϡ�
		
		Properties prop  = new Properties();
		
		//�洢Ԫ�ء� 
		prop.setProperty("zhangsan","30");
		prop.setProperty("lisi","31");
		prop.setProperty("wangwu","36");
		prop.setProperty("zhaoliu","20");
		
		//�޸�Ԫ�ء� 
		prop.setProperty("wangwu","26");
		
		//ȡ������Ԫ�ء�
		Set<String> names = prop.stringPropertyNames();
		
		for(String name : names){
			String value = prop.getProperty(name);
			System.out.println(name+":"+value);
		}
	}
}





