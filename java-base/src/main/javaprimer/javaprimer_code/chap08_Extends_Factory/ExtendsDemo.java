
/*
继承的好处：
	1，提高了代码的复用性。
	2，让类与类之间产生了关系，给第三个特征多态提供了前提.



java中支持单继承。不直接支持多继承，但对C++中的多继承机制进行改良。

单继承：一个子类只能有一个直接父类。

多继承：一个子类可以有多个直接父类(java中不允许,进行改良)
		不直接支持，因为多个父类中有相同成员，会产生调用不确定性。
		在java中是通过"多实现"的方式来体现。


java支持多层(多重)继承。

C继承B，B继承A。
就会出现继承体系。

当要使用一个继承体系时，
1，查看该体系中的顶层类，了解该体系的基本功能。
2，创建体系中的最子类对象，完成功能的使用。 

class Demo
{
	void show1(){}
}


class DemoA extends Demo
{
//	void show1(){}
	void show2(){}
}
class DemoB extends Demo
{
//	void show1(){}
	void show3(){}
}

什么时候定义继承呢？

当类与类之间存在着所属关系的时候，就定义继承。xxx是yyy中的一种。 xxx extends yyy

所属关系： is a 关系。




*/
/*
class A
{
	void show()
	{
		System.out.println("a");
	}
}
class B 
{
	void show()
	{
		System.out.println("b");
	}
}
class C extends A,B
{
}
new C().show();
*/
class Person
{
	String name;
	int age;
}



class Student extends/*继承*/ Person
{
//	String name;
//	int age;
	void study()
	{
		System.out.println(name+"...student study.."+age);
	}
}


class Worker extends Person
{
//	String name;
//	int age;
	void work()
	{
		System.out.println("worker work");
	}
}


class ExtendsDemo 
{
	public static void main(String[] args) 
	{
		Student s = new Student();
		s.name= "zhangsan";
		s.age = 22;
		s.study();
	}
}
