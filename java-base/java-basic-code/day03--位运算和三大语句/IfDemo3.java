class  IfDemo3
{
	public static void main(String[] args) 
	{
		{//局部代码块可以定义局部变量的生命周期。
		int a = 3;
		//a 的运算。
		System.out.println(a+4);
		}

		/*
		if语句第三种格式：
		if(条件表达式)
		{
			执行语句；
		}
		else if (条件表达式)
		{
			执行语句；
		}
		……
		else
		{
			执行语句；
		}

		*/
		int x = 3;
		if(x>1)
			System.out.println("a");
		else if(x>2)
			System.out.println("b");
		else if(x>3)
			System.out.println("c");
		else
			System.out.println("d");


		int y = 3;
		if(y>1)
			System.out.println("a1");
		if(y>2)
			System.out.println("b1");
		if(y>3)
			System.out.println("c1");
		else
			System.out.println("d1");


		if(x==1)
		
			if(y==1)
			
				System.out.println("a");
			
			else
				System.out.println("b");
			
		
		else
		
			if(y==1)
			
				System.out.println("c");
			
			else
			
				System.out.println("d");
			
		
//		if(false);

		
		{//局部代码块。
			int m = 89;
			System.out.println("Hello World!..."+m);
		}

		System.out.println("over....."+m);
	}
}
