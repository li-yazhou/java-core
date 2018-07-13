package org.alpha.javabase.javaprimer.javaprimer_code.chap27_Socket.src.cn.itcast.net.p1.uploadpic;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadPicServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
			
		//����tcp��socket����ˡ�
		ServerSocket ss = new ServerSocket(10006);
		
		while(true){
			Socket s = ss.accept();			
			
			new Thread(new UploadTask(s)).start();		
			
		}
		//��ȡ�ͻ��ˡ�
		
		
//		ss.close();
		
		
	}

}
