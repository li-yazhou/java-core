
/*
用java语言对现实生活中的事物进行描述。
通过类的形式来体现的。

怎么描述呢？
对于事物描述通常只关注两方面。
一个是属性，一个是行为。

只要明确该事物的属性和行为并定义在类中即可。

对象：其实就是该类事物实实在在存在的个体。

类与对象之间的关系？
类：事物的描述。
对象：该类事物的实例。在java中通过new来创建的。

*/


/*

描述小汽车

分析：
1，属性。
	轮胎数。
	颜色。 
2，行为。
	运行。



定义类其实就是在定义类中的成员。
成员：成员变量<-->属性，成员函数<-->行为。


成员变量和局部变量的区别：

1，
成员变量定义在类中，整个类中都可以访问。
局部变量定义在函数，语句，局部代码块中，只在所属的区域有效。

2，
成员变量存在于堆内存的对象中。
局部变量存在于栈内存的方法中。

3，
成员变量随着对象的创建而存在，随着对象的消失而消失。
局部变量随着所属区域的执行而存在，随着所属区域的结束而释放。

4，
成员变量都有默认初始化值。
局部变量没有默认初始化值。 



*/
class Car
{
	int num;
	String color;
	
	void run()
	{
		//int num = 10;
		System.out.println(num+"..."+color);
	}

}





class  CarDemo
{
	public static void main(String[] args) 
	{
		//在计算机中创建一个car的实例。通过new关键字。 
//		Car c = new Car();// c就是一个类类型的引用变量，指向了该类的对象。
//		c.num = 4;
//		c.color = "red";

//		c.run();//要使用对象中的内容可以通过  对象.成员 的形式来完成调用。

		

//		Car c1 = new Car();
//		c1.num = 4;
//		c1.color = "red";

//		Car c2 = new Car();
//		c2.num = 4;
//		c2.color = "red";

//		Car c1 = new Car();
//		Car c2 = new Car();
//		show(c1);
//		show(c2);

		/*
		匿名对象。没有名字的对象 。
		new Car();//匿名对象。其实就是定义对象的简写格式。



		Car c = new Car();
		c.run();

		new Car().run();
	

		1，当对象对方法仅进行一次调用的时候，就可以简化成匿名对象。
		
		new Car().num = 5;
		new Car().color = "green";
		new Car().run();

		2，匿名对象可以作为实际参数进行传递。

		*/

//		Car c1 = new Car();
//		show(c1);
		show(new Car());
	}

	//汽车改装厂。
	public static void show(Car c)//类类型的变量一定指向对象。要不就是null。 
	{
		c.num = 3;
		c.color = "black";
		System.out.println(c.num+"..."+c.color);
	}
}
