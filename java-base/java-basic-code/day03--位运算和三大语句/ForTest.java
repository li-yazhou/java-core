class ForTest 
{
	public static void main(String[] args) 
	{
		/*
		用for完成累加。
		*/
		int sum = 0;
		for(int x=1; x<=10; x++)
		{
			sum = sum + x;	
		}

		System.out.println("sum="+sum);

		/*
		for和while的特点：
		1,for和while可以互换。
		2,格式上的不同，在使用上有点小区别。
			如果需要通过变量来对循环进行控制，该变量只作为循环增量存在时，区别就体现出来了。
		*/

		//打印1~10十个数字
		int x = 1;
		while(x<5)
		{
			System.out.println("x="+x);
			x++;
		}
		System.out.println("x===="+x);

		for(int y=1; y<5; y++)
		{
			System.out.println("y="+y);
		}
		System.out.println("y====="+y);


		//无限循环最简单的形式。
//		while(true){}

//		for(;;){}

		什么时候使用循环结构呢？
		当对某些代码执行很多次时，使用循环结构完成。
		
		当对一个条件进行一次判断时，可以使用if语句。
		当对一个条件进行多次判断时，可以使用while语句。 

		注意：
			在使用循环时，一定要明确哪些语句需要参与循环，哪些不需要。
			循环通常情况下，需要定义条件，需要控制次数。

		

	}
}
