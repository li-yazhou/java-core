package cn.itcast.net.p3.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Send implements Runnable {

	private DatagramSocket ds;
	
	public Send(DatagramSocket ds){
		this.ds = ds;
	}
	
	@Override
	public void run() {
		
		try {
			BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			
			while((line=bufr.readLine())!=null){
				
				
				byte[] buf = line.getBytes();
				DatagramPacket dp = 
						new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.1.255"),10001);
				ds.send(dp);
				
				if("886".equals(line))
					break;
			}
			
			ds.close();
		} catch (Exception e) {
		}
	}

}
