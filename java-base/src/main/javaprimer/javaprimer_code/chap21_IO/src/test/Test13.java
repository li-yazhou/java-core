package org.alpha.javabase.javaprimer.javaprimer_code.chap21_IO.src.test;

import java.util.ArrayList;

/*
һ��ArrayList����alist�д������ɸ��ַ���Ԫ�أ�����������ArrayList����
ɾ����������ֵΪ"abc"���ַ���Ԫ�أ����������ʵ����ȷô���������⣬
�����ʲô���⣿��θ�����
������
int size = alist.size();
for(int i = 0; i < size; i++) {
 if("abc".equals(alist.get(i))) {
   alist.remove(i);
 }
}
*/

public class Test13 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayList<String> al = new ArrayList<String>();
		
		al.add("haha");
		al.add("abc");
		al.add("abc");
		al.add("abc");
		
//		int size = al.size();
		
		for(int x=0; x<al.size(); x++){
			if("abc".equals(al.get(x))){
				al.remove(x);
				x--;
			}
		}
		
		System.out.println(al);
	}

}
