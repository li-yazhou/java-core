

class FunctionDemo
{
	public static void main(String[] args) 
	{
//		int a = 3;
//		int b = 4;
//		int c;
//		c = a+b;
//
//		c = 5+7;
//		c = 9+8;
		

//		int c = add(3);
//		System.out.println("c="+c);

//		System.out.println("hello world");
//		myPrint();
//		myPrint();

	}
	/*
	定义函数的格式：

	修饰符 返回值类型 函数名(参数类型 形式参数1，参数类型 形式参数2，...)
	{
			执行语句;
			return 返回值;
	}



	特殊情况：
	功能没有具体的返回值。

	这时return的后面直接用分号结束。
	返回值类型怎么体现呢？因为没有具体值，所以不可以写具体的数据类型。
	在java中只能用一个关键字来表示这种情况。关键字是：void.

	总结：没有具体返回值时，返回值类型用void来表示。

	注意：如果返回值类型是void，那么函数中的return语句可以省略不写。


	*/
	
	public static void myPrint()
	{
		System.out.println("hello java");
		return ;
	}



	public static int add(int a,int b)
	{
		return a+b;
	}

}
