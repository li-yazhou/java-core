


class Outer
{
	void method()
	{
		Object obj = new Object()
		{
			public void show()
			{
				System.out.println("show run");
			}

		};
		obj.show();//因为匿名内部类这个子类对象被向上转型为了Object类型。
					//这样就不能在使用子类特有的方法了。


	}
}

class InnerClassDemo6 
{
	public static void main(String[] args) 
	{
		new Outer().method();
	}
}
