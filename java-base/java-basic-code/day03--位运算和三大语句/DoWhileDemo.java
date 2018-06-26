class DoWhileDemo 
{
	public static void main(String[] args) 
	{

		/*
		do
		{
			执行语句；
		}while(条件表达式);

		*/
		int x = 1;
		do
		{
			System.out.println("x="+x);
			x++;
		}
		while (x<1);

		/*
		do while语句的特点：无论条件是否满足，循环体至少执行一次。 

		*/

		int y = 1;
		while(y<1)
		{
			System.out.println("y="+y);
			y++;
		}
	}
}
