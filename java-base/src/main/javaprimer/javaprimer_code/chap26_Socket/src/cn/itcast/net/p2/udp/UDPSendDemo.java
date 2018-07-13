package org.alpha.javabase.javaprimer.javaprimer_code.chap26_Socket.src.cn.itcast.net.p2.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPSendDemo {

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
		
		//2,��Ҫ���͵����ݷ�װ�����ݰ��С�
		String str = "udp������ʾ���������ˣ�";
			//ʹ��DatagramPacket�����ݷ�װ���ĸö�����С�
		byte[] buf = str.getBytes();
		
		DatagramPacket dp = 
				new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.1.100"),10000);
		
		
		//3��ͨ��udp��socket�������ݰ����ͳ�ȥ��ʹ��send������
		ds.send(dp);
		
		//4���ر���Դ��
		ds.close();
		
		
	}

}
