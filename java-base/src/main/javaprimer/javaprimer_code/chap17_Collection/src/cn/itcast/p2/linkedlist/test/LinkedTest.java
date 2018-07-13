package org.alpha.javabase.javaprimer.javaprimer_code.chap17_Collection.src.cn.itcast.p2.linkedlist.test;


/*
 * ��ʹ��LinkedList��ģ��һ����ջ���߶������ݽṹ��
 * 
 * ��ջ���Ƚ���� First In Last Out  FILO
 * 
 * ���У��Ƚ��ȳ� First In First Out FIFO
 * 
 * ����Ӧ����������һ����������ʹ���ṩһ������������������ֽṹ�е�һ�֡�
 */


public class LinkedTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		DuiLie dl = new DuiLie();
		
		dl.myAdd("abc1");
		dl.myAdd("abc2");
		dl.myAdd("abc3");
		dl.myAdd("abc4");
		
		while(!dl.isNull()){
			System.out.println(dl.myGet());
		}
		
		
	}

}
