package org.alpha.javabase.javaprimer.javaprimer_code.chap28_Reflect_RegExp.src.cn.itcast.reflect.test;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;


/*
 * �������С� 
 */
public class ReflectTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		Mainboard mb = new Mainboard();
		mb.run();
		//ÿ�����һ���豸����Ҫ�޸Ĵ��봫��һ���´����Ķ���
//		mb.usePCI(new SoundCard());
		//�ܲ��ܲ��޸Ĵ���Ϳ��������������� 
//		����new����ɣ�����ֻ��ȡ��class�ļ������ڲ�ʵ�ִ�������Ķ����� 
		
		File configFile = new File("pci.properties");
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(configFile);
		
		prop.load(fis);
		
		for(int x=0; x<prop.size(); x++){
			
			String pciName = prop.getProperty("pci"+(x+1));
			
			Class clazz = Class.forName(pciName);//��Classȥ�������pci���ࡣ 
			
			PCI p = (PCI)clazz.newInstance();
			
			mb.usePCI(p);
		}
		
		fis.close();
		
		
	}

}
