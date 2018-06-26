package cn.itcast.reflect.test;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;


/*
 * 电脑运行。 
 */
public class ReflectTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		Mainboard mb = new Mainboard();
		mb.run();
		//每次添加一个设备都需要修改代码传递一个新创建的对象
//		mb.usePCI(new SoundCard());
		//能不能不修改代码就可以完成这个动作。 
//		不用new来完成，而是只获取其class文件。在内部实现创建对象的动作。 
		
		File configFile = new File("pci.properties");
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(configFile);
		
		prop.load(fis);
		
		for(int x=0; x<prop.size(); x++){
			
			String pciName = prop.getProperty("pci"+(x+1));
			
			Class clazz = Class.forName(pciName);//用Class去加载这个pci子类。 
			
			PCI p = (PCI)clazz.newInstance();
			
			mb.usePCI(p);
		}
		
		fis.close();
		
		
	}

}
