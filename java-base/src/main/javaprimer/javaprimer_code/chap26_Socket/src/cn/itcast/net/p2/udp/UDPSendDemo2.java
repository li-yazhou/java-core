package org.alpha.javabase.javaprimer.javaprimer_code.chap26_Socket.src.cn.itcast.net.p2.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSendDemo2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		System.out.println("���Ͷ�����......");
		/*
		 * ����UDP����ķ��Ͷˡ�
		 * ˼·��
		 * 1������udp��socket����
		 * 2����Ҫ���͵����ݷ�װ�����ݰ��С� 
		 * 3��ͨ��udp��socket�������ݰ����ͳ�ȥ��
		 * 4���ر�socket����
		 */
		//1,udpsocket����ʹ��DatagramSocket����
		DatagramSocket ds = new DatagramSocket(8888);
		
		
//		String str = "udp������ʾ���������ˣ�";
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		
		while((line=bufr.readLine())!=null){
			
			
			byte[] buf = line.getBytes();
			DatagramPacket dp = 
					new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.1.100"),10000);
			ds.send(dp);
			
			if("886".equals(line))
				break;
		}
		
		//4���ر���Դ��
		ds.close();
		
		
	}

}
