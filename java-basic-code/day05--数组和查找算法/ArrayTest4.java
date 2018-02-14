class ArrayTest4 
{
	public static void main(String[] args) 
	{
		String week = getWeek(71);
		System.out.println(week);
	}
	/*
	使用查表法。
	星期。
	String s = "abc";
	int x = 4;
	*/
	public static String getWeek(int num)
	{

		if(num>7 || num<1)
		{
			return "错误的星期";
		}
		String[] weeks = {"","星期一","星期二","星期三","星期四","星期五","星期六","星期日"};

		return weeks[num];
	}

}
