package org.alpha.javabase.javaprimer.javaprimer_code.chap27_Socket.src.cn.itcast.net.p1.uploadpic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class UploadPicClient {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {

		
		//1,�����ͻ���socket��
		Socket s = new Socket("192.168.1.100",10006);
		
		//2,��ȡ�ͻ���Ҫ�ϴ���ͼƬ�ļ���
		FileInputStream fis = new FileInputStream("c:\\0.bmp");
		
		//3,��ȡsocket�������������ͼƬ���ݷ��͸�����ˡ�
		OutputStream out = s.getOutputStream();
		
		byte[] buf = new byte[1024];
		
		int len = 0;
		
		while((len=fis.read(buf))!=-1){
			out.write(buf,0,len);
		}
		
		//���߷����˵����ߵ����ݷ�����ϡ��÷����ֹͣ��ȡ��
		s.shutdownOutput();
		
		
		//��ȡ����˷��ص����ݡ� 		
		InputStream in  = s.getInputStream();
		byte[] bufIn = new byte[1024];
		
		int lenIn = in.read(buf);
		String text = new String(buf,0,lenIn);
		System.out.println(text);
		
		fis.close();
		s.close();
		
		
		
		
	}

}
