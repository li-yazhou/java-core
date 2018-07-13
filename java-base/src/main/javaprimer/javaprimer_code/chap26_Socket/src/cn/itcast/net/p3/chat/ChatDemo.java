package org.alpha.javabase.javaprimer.javaprimer_code.chap26_Socket.src.cn.itcast.net.p3.chat;

import java.io.IOException;
import java.net.DatagramSocket;

public class ChatDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		
		DatagramSocket send = new DatagramSocket();
		
		DatagramSocket rece = new DatagramSocket(10001);
		new Thread(new Send(send)).start();
		new Thread(new Rece(rece)).start();
		
	}

}
