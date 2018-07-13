package org.alpha.javabase.javaprimer.javaprimer_code.chap26_Socket.src.cn.itcast.net.p3.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Rece implements Runnable {

	private DatagramSocket ds;

	public Rece(DatagramSocket ds) {
		this.ds = ds;
	}

	@Override
	public void run() {
		try {
			while (true) {

				// 2,�������ݰ���
				byte[] buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf, buf.length);

				// 3,ʹ�ý��շ��������ݴ洢�����ݰ��С�
				ds.receive(dp);// ����ʽ�ġ�

				// 4��ͨ�����ݰ�����ķ������������е�����,���磬��ַ���˿ڣ��������ݡ�
				String ip = dp.getAddress().getHostAddress();
				int port = dp.getPort();
				String text = new String(dp.getData(), 0, dp.getLength());
				
				System.out.println(ip + "::" + text);
				if(text.equals("886")){
					System.out.println(ip+"....�˳�������");
				}

			}
		} catch (Exception e) {

		}

	}

}
