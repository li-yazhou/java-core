
/*
死锁：常见情景之一：同步的嵌套。

*/
class Ticket implements Runnable
{
	private  int num = 100;
	Object obj = new Object();
	boolean flag = true;
	public void run()
	{


		if(flag)
			while(true)
			{
				synchronized(obj)
				{
					show();
				}
			}
		else
			while(true)
				this.show();
	}

	public synchronized void show()
	{

		synchronized(obj)
		{
			if(num>0)
			{
				try{Thread.sleep(10);}catch (InterruptedException e){}
				
				System.out.println(Thread.currentThread().getName()+".....sale...."+num--);
			}
		}
	}
}


class DeadLockDemo 
{
	public static void main(String[] args) 
	{
		Ticket t = new Ticket();
//		System.out.println("t:"+t);

		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);

		t1.start();
		try{Thread.sleep(10);}catch(InterruptedException e){}
		t.flag = false;
		t2.start();
	}
}
