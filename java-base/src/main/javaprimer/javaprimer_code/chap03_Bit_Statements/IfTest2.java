class IfTest2 
{
	public static void main(String[] args) 
	{

		/*
		一年有四季。
		春季：3 4 5
		夏季：6 7 8
		秋季：9 10 11
		冬季：12 1 2 
		根据用户输入的月份，给出对应的季节。


		*/
		
		int month = 8;
		
		if(month<1 || month>12)
			System.out.println(month+"月没有对应的季节");
		else if(month>=3 && month<=5)
			System.out.println(month+"月是春季");
		else if(month>=6 && month<=8)
			System.out.println(month+"月是夏季");
		else if(month>=9 && month<=11)
			System.out.println(month+"月是秋季");
		else 
			System.out.println(month+"月是冬季");



		/*
		if(month==3 || month==4 || month==5)
			System.out.println(month+"月是春季");
		else if(month==6 || month==7 || month==8)
			System.out.println(month+"月是夏季");
		else if(month==9 || month==10 || month==11)
			System.out.println(month+"月是秋季");
		else if(month==12 || month==1 || month==2)
			System.out.println(month+"月是冬季");
		else
			System.out.println(month+"月没有对应的季节");
			*/
			
	}
}
