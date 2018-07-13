package org.alpha.javabase.javaprimer.javaprimer_code.chap27_Socket.src.cn.itcast.net.p1.uploadpic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class UploadTask implements Runnable {

	private static final int SIZE = 1024*1024*2;
	private Socket s;

	public  UploadTask(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {

		int count = 0;
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip + ".....connected");
		
		try{

		// ��ȡ�ͻ��˷��������ݡ�
		InputStream in = s.getInputStream();

		// ����ȡ�����ݴ洢��һ���ļ��С�
		File dir = new File("c:\\pic");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File file = new File(dir, ip + ".jpg");
		//����ļ��Ѿ������ڷ���� 
		while(file.exists()){
			file = new File(dir,ip+"("+(++count)+").jpg");
		}
		
		
		FileOutputStream fos = new FileOutputStream(file);

		byte[] buf = new byte[1024];

		int len = 0;

		while ((len = in.read(buf)) != -1) {
			
			
			
			fos.write(buf, 0, len);
			
			if(file.length()>SIZE){
				System.out.println(ip+"�ļ��������");
				
				fos.close();
				s.close();
				
				
				System.out.println(ip+"...."+file.delete());
				
				return ;
			}
		}

		// ��ȡsocket����������ϴ��ɹ����������ͻ��ˡ�
		OutputStream out = s.getOutputStream();
		out.write("�ϴ��ɹ�".getBytes());

		fos.close();
		s.close();
		}catch(IOException e){
			
		}

	}

}
