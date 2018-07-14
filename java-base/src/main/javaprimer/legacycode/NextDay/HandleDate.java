package ccu.se.addOneDay;


public class HandleDate {
	private static int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	/**
	 * 验证输入日期是否合法
	 * @param myDate
	 * @return
	 */
	public static boolean validateDate(MyDate myDate) {
		    if(myDate == null){
		    	return false;
		    }
			int y = myDate.getYear();
			int m = myDate.getMonth();
			int d = myDate.getDay();
			if(y%4==0&&y%100!=0||y%400==0){
				days[2] = 29;
			}
			if(m>12||m<1){
				return false;
			}
			if(d>days[m]||d<1){
				return false;
			}
		return true;
	}
	
	/**
	 * 如果是闰年的二月份，则返回29
	 * 否则，返回28
	 * @param y
	 * @return
	 */
	private static boolean feb_leapyear(int y,int m){
		if((y%4==0&&y%100!=0||y%400==0)&&m==2){
			return true;
		}
		return false;
	}

	/**
	 * 在元日期的基础上加上一天
	 * @param mydate
	 */
	public static MyDate addOneDay(MyDate mydate) {
		int year = mydate.getYear();
		int month = mydate.getMonth();
		int day = mydate.getDay();
		//确定了每月的最大天数
		if(feb_leapyear(year, month)){
			days[2] = 29;
		}else{
			days[2] = 28;
		}
		day++;
		if(day>days[month]){
			month++;
			day = 1;
		}
		if(month == 13){
			year++;
			month=1;
		}
		mydate.setYear(year);
		mydate.setMonth(month);
		mydate.setDay(day);
		return mydate;
	}

}
