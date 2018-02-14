class ForForTest2 
{
	public static void main(String[] args) 
	{

		/*
		
		* * * * * 
		-* * * *
		--* * * 
		---* * 
		----*

		*/
		for(int x=1; x<=5; x++)
		{
			for(int y=1; y<x; y++)
			{
				System.out.print(" ");
			}
			
			for(int z=x; z<=5; z++)
			{
				System.out.print("* ");
			}

			System.out.println();
		}


		/*
		
		      *
			 * *
			* * *
		   * * * * 
		  * * * * *

		*/
	}
}
