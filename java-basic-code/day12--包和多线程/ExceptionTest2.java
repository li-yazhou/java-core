
class ExceptionTest2 
{
	public static void main(String[] args) 
	{
		int num = show();

		System.out.println("num="+num);
	}
	public static int show()
	{

		int aa =0;
		try
		{
			System.out.println("show run");

			if(1==1)
				throw new RuntimeException("AAA");
			aa = 10;
			return aa;
		}
		catch (RuntimeException e)
		{
			System.out.println("catch....."+e.toString());

			aa = 20;
			
			//finally
			return 20;
		}
		finally
		{
//			System.out.println("finally...."+aa);
			aa = 30;
//			System.out.println("finally-------"+aa);
			return aa;
//			throw new RuntimeException("finally runtime........");
		}

	}
}

