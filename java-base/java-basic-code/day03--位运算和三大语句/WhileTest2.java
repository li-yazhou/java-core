class  WhileTest2
{
	public static void main(String[] args) 
	{

		/*
		练习：
		1~100之间 6的倍数出现的次数。
		要求：自己独立完成思想的书写。和步骤的文字描述。


		*/

//		计数器思想
		int x = 1;
		int count = 0;
		while(x<=100)
		{
			if(x%6==0)
				count++;
//				System.out.println("x="+x);
			x++;
		}

		System.out.println("count="+count);
	}
}
