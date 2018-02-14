
/*
多线程下的单例

*/

//饿汉式
class Single
{
	private static final Single s = new Single();
	private Single(){}
	public static Single getInstance()
	{
		return s;
	}
}



//懒汉式

加入同步为了解决多线程安全问题。

加入双重判断是为了解决效率问题。




class Single
{
	private static Single s = null;

	private Single(){}

	public static Single getInstance()
	{
		if(s==null)
		{
			synchronized(Single.class)		
			{
				if(s==null)
		//				-->0 -->1
					s = new Single();
			}
		}
		return s;
	}
}
class  SingleDemo
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
