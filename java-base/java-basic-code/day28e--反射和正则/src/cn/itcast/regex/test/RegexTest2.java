package cn.itcast.regex.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
 * 网页爬虫：其实就一个程序用于在互联网中获取符合指定规则的数据。 
 * 
 * 爬取邮箱地址。 
 * 
 */
public class RegexTest2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		
		List<String> list = getMailsByWeb();
		
		for(String mail : list){
			System.out.println(mail);
		}
	}
	
	public static List<String> getMailsByWeb() throws IOException {
		
		//1,读取源文件。
//				BufferedReader bufr = new BufferedReader(new FileReader("c:\\mail.html"));
		
		URL url = new URL("http://192.168.1.100:8080/myweb/mail.html");
		
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(url.openStream()));
				
		//2,对读取的数据进行规则的匹配。从中获取符合规则的数据.
		String mail_regex = "\\w+@\\w+(\\.\\w+)+";
		
		List<String> list = new ArrayList<String>();
		
		
		Pattern p = Pattern.compile(mail_regex);
		
		String line = null;
		
		while((line=bufIn.readLine())!=null){
			
			Matcher m = p.matcher(line);
			while(m.find()){
				//3,将符合规则的数据存储到集合中。
				list.add(m.group());
			}
			
		}
		return list;
	}

	public static List<String>  getMails() throws IOException{
		
		//1,读取源文件。
		BufferedReader bufr = new BufferedReader(new FileReader("c:\\mail.html"));
		
		//2,对读取的数据进行规则的匹配。从中获取符合规则的数据.
		String mail_regex = "\\w+@\\w+(\\.\\w+)+";
		
		List<String> list = new ArrayList<String>();
		
		
		Pattern p = Pattern.compile(mail_regex);
		
		String line = null;
		
		while((line=bufr.readLine())!=null){
			
			Matcher m = p.matcher(line);
			while(m.find()){
				//3,将符合规则的数据存储到集合中。
				list.add(m.group());
			}
			
		}
		return list;
		
	}

}
