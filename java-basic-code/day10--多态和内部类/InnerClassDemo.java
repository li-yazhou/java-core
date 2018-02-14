/*
内部类访问特点：
1，内部类可以直接访问外部类中的成员。
2，外部类要访问内部类，必须建立内部类的对象。


一把用于类的设计。

分析事物时，发现该事物描述中还有事物，而且这个事物还在访问被描述事物的内容。
这时就是还有的事物定义成内部类来描述。



*/
class Outer
{
	private static int num = 31;

	class Inner// 内部类。
	{
		void show()
		{
			System.out.println("show run..."+num);
		}
		/*static void function()//如果内部类中定义了静态成员，该内部类也必须是静态的。
		{
			System.out.println("function run ...."+num);
		}
		*/
	}

	public void method()
	{
		Inner in = new Inner();
		in.show();
	}
}


class InnerClassDemo
{
	public static void main(String[] args) 
	{
//		Outer out = new Outer();
//		out.method();
		//直接访问外部类中的内部类中的成员。
//		Outer.Inner in = new Outer().new Inner();
//		in.show();

		//如果内部类是静态的。 相当于一个外部类
//		Outer.Inner in = new Outer.Inner();
//		in.show();

		//如果内部类是静态的，成员是静态的。
//		Outer.Inner.function();
		
	}
}
