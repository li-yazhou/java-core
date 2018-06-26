package test;

import java.util.ArrayList;

/*
一个ArrayList对象alist中存有若干个字符串元素，现欲遍历该ArrayList对象，
删除其中所有值为"abc"的字符串元素，请问下面的实现正确么？如有问题，
会出现什么问题？如何更正？
。。。
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
