package cn.itcast.p1.string.test;



/*
 * 1，给定一个字符串数组。按照字典顺序进行从小到大的排序。
 * {"nba","abc","cba","zz","qq","haha"}
 * 
 * 
 * 2，一个子串在整串中出现的次数。
 * "nbaernbatynbauinbaopnba"
 * 
 * 
 * 
 * 3，两个字符串中最大相同的子串。
 * 
 * 
 * 
 * 4，模拟一个trim功能一致的方法。
 * 
 * 
 */
public class StringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s1 = "hello";
		String s2 = "java";
		
		show(s1,s2);
		
		System.out.println(s1+"...."+s2);// hello java
	}
	
	public static void show(String s1,String s2){
		
		s2.replace('a','o');
		s1 = s2;
	}
	

}
