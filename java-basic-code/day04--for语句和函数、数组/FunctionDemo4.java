
/*
需求：函数的重载。 
*/

class FunctionDemo4 
{
	public static void main(String[] args) 
	{
//		add(4,6,9);
//		System.out.println("Hello World!");
		printCFB(7);
	}

	/*
	函数的重载。

	1，同一个类，
	2，同名。
	3，参数个数不同。or 参数类型不同。
	4，函数重载和返回值类型无关。
	5，java是严谨性语言，如果函数出现的调用的不确定性，会编译失败。


	*/

	//加法运算。两个整数的和。
	public static int add(int a,int b)
	{
		return a+b;
	}
	

	//加法运算。两个小数的和。
	public static double add(double a,double b)
	{
		return a+b;
	}

	//加法运算，三个整数的和。 
	public static int add(int a,int b,int c)
	{
		return add(a,b)+c;
	}


	/*
	打印乘法表。
	*/
	public static void printCFB(int num)
	{
		for(int x=1; x<=num; x++)
		{
			for(int y=1; y<=x; y++)
			{
				System.out.print(y+"*"+x+"="+y*x+"\t");
			}
			System.out.println();
		}
	}

	/*
	打印标准乘法表。
	*/
	public static void printCFB()
	{
		printCFB(9);
	}

}
