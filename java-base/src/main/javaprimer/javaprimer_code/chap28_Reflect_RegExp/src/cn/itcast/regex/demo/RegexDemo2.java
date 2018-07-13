package org.alpha.javabase.javaprimer.javaprimer_code.chap28_Reflect_RegExp.src.cn.itcast.regex.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * ������ʽ���ַ����ĳ�������:
		 * 1, ƥ�䡣
		 * 		��ʵʹ�õľ���String���е�matches������
		 * 
		 * 2���и
		 * 		��ʵʹ�õľ���String���е�split������ 
		 * 
		 * 3���滻��
		 * 		��ʵʹ�õľ���String���е�replaceAll()������
		 * 
		 * 4����ȡ��
		 * 		
		 */
		
		functionDemo_4();
	}
	
	/*
	 * ��ȡ 
	 * �����������ж���ķ�װ�� 
	 * Pattern p = Pattern.compile("a*b");
	 *  //ͨ����������matcher�����ַ������������ȡҪ���ַ���������ƥ��������Matcher .
 	 * Matcher m = p.matcher("aaaaab");
 	 * //ͨ��Matcherƥ��������ķ������ַ������в�����
 	 * boolean b = m.matches();
	 * 
	 * 
	 */
	public  static void functionDemo_4() {
		
		String str = "da jia hao,ming tian bu fang jia!";
		
		String regex = "\\b[a-z]{3}\\b";
		
		//1,�������װ�ɶ���
		Pattern p = Pattern.compile(regex);
		//2, ͨ����������ȡƥ�������� 
		Matcher m = p.matcher(str);
		
		//ʹ��Matcher����ķ������ַ������в�����
		//��ȻҪ��ȡ������ĸ��ɵĵ��� 
		//���ҡ� find();
		System.out.println(str);
		while(m.find()){
			System.out.println(m.group());//��ȡƥ���������
			
			System.out.println(m.start()+":"+m.end());
		}
	}

	/*
	 * �滻 
	 */
	public static void functionDemo_3() {
		
		String str = "zhangsanttttxiaoqiangmmmmmmzhaoliu";
		
		str = str.replaceAll("(.)\\1+", "$1");
		
		System.out.println(str);
		
		String tel = "15800001111";//158****1111;
		
		tel = tel.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
		
		System.out.println(tel);
		
	}

	/*
	 * �и
	 * 
	 * �飺((A)(B(C))) 
	 */
	public static void functionDemo_2(){

		String str = "zhangsanttttxiaoqiangmmmmmmzhaoliu";
		
		String[] names = str.split("(.)\\1+");//str.split("\\.");
		
		for(String name : names){
			System.out.println(name);
		}
		
	}
	/*
	 * ��ʾƥ�䡣 
	 */
	public static void functionDemo_1(){
	
		
		//ƥ���ֻ������Ƿ���ȷ�� 
		String tel = "15800001111";
		
		String regex = "1[358]\\d{9}";   
		
		boolean b = tel.matches(regex);
		System.out.println(tel+":"+b);
	}
	

}
