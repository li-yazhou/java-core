package org.alpha.javabase.javase.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
    public static void main(String[] args){
    	URL url = null;
    	InputStream is;
    	try {
			url = new URL("http://localhost/index.html");
			is = url.openStream();
			int c;
			try{
				while((c = is.read()) != -1){
					System.out.println((char)c);
				}
			}catch(IOException e){
				
			}finally{
				is.close();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
    	System.out.println("文件名：" + url.getFile());
    	System.out.println("主机名：" + url.getHost());
    	System.out.println("端口号：" + url.getPort());
    	System.out.println("协议名：" + url.getProtocol());
    }
}
