
/*
如何创建一个线程呢？

创建线程方式一：继承Thread类。

步骤：
1，定义一个类继承Thread类。
2，覆盖Thread类中的run方法。
3，直接创建Thread的子类对象创建线程。
4，调用start方法开启线程并调用线程的任务run方法执行。



可以通过Thread的getName获取线程的名称 Thread-编号(从0开始)

主线程的名字就是main。
*/

class Demo extends Thread
{
	private String name;
	Demo(String name)
	{
		super(name);
		//this.name = name;
	}
	public void run()
	{
		for(int x=0; x<10; x++)
		{
			//for(int y=-9999999; y<999999999; y++){}
			System.out.println(name+"....x="+x+".....name="+Thread.currentThread().getName());
		}
	}
}




class ThreadDemo2 
{
	public static void main(String[] args) 
	{

		/*
		创建线程的目的是为了开启一条执行路径，去运行指定的代码和其他代码实现同时运行。
		
		而运行的指定代码就是这个执行路径的任务。

		jvm创建的主线程的任务都定义在了主函数中。

		而自定义的线程它的任务在哪儿呢？
		Thread类用于描述线程，线程是需要任务的。所以Thread类也对任务的描述。
		这个任务就通过Thread类中的run方法来体现。也就是说，run方法就是封装自定义线程运行任务的函数。
		
		run方法中定义就是线程要运行的任务代码。

		开启线程是为了运行指定代码，所以只有继承Thread类，并复写run方法。
		将运行的代码定义在run方法中即可。 


		*/
//
//		Thread t1 = new Thread();

		Demo d1 = new Demo("旺财");
		Demo d2 = new Demo("xiaoqiang");
		d1.start();//开启线程，调用run方法。
		
		d2.start();
		System.out.println("over...."+Thread.currentThread().getName());
	}
}
//调用run和调用start有什么区别？
