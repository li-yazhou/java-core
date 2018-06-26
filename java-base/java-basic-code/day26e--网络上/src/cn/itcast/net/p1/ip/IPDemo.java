package cn.itcast.net.p1.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPDemo {

	/**
	 * @param args
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException {

		//获取本地主机ip地址对象。 
		InetAddress ip = InetAddress.getLocalHost();
		
		//获取其他主机的ip地址对象。
		ip = InetAddress.getByName("192.168.1.110");//InetAddress.getByName("my_think");
		
		System.out.println(ip.getHostAddress());
		System.out.println(ip.getHostName());
	}

}
