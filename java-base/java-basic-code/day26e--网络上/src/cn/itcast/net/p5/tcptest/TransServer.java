package cn.itcast.net.p5.tcptest;

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
		 * 转换服务端。
		 * 分析：
		 * 1，serversocket服务。
		 * 2，获取socket对象。
		 * 3，源：socket，读取客户端发过来的需要转换的数据。
		 * 4，目的：显示在控制台上。
		 * 5，将数据转成大写发给客户端。 
		 */
		
		//1,
		ServerSocket ss = new ServerSocket(10004);
		
		//2,获取socket对象。
		Socket s = ss.accept();
		
		//获取ip.
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"......connected");
		
		//3,获取socket读取流，并装饰。 
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		//4,获取socket的输出流，并装饰。
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
