package cn.itcast.net.p2.ie_server;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyBrowser {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket s = new Socket("192.168.1.100",8080);
		
		//模拟浏览器，给tomcat服务端发送符合http协议的请求消息。
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		out.println("GET /myweb/1.html HTTP/1.1");
		out.println("Accept: */*");
		out.println("Host: 192.168.1.100:8080");
		out.println("Connection: close");
		out.println();
		out.println();
		
		
		InputStream in = s.getInputStream();
		
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		
		String str =new String(buf,0,len);
		System.out.println(str);
		
		s.close();
		
		//http://192.168.1.100:8080/myweb/1.html
	}

}
