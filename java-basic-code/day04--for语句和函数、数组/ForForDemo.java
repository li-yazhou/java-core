class  ForForDemo
{
	public static void main(String[] args) 
	{
		//大圈套小圈思想。
		/*
		for(int x=0; x<3; x++)
		{
			for(int y=0; y<4; y++)
			{
				System.out.println("ok");
			}
		}
		*/

		/*
		
		*****
		*****
		*****
		*****
		
		*/
		for(int x=0; x<4; x++)//外循环控制的是行数
		{
			for(int y=0; y<5; y++)//内循环控制的是每一行的个数 
			{
				System.out.print("*");
			}
			System.out.println();
		}
	
		
		
	}
}
