/*
雇员示例：
需求：公司中程序员有姓名，工号，薪水，工作内容。
项目经理除了有姓名，工号，薪水，还有奖金，工作内容。
对给出需求进行数据建模。



分析：
在这个问题领域中，先找出涉及的对象。
通过名词提炼法。
程序员：
	属性：姓名，工号，薪水、
	行为：工作。
经理：
	属性：姓名，工号，薪水，奖金。
	行为：工作。


程序员和经理不存在着直接继承关系，

但是程序员和经理却具有共性内容。
可以进行抽取。因为他们都是公司的雇员 

可以将程序员和经理进行抽取.建立体系.
	
*/

//描述雇员。

abstract class Employee
{
	private String name;
	private String id;
	private double pay;
	Employee(String name,String id,double pay)
	{
		this.name = name;
		this.id = id;
		this.pay = pay;
	}

	public abstract void work();
	
}


//描述程序员。
class Programmer extends Employee
{
	Programmer(String name,String id,double pay)
	{
		super(name,id,pay);
	}
	public void work()
	{
		System.out.println("code...");
	}
}

//描述经理。 
class Manager extends Employee
{
	private int bonus;
	Manager(String name,String id,double pay,int bonus)
	{
		super(name,id,pay);
		this.bonus = bonus;
	}
	public void work()
	{
		System.out.println("manage");
	}
}






class  AbstractTest
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}


class Person
{
	private String name;
	private int age;

	Person(String name,int age)
	{
		this.name = name;
		this.age = age;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
}
class Student extends Person
{
	Student(String name,int age)
	{
		super(name,age);
	}

}
class Worker extends Person
{
	Worker(String name,int age)
	{
		super(name,age);
	}

}