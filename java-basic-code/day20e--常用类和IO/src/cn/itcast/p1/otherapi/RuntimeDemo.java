package cn.itcast.p1.otherapi;

import java.io.IOException;

public class RuntimeDemo {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {

		/*
		 * Runtime:没有构造方法摘要，说明该类不可以创建对象。
		 * 又发现还有非静态的方法。说明该类应该提供静态的返回该类对象的方法。
		 * 而且只有一个，说明Runtime类使用了单例设计模式。
		 * 
		 */
		
		Runtime r = Runtime.getRuntime();
		
//		execute: 执行。 xxx.exe 
		
		Process p = r.exec("notepad.exe");
		Thread.sleep(5000);
		p.destroy();
	}

}
