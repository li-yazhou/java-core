package org.alpha.javabase.javaprimer.javaprimer_code.chap15_String.p1.string.demo;

public class StringMethodDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		/*
		 * ������������˼����ַ������й��ܷ��ࡣ
		 * "abcd"
		 * 
		 * 1,��ȡ��
		 * 1.1 ��ȡ�ַ������ַ��ĸ���(����).
		 * 		int length();
		 * 1.2 ����λ�û�ȡ�ַ���
		 * 		char charAt(int index);
		 * 1.3 �����ַ���ȡ���ַ����еĵ�һ�γ��ֵ�λ��.
		 * 		int indexOf(int ch)
		 * 		int indexOf(int ch,int fromIndex):��ָ��λ�ý���ch�Ĳ��ҵ�һ�γ���λ�� 
		 * 		int indexOf(String str);
		 * 		int indexOf(String str,int fromIndex);
		 * 		 �����ַ�����ȡ���ַ����еĵ�һ�γ��ֵ�λ��.
		 * 		int lastIndexOf(int ch)
		 * 		int lastIndexOf(int ch,int fromIndex):��ָ��λ�ý���ch�Ĳ��ҵ�һ�γ���λ�� 
		 * 		int lastIndexOf(String str);
		 * 		int lastIndexOf(String str,int fromIndex);
		 * 1.4 ��ȡ�ַ�����һ�����ַ�����Ҳ���Ӵ�.
		 * 		String substring(int beginIndex, int endIndex)//����begin ������end ��
		 * 		String substring(int beginIndex);
		 * 		
		 * 
		 * 
		 * 2��ת����
		 * 		2.1 ���ַ�������ַ�������(�ַ������и�)
		 * 			String[]  split(String regex):�漰��������ʽ.
		 * 		2.2 ���ַ�������ַ����顣
		 * 			char[] toCharArray();
		 * 		2.3 ���ַ�������ֽ����顣
		 * 			byte[] getBytes();
		 * 		2.4 ���ַ����е���ĸת�ɴ�Сд��
		 * 			String toUpperCase():��д
		 * 			String toLowerCase():Сд
		 *		2.5  ���ַ����е����ݽ����滻
		 *			String replace(char oldch,char newch);
		 * 			String replace(String s1,String s2);
		 * 		2.6 ���ַ������˵Ŀո�ȥ����
		 * 			String trim();
		 * 		2.7 ���ַ����������� ��
		 * 			String concat(string);
		 * 
		 * 3���ж�
		 * 		3.1 �����ַ��������Ƿ���ͬ����
		 * 			boolean equals(Object obj);
		 * 			boolean equalsIgnoreCase(string str);���Դ�д�Ƚ��ַ������ݡ�
		 * 		3.2 �ַ������Ƿ����ָ���ַ�����
		 * 			boolean contains(string str);
		 * 		3.3 �ַ����Ƿ���ָ���ַ�����ͷ���Ƿ���ָ���ַ�����β��
		 * 			boolean startsWith(string);
		 * 			boolean endsWith(string);
		 * 		
		 * 4���Ƚϡ�
		 * 		
		 */
		stringMethodDemo_4();
		
//		System.out.println("abc".concat("kk"));
//		System.out.println("abc"+"kk");
		
//		System.out.println(String.valueOf(4)+1);
//		System.out.println(""+4+1);
		
	}

	private static void stringMethodDemo_4() {
		
		System.out.println("abc".compareTo("aqz"));
	}

	private static void stringMethodDemo_3() {
		String s = "abc";
		System.out.println(s.equals("ABC".toLowerCase()));
		System.out.println(s.equalsIgnoreCase("ABC"));
		
		System.out.println(s.contains("cc"));
		
		String str  = "ArrayDemo.java";
		
		System.out.println(str.startsWith("Array"));
		System.out.println(str.endsWith(".java"));
		System.out.println(str.contains("Demo"));
	}

	private static void stringMethodDemo_2() {
		
		String  s = "����,����,����";
		String[] arr = s.split(",");
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		char[] chs = s.toCharArray();
		
		for (int i = 0; i < chs.length; i++) {
			System.out.println(chs[i]);
		}
		s = "ab��";
		byte[] bytes = s.getBytes();
		for (int i = 0; i < bytes.length; i++) {
			System.out.println(bytes[i]);
		}
		
		System.out.println("Abc".toUpperCase());
		
		
		String s1 = "java";
		String s2 = s1.replace('q', 'z');
		System.out.println(s1==s2);//true
		
		System.out.println("-"+"    ab  c    ".trim()+"-");
		
	}

	private static void stringMethodDemo_1() {
		
		String  s = "abcdae";
		
		System.out.println("length:"+s.length());//6
		System.out.println("char:"+s.charAt(2));//c//StringIndexOutOfBoundsException
		System.out.println("index:"+s.indexOf('k'));//0//-1 ���ǿ��Ը���-1�����жϸ��ַ������ַ����Ƿ���ڡ�
		System.out.println("lastIndex:"+s.lastIndexOf('a'));//4
		
		
		System.out.println("substring:"+s.substring(2,4));
	}

}
