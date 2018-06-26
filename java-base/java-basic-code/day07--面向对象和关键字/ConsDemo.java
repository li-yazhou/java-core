


class Person
{
	private String name;
	private int age;

	//定义一个Person类的构造函数。
	Person()//构造函数，而且是空参数的。
	{
		
		name = "baby";
		age = 1;
		System.out.println("person run");

	}
	
	
	//如果有的孩子一出生就有名字。
	Person(String n)
	{
		name = n;
	}


	public void setName(String n)
	{
		name = n;	
	}

	Person(String n,int a)
	{
		name = n;
		age = a;		
	}

	public void speak()
	{
		System.out.println(name+":"+age);
	}

}
/*
//构造函数：构建创造对象时调用的函数。作用：可以给对象进行初始化。
创建对象都必须要通过构造函数初始化。

一个类中如果没有定义过构造函数，那么该类中会有一个默认的空参数构造函数。
如果在类中定义了指定的构造函数，那么类中的默认构造函数就没有了。

一般函数和构造函数什么区别呢？

构造函数：对象创建时，就会调用与之对应的构造函数，对对象进行初始化。
一般函数：对象创建后，需要函数功能时才调用。 

构造函数：对象创建时，会调用只调用一次。
一般函数：对象创建后，可以被调用多次。


什么时候定义构造函数呢？

在描述事物时，该事物一存在就具备的一些内容，这些内容都定义在构造函数中。

构造函数可以有多个，用于对不同的对象进行针对性的初始化.
多个构造函数在类中是以重载的形式来体现的。


细节：
1，构造函数如果完成了set功能。set方法是否需要。
2，一般函数不能直接调用构造函数。
3，构造函数如果前面加了void就变成了一般函数。
4，构造函数中是有return语句的。



*/



class ConsDemo
{
	public static void main(String[] args) 
	{
		Person p = new Person();
//		p.speak();
		Person p1 = new Person("旺财");
		p1.setName("旺旺");

		p1.speak();

		Person p2 = new Person("小强",10);
		p2.speak();
	}
}



