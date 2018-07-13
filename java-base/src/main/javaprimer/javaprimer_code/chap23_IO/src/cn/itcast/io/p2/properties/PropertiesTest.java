package org.alpha.javabase.javaprimer.javaprimer_code.chap23_IO.src.cn.itcast.io.p2.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;



/*
 * ���幦�ܣ���ȡһ��Ӧ�ó������еĴ������������5�Σ�����ʹ�ô����ѵ���ע�����ʾ������Ҫ�����г���
 * 
 * ˼·��
 * 1��Ӧ���м������� 
 * ÿ�γ�����������Ҫ����һ��,��������ԭ�еĴ����Ͻ��м�����
 * 2������������һ�������� ͻȻð��һ�뷨����������ʱ����м���������������������ڴ沢�������㡣
 * ���ǳ���һ��������������ʧ�ˡ���ô�ٴ������ó��򣬼����������±���ʼ���ˡ�
 * ��������Ҫ�������ͬһ��Ӧ�ó���ʹ�õ���ͬһ���������� 
 * �����Ҫ���������������ڱ䳤�����ڴ�洢��Ӳ���ļ��С�
 * 
 * 3,���ʹ������������أ�
 * 	���ȣ���������ʱ��Ӧ���ȶ�ȡ������ڼ�¼��������Ϣ�������ļ���
 *  ��ȡ��һ�μ����������� ���������ô������жϡ�
 *  ��Σ��Ըô���������������������Ĵ������´洢�������ļ��С� 
 *  
 * 
 * 4���ļ��е���Ϣ����ν��д洢�����֡�
 * 	ֱ�Ӵ洢����ֵ���ԣ����ǲ���ȷ�����ݵĺ��塣 ���������־ͱ�ú���Ҫ��
 * 	����������ֺ�ֵ�Ķ�Ӧ�����Կ���ʹ�ü�ֵ�ԡ�
 * 	����ӳ���ϵmap���ϸ㶨������Ҫ��ȡӲ���ϵ����ݣ�����map+io = Properties.
 * 
 * 
 * 
 */

public class PropertiesTest {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws Exception 
	 */
	public static void main(String[] args) throws IOException  {
		
		getAppCount();
		
	}
	
	public static void getAppCount() throws IOException{
		
		//�������ļ���װ��File����
		File confile = new File("count.properties");
		
		if(!confile.exists()){
			confile.createNewFile();
		}
		
		FileInputStream fis = new FileInputStream(confile);
		
		Properties prop = new Properties();
		
		prop.load(fis);
		
		
		//�Ӽ�����ͨ������ȡ������		
		String value = prop.getProperty("time");
		//�������������¼��ȡ���Ĵ�����
		int count =0;
		if(value!=null){
			count = Integer.parseInt(value);
			if(count>=5){
//				System.out.println("ʹ�ô����ѵ�����ע�ᣬ��Ǯ��");
//				return;
				throw new RuntimeException("ʹ�ô����ѵ�����ע�ᣬ��Ǯ��");
			}
		}
		count++;
		
		//���ı��Ĵ������´洢�������С�
		prop.setProperty("time", count+"");
		
		FileOutputStream fos = new FileOutputStream(confile);
		
		prop.store(fos, "");
		
		fos.close();
		fis.close();
		
		
	}

}






