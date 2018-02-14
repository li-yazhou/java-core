class Demo
{
	static Demo d = new Demo();

	Demo()
	{
		
	}
}

class  DemoDemo
{
	public static void main(String[] args) 
	{		
		new Demo();//StackOverflowError
	}
}
