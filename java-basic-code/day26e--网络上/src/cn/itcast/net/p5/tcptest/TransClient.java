package cn.itcast.net.p5.tcptest;

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
		 * 思路：
		 * 客户端：
		 * 1，需要先有socket端点。
		 * 2，客户端的数据源：键盘。
		 * 3，客户端的目的：socket.
		 * 4，接收服务端的数据，源：socket。
		 * 5，将数据显示在打印出来：目的：控制台.
		 * 6，在这些流中操作的数据，都是文本数据。
		 * 
		 * 
		 * 转换客户端:
		 * 1,创建socket客户端对象。
		 * 2,获取键盘录入。
		 * 3，将录入的信息发送给socket输出流。
		 */
		
		//1,创建socket客户端对象。
		Socket s = new Socket("192.168.1.100",10004);
		
		//2，获取键盘录入。
		BufferedReader bufr  =
				new BufferedReader(new InputStreamReader(System.in));
		
		//3,socket输出流。
//		new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		
		//4,socket输入流，读取服务端返回的大写数据
		BufferedReader bufIn  = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		String line = null;
		
		while((line=bufr.readLine())!=null){
			
			if("over".equals(line))
				break;
			
//			out.print(line+"\r\n");
//			out.flush();
			out.println(line);
			
			//读取服务端发回的一行大写数。
			String upperStr = bufIn.readLine();
			System.out.println(upperStr);
		}
		
		s.close();
		
	}

}
