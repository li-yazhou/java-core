package org.alpha.javabase.javaprimer.javaprimer_code.chap20_Util_IO.src.cn.itcast.p1.otherapi;

import java.util.Random;

public class MathDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * Math:�ṩ�˲�����ѧ����ķ��������Ǿ�̬�ġ�
		 * 
		 * ���õķ�����
		 * ceil():���ش��ڲ�������С������
		 * floor():����С�ڲ��������������
		 * round():�������������������
		 * pow(a,b):a��b�η���
		 * 
		 */
		double d1 = Math.ceil(12.56);
		double d2 = Math.floor(12.56);
		double d3 = Math.round(12.46);
		
//		sop("d1="+d1);
//		sop("d2="+d2);
//		sop("d3="+d3);
		
//		double d = Math.pow(10, 2);
//		sop("d="+d);
		
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			
//			double d = Math.ceil(Math.random()*10);
//			double d = (int)(Math.random()*6+1);
//			double d = (int)(r.nextDouble()*6+1);
			int d = r.nextInt(6)+1;
			System.out.println(d);
		}
	}

	public static void sop(String string) {
		System.out.println(string);
	}

}
