/*

异常处理的捕捉形式：
这是可以对异常进行针对性处理的方式。

具体格式是：

try
{
	//需要被检测异常的代码。
}
catch(异常类 变量)//该变量用于接收发生的异常对象
{
	//处理异常的代码。
}
finally
{
	//一定会被执行的代码。
}





异常处理的原则：
1，函数内容如果抛出需要检测的异常，那么函数上必须要声明。
	否则必须在函数内用trycatch捕捉，否则编译失败。
	
2，如果调用到了声明异常的函数，要么trycatch要么throws，否则编译失败。

3，什么时候catch，什么时候throws 呢？
	功能内容可以解决，用catch。
	解决不了，用throws告诉调用者，由调用者解决 。

4，一个功能如果抛出了多个异常，那么调用时，必须有对应多个catch进行针对性的处理。
	内部又几个需要检测的异常，就抛几个异常，抛出几个，就catch几个。





*/


class FuShuIndexException extends Exception
{
	FuShuIndexException()
	{}

	
	FuShuIndexException(String msg)
	{
		super(msg);
	}
}


class Demo
{
	public int method(int[] arr,int index)//throws NullPointerException,FuShuIndexException
	{	
		if(arr==null)
			throw new NullPointerException("没有任何数组实体");
		if(index<0)
			throw new FuShuIndexException();
			
		return arr[index];
	}
}

class  ExceptionDemo4
{
	public static void main(String[] args) 
	{
		int[] arr = new int[3];		
		Demo d = new Demo();
		try
		{
			int num = d.method(null,-1);
			System.out.println("num="+num);
			
		}
		
		catch(NullPointerException e)
		{
			System.out.println(e.toString());
		}
		catch (FuShuIndexException e)
		{
			System.out.println("message:"+e.getMessage());
			System.out.println("string:"+e.toString());

			e.printStackTrace();//jvm默认的异常处理机制就是调用异常对象的这个方法。

			System.out.println("负数角标异常!!!!");
		}
		/*
		catch(Exception e)//多catch父类的catch放在最下面。
		{
			
		}
		*/
		System.out.println("over");
	}
	
}
