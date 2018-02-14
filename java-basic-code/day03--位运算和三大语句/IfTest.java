class IfTest 
{
	public static void main(String[] args) 
	{

		/*
		需求：根据用户指定的具体数据，判断该数据对应的星期。
		1-星期一Monday

		思路：
		用户输入无法获取但是那只是具体数据的一种获取手段而已。
		而我们要做的功能仅仅是对用户指定的数据进行对应星期的打印而已。

		所以具体的数据不确定，完成可以使用变量来表示。

		我们只对变量进行操作即可。至于变量的值，可以有用户决定。

		因为数据的不确定性，所以要对数据进行判断。
		使用if语句。


		*/

		int week = 10;

		if(week==1)
			System.out.println(week+"对应中文是星期一");
		else if(week==2)
			System.out.println(week+"对应中文是星期二");
		else if(week==3)
			System.out.println(week+"对应中文是星期三");
		else if(week==4)
			System.out.println(week+"对应中文是星期四");
		else if(week==5)
			System.out.println(week+"对应中文是星期五");
		else if(week==6)
			System.out.println(week+"对应中文是星期六");
		else if(week==7)
			System.out.println(week+"对应中文是星期日");
		else
			System.out.println(week+"没有对应的星期");
		
	}
}

