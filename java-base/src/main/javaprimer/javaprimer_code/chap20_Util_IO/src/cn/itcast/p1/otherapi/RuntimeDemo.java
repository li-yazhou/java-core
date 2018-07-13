package org.alpha.javabase.javaprimer.javaprimer_code.chap20_Util_IO.src.cn.itcast.p1.otherapi;

import java.io.IOException;

public class RuntimeDemo {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {

		/*
		 * Runtime:û�й��췽��ժҪ��˵�����಻���Դ�������
		 * �ַ��ֻ��зǾ�̬�ķ�����˵������Ӧ���ṩ��̬�ķ��ظ������ķ�����
		 * ����ֻ��һ����˵��Runtime��ʹ���˵������ģʽ��
		 * 
		 */
		
		Runtime r = Runtime.getRuntime();
		
//		execute: ִ�С� xxx.exe 
		
		Process p = r.exec("notepad.exe");
		Thread.sleep(5000);
		p.destroy();
	}

}
