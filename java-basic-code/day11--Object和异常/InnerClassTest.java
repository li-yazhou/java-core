interface Inter
{
	void show();
}

class Outer
{
	//补足代码 (建议用匿名内部类)
	
	static Inter method()
	{
		return new Inter()
		{
			public void show(){}
		};
	}
}
/*
class haha implements Inter
{
	public void show(){}
}
*/
class  InnerClassTest
{
	public static void main(String[] args) 
	{
		Outer.method().show();
		

	}
}
