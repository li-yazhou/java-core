package org.alpha.javabase.javaprimer.javaprimer_code.chap18_Generic.aaaa.day15e.src.cn.itcast.p2.stringbuffer.demo;

public class StringBufferDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * StringBuffer:�����ַ�����������
		 * ���ڴ洢���ݵ�������
		 * �ص㣺
		 * 1�����ȵĿɱ�ġ� 
		 * 2�����Դ洢��ͬ�������ݡ�
		 * 3������Ҫת���ַ�������ʹ�á�
		 * 4�����Զ��ַ��������޸ġ�
		 * 
		 * 
		 * ��Ȼ��һ����������Ӧ�þ߱�ʲô�����أ�
		 * 1����ӣ�
		 * 		StringBuffer append(data);
		 * 		StringBuffer insert(index,data);
		 * 2��ɾ����
		 * 		StringBuffer delete(start,end):����ͷ��������β��
		 * 		StringBuffer deleteCharAt(int index):ɾ��ָ��λ�õ�Ԫ�� 
		 * 3�����ң�
		 * 		char charAt(index);
		 * 		int indexOf(string);
		 * 		int lastIndexOf(string);
		 * 4���޸ģ�
		 * 		StringBuffer replace(start,end,string);
		 * 		void setCharAt(index,char);
		 * 
		 * ��ɾ�Ĳ�  C(create)U(update)R(read)D(delete) 
		 * 
		 * 
		 * 
		 */
		bufferMethodDemo_2();
	}
	
	private static void bufferMethodDemo_2() {
		StringBuffer sb = new StringBuffer("abce");
		
//		sb.delete(1, 3);//ae
		
		//��ջ�������
//		sb.delete(0,sb.length());
//		sb = new StringBuffer();
		
//		sb.replace(1, 3, "nba");
//		sb.setCharAt(2, 'q');
		
//		sb.setLength(10);
		
//		System.out.println("sb:"+sb);
//		System.out.println("len:"+sb.length());
		
		System.out.println(sb.reverse());
		
		
	}

	private static void bufferMethodDemo_1() {
		StringBuffer sb = new StringBuffer("abce");
		
//		sb.append("xixi");
		sb.insert(2, "qq");
		
		System.out.println(sb.toString());
	}

	public static void bufferMethodDemo(){
		//��������������
		StringBuffer sb = new StringBuffer();
		
		sb.append(4).append(false);//.append("haha");
		sb.insert(1, "haha");
//		sb.append(true);
		
		System.out.println(sb);
		
	}
	
	

}
