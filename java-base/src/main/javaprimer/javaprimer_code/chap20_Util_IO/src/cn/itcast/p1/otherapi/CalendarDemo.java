package org.alpha.javabase.javaprimer.javaprimer_code.chap20_Util_IO.src.cn.itcast.p1.otherapi;

import java.util.Calendar;

public class CalendarDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Calendar c = Calendar.getInstance();
		
		int year = 2012;
		showDays(year);
	}

	/**
	 * @param c
	 */
	public static void showDays(int year) {
		
		Calendar c = Calendar.getInstance();
		c.set(year, 2, 1);
		
		c.add(Calendar.DAY_OF_MONTH, -1);
		
		showDate(c);
	}

	/**
	 * @param c
	 */
	public static void showDate(Calendar c) {
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int day = c.get(Calendar.DAY_OF_MONTH);
		int week = c.get(Calendar.DAY_OF_WEEK);
		
		
		System.out.println(year+"��"+month+"��"+day+"��"+getWeek(week));
	}

	public static String getWeek(int i) {
		
		String[] weeks = {"","������","����һ","���ڶ�","������","������","������","������"};
		
		return weeks[i];
	}
	
	

}
