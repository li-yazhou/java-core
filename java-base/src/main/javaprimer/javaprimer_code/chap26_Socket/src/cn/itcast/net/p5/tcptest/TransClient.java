package org.alpha.javabase.javaprimer.javaprimer_code.chap26_Socket.src.cn.itcast.net.p5.tcptest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TransClient {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {

		/*
		 * ˼·��
		 * �ͻ��ˣ�
		 * 1����Ҫ����socket�˵㡣
		 * 2���ͻ��˵�����Դ�����̡�
		 * 3���ͻ��˵�Ŀ�ģ�socket.
		 * 4�����շ���˵����ݣ�Դ��socket��
		 * 5����������ʾ�ڴ�ӡ������Ŀ�ģ�����̨.
		 * 6������Щ���в��������ݣ������ı����ݡ�
		 * 
		 * 
		 * ת���ͻ���:
		 * 1,����socket�ͻ��˶���
		 * 2,��ȡ����¼�롣
		 * 3����¼�����Ϣ���͸�socket�������
		 */
		
		//1,����socket�ͻ��˶���
		Socket s = new Socket("192.168.1.100",10004);
		
		//2����ȡ����¼�롣
		BufferedReader bufr  =
				new BufferedReader(new InputStreamReader(System.in));
		
		//3,socket�������
//		new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		
		//4,socket����������ȡ����˷��صĴ�д����
		BufferedReader bufIn  = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		String line = null;
		
		while((line=bufr.readLine())!=null){
			
			if("over".equals(line))
				break;
			
//			out.print(line+"\r\n");
//			out.flush();
			out.println(line);
			
			//��ȡ����˷��ص�һ�д�д����
			String upperStr = bufIn.readLine();
			System.out.println(upperStr);
		}
		
		s.close();
		
	}

}
