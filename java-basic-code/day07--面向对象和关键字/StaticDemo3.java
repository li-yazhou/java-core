/*
静态什么时候用？
1，静态变量。
	当分析对象中所具备的成员变量的值都是相同的 。
	这时这个成员就可以被静态修饰。
	只要数据在对象中都是不同的，就是对象的特有数据，必须存储在对象中，是非静态的。
	如果是相同的数据，对象不需要做修改，只需要使用即可，不需要存储在对象中，定义成静态的。

2，静态函数。
	函数是否用静态修饰，就参考一点，就是该函数功能是否有访问到对象中的特有数据。
	简单点说，从源代码看，该功能是否需要访问非静态的成员变量，如果需要，该功能就是非静态的。
	如果不需要，就可以将该功能定义成静态的。当然，也可以定义成非静态，
	但是非静态需要被对象调用，而仅创建对象调用非静态的
	没有访问特有数据的方法，该对象的创建是没有意义。

*/

class Demo
{
	int age ;
	static int num = 9;
	Demo(int age)
	{
		this.age = age;
	}

	public static  void speak()
	{
		System.out.println(num);
	}
	public void show()
	{
		System.out.println(age);
	}

}

class  StaticDemo3
{
	public static void main(String[] args) 
	{
//		Demo d = new Demo(30);
//		d.speak();
		Demo.speak();

//		System.out.println("Hello World!");
	}
}
