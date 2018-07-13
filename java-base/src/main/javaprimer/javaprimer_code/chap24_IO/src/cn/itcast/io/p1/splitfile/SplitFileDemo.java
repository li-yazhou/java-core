package org.alpha.javabase.javaprimer.javaprimer_code.chap24_IO.src.cn.itcast.io.p1.splitfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/*
 * �ļ��и�����
 * 
 * 
 * 
 * 
 */

public class SplitFileDemo {

	private static final int SIZE = 1024 * 1024;

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		File file = new File("c:\\aa.mp3");

		splitFile_2(file);
	}

	private static void splitFile_2(File file) throws IOException {

		// �ö�ȡ������Դ�ļ���
		FileInputStream fis = new FileInputStream(file);

		// ����һ��1M�Ļ�������
		byte[] buf = new byte[SIZE];

		// ����Ŀ�ġ�
		FileOutputStream fos = null;

		int len = 0;
		int count = 1;
		
		
		/*
		 * �и��ļ�ʱ�������¼ס���и��ļ������ƣ��Լ��и������Ƭ�ļ��ĸ����� �Է����ںϲ���
		 * �����ϢΪ�˽���������ʹ�ü�ֵ�Եķ�ʽ���õ���properties����
		 * 
		 */
		Properties prop  = new Properties();
		
	

		File dir = new File("c:\\partfiles");
		if (!dir.exists())
			dir.mkdirs();

		while ((len = fis.read(buf)) != -1) {

			fos = new FileOutputStream(new File(dir, (count++) + ".part"));
			fos.write(buf, 0, len);
			fos.close();
		}
		
		//�����и��ļ�����Ϣ���浽prop�����С�
		prop.setProperty("partcount", count+"");
		prop.setProperty("filename", file.getName());
		
		
		
		fos = new FileOutputStream(new File(dir,count+".properties"));
		
		//��prop�����е����ݴ洢���ļ��С� 
		prop.store(fos, "save file info");

		fos.close();
		fis.close();

	}

	public static void splitFile(File file) throws IOException {

		// �ö�ȡ������Դ�ļ���
		FileInputStream fis = new FileInputStream(file);

		// ����һ��1M�Ļ�������
		byte[] buf = new byte[SIZE];

		// ����Ŀ�ġ�
		FileOutputStream fos = null;

		int len = 0;
		int count = 1;

		File dir = new File("c:\\partfiles");
		if (!dir.exists())
			dir.mkdirs();

		while ((len = fis.read(buf)) != -1) {

			fos = new FileOutputStream(new File(dir, (count++) + ".part"));
			fos.write(buf, 0, len);
		}

		fos.close();
		fis.close();

	}

}
