package org.alpha.javabase.javaprimer.javaprimer_code.chap26_Socket.src.cn.itcast.net.p5.tcptest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TransServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		/*
		 * 
		 * ת������ˡ�
		 * ������
		 * 1��serversocket����
		 * 2����ȡsocket����
		 * 3��Դ��socket����ȡ�ͻ��˷���������Ҫת�������ݡ�
		 * 4��Ŀ�ģ���ʾ�ڿ���̨�ϡ�
		 * 5��������ת�ɴ�д�����ͻ��ˡ� 
		 */
		
		//1,
		ServerSocket ss = new ServerSocket(10004);
		
		//2,��ȡsocket����
		Socket s = ss.accept();
		
		//��ȡip.
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"......connected");
		
		//3,��ȡsocket��ȡ������װ�Ρ� 
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		//4,��ȡsocket�����������װ�Ρ�
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		String line = null;
		while((line=bufIn.readLine())!=null){
			
			System.out.println(line);
			out.println(line.toUpperCase());
//			out.print(line.toUpperCase()+"\r\n");
//			out.flush();
		}
		
		s.close();
		ss.close();
		
	}

}
