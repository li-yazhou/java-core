package org.alpha.javabase.javaprimer.javaprimer_code.chap18_Generic.aaaa.day15e.src.cn.itcast.p1.string.test;

/*
 * 2��һ���Ӵ��������г��ֵĴ�����
 * "nbaernbatynbauinbaopnba"
 * ˼·��
 * 1��Ҫ�ҵ��Ӵ��Ƿ���ڣ�������ڻ�ȡ����ֵ�λ�á��������ʹ��indexOf��ɡ�
 * 2������ҵ��ˣ���ô�ͼ�¼���ֵ�λ�ò���ʣ����ַ����м������Ҹ��Ӵ���
 * ��ʣ���ַ�������ʼλ�ǳ���λ��+�Ӵ��ĳ���.
 * 3,�Դ����ƣ�ͨ��ѭ����ɲ��ң�����Ҳ�������-1������ ÿ���ҵ��ü�������¼�� 
 * 
 */



public class StringTest_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String str = "nbaernbatnbaynbauinbaopnba";
		String key = "nba";
		
		int count = getKeyStringCount_2(str,key);
		System.out.println("count="+count);
				
	}

	public static int getKeyStringCount_2(String str, String key) {
		
		int count = 0;
		int index = 0;
		
		while((index = str.indexOf(key,index))!=-1){
			
			index = index + key.length();
			count++;
			
		}
		
		return count;
	}

	/**
	 * ��ȡ�Ӵ��������г��ֵĴ�����
	 * @param str
	 * @param key
	 * @return
	 */
	public static int getKeyStringCount(String str, String key) {
		
		//1,����������� 
		int count = 0;
		
		//2�����������¼key���ֵ�λ�á�
		int index = 0;
		
		while((index = str.indexOf(key))!=-1){
			
			str = str.substring(index+key.length());
			count++;
		}
		return count;
	}
	
	

}
