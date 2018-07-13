

/*
毕老师用电脑上课。

问题领域中涉及两个对象。
毕老师，电脑。

分析其中的问题。

比如电脑蓝屏啦。冒烟啦。



*/

class LanPingException extends Exception
{
	LanPingException(String msg)
	{
		super(msg);
	}
}

class MaoYanException extends Exception
{
	MaoYanException(String msg)
	{
		super(msg);
	}
}

class NoPlanException extends Exception
{
	NoPlanException(String msg)
	{
		super(msg);
	}
}

class Computer
{
	private int state = 2;
	public void run()throws LanPingException,MaoYanException
	{
		if(state==1)
			throw new LanPingException("电脑蓝屏啦！！");
		if(state==2)
			throw new MaoYanException("电脑冒烟啦！！");

		System.out.println("电脑运行");
	}
	public void reset()
	{
		state = 0;
		System.out.println("电脑重启");
	}
}

class Teacher
{
	private String name;
	private Computer comp;
	Teacher(String name)
	{
		this.name = name;
		comp = new Computer();
	}
	
	public void prelect()throws NoPlanException
	{
		try
		{
			comp.run();
			System.out.println(name+"讲课");
			
		}
		catch (LanPingException e)
		{
			System.out.println(e.toString());
			comp.reset();
			prelect();
		}
		catch (MaoYanException e)
		{
			System.out.println(e.toString());
			test();
			//可以对电脑进行维修。
//			throw e;
			throw new NoPlanException("课时进度无法完成，原因："+e.getMessage());
		}

	}
	public void test()
	{
		System.out.println("大家练习");
	}
}	
class ExceptionTest 
{
	public static void main(String[] args) 
	{
		Teacher t  = new Teacher("毕老师");
		try
		{
			t.prelect();
			
		}
		catch (NoPlanException e)
		{
			System.out.println(e.toString()+"......");
			System.out.println("换人");

		}
	}
}


/*

class NoAddException extends Exception
{}

void addData(Data d)throws NoAddException
{

	连接数据库
	try
	{
	添加数据。出现异常 SQLException();
	}
	catch(SQLException e)
	{
		//处理代码。

		throw new NoAddException();
	}
	fianlly
	{
	关闭数据库。
	}
}


*/