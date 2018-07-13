package org.alpha.javabase.javaprimer.javaprimer_code.chap28_Reflect_RegExp.src.cn.itcast.regex.test;

import java.util.TreeSet;

public class RegexTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * 1�����ƿڳ�:����...����...������Ҫ...ҪҪҪҪ...ҪҪҪҪ..ѧѧѧѧѧ...ѧѧ���...�����..��..�̳�...�̳�...�̳̳�
		 * 2����ip��ַ���� 
		 * 3�����ʼ���ַУ�顣 
		 */
		test_3();
	}
	
	//���ʼ���ַУ�顣
	public static void test_3() {
		
		String mail = "abc1@sina.com.cn";
		
		String regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]{1,3})+";
		
		regex = "\\w+@\\w+(\\.\\w+)+";//1@1.1
		
		
		
		boolean b = mail.matches(regex);
		
		System.out.println(mail+":"+b);
		
		
	}
	/*
	 * 1,�οڳԡ�
	 */
	public static void test_1(){
		
		String str = "����...����...������Ҫ...ҪҪҪҪ...ҪҪҪҪ..ѧѧѧѧѧ...ѧѧ���...�����..��..�̳�...�̳�...�̳̳�";
		
		//1�����ַ�����.ȥ���� ���滻��
		str = str.replaceAll("\\.+", "");
		System.out.println(str);
		
		//2,�滻���ʡ�
		str = str.replaceAll("(.)\\1+", "$1");
		System.out.println(str);
		
		
	}
	/*
	 * ip��ַ���� 
	 * 
	 * 192.168.10.34 127.0.0.1 3.3.3.3  105.70.11.55
	 */
	public static void test_2(){
		
		String ip_str = "192.168.10.34  127.0.0.1  3.3.3.3  105.70.11.55";
		
		
		//1,Ϊ����ip���԰����ַ���˳��Ƚϣ�ֻҪ��ip��ÿһ�ε�λ����ͬ��
		//���ԣ����㣬����ÿһλ��������0���в��䡣ÿһ�ζ�������0.
		
		ip_str = ip_str.replaceAll("(\\d+)", "00$1");
		System.out.println(ip_str);
		
		//Ȼ��ÿһ�α�������3λ��
		ip_str = ip_str.replaceAll("0*(\\d{3})", "$1");
		System.out.println(ip_str);
		
		
		//1����ip��ַ�г���
		String[] ips = ip_str.split(" +");
		
		TreeSet<String> ts = new TreeSet<String>();
		
		for(String  ip : ips){
//			System.out.println(ip);
			ts.add(ip);
		}
		
		for(String ip : ts){
			System.out.println(ip.replaceAll("0*(\\d+)", "$1"));
		}
		
	}

}


