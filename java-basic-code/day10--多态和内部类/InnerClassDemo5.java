
interface Inter
{
	void show1();
	void show2();
}

class Outer
{
	/*
	class Inner implements Inter
	{
		public void show1()
		{
		}
		public void show2()
		{
		
		}
	}
	*/

	public void method()
	{
//		Inner in = new Inner();
//		in.show1();
//		in.show2();
		

		Inter in = new Inter()
		{
			public void show1()
			{
				
			}
			public void show2()
			{
			
			}
			
		};
		in.show1();
		in.show2();
	}
}


/*
通常的使用场景之一：
当函数参数是接口类型时，而且接口中的方法不超过三个。
可以用匿名内部类作为实际参数进行传递
*/
class InnerClassDemo5 
{

	class Inner
	{
	}
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		/*
		show(new Inter()
		{
			public void show1(){}
			public void show2(){}
		});
		*/

//		new Inner();
	}

	public void method()
	{
		new Inner();
	}

	public static void show(Inter in)
	{
		in.show1();
		in.show2();
	}
}

