/*
jdk1.5以后将同步和锁封装成了对象。 
并将操作锁的隐式方式定义到了该对象中，
将隐式动作变成了显示动作。

Lock接口： 出现替代了同步代码块或者同步函数。将同步的隐式锁操作变成现实锁操作。
同时更为灵活。可以一个锁上加上多组监视器。
lock():获取锁。
unlock():释放锁，通常需要定义finally代码块中。


Condition接口：出现替代了Object中的wait notify notifyAll方法。
			将这些监视器方法单独进行了封装，变成Condition监视器对象。
			可以任意锁进行组合。
await();
signal();
signalAll();



*/

import java.util.concurrent.locks.*;

class Resource
{
	private String name;
	private int count = 1;
	private boolean flag = false;

//	创建一个锁对象。
	Lock lock = new ReentrantLock();

	//通过已有的锁获取该锁上的监视器对象。
//	Condition con = lock.newCondition();

	//通过已有的锁获取两组监视器，一组监视生产者，一组监视消费者。
	Condition producer_con = lock.newCondition();
	Condition consumer_con = lock.newCondition();

	
	public  void set(String name)//  t0 t1
	{
		lock.lock();
		try
		{
			while(flag)
//			try{lock.wait();}catch(InterruptedException e){}//   t1    t0
			try{producer_con.await();}catch(InterruptedException e){}//   t1    t0
		
			this.name = name + count;//烤鸭1  烤鸭2  烤鸭3
			count++;//2 3 4
			System.out.println(Thread.currentThread().getName()+"...生产者5.0..."+this.name);//生产烤鸭1 生产烤鸭2 生产烤鸭3
			flag = true;
//			notifyAll();
//			con.signalAll();
			consumer_con.signal();
		}
		finally
		{
			lock.unlock();
		}
		
	}

	public  void out()// t2 t3
	{
		lock.lock();
		try
		{
			while(!flag)
//			try{this.wait();}catch(InterruptedException e){}	//t2  t3
			try{cousumer_con.await();}catch(InterruptedException e){}	//t2  t3
			System.out.println(Thread.currentThread().getName()+"...消费者.5.0......."+this.name);//消费烤鸭1
			flag = false;
//			notifyAll();
//			con.signalAll();
			producer_con.signal();
		}
		finally
		{
			lock.unlock();
		}
		
	}
}

class Producer implements Runnable
{
	private Resource r;
	Producer(Resource r)
	{
		this.r = r;
	}
	public void run()
	{
		while(true)
		{
			r.set("烤鸭");
		}
	}
}

class Consumer implements Runnable
{
	private Resource r;
	Consumer(Resource r)
	{
		this.r = r;
	}
	public void run()
	{
		while(true)
		{
			r.out();
		}
	}
}



class  ProducerConsumerDemo2
{
	public static void main(String[] args) 
	{
		Resource r = new Resource();
		Producer pro = new Producer(r);
		Consumer con = new Consumer(r);

		Thread t0 = new Thread(pro);
		Thread t1 = new Thread(pro);
		Thread t2 = new Thread(con);
		Thread t3 = new Thread(con);
		t0.start();
		t1.start();
		t2.start();
		t3.start();

	}
}

