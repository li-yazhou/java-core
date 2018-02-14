

/*
当成员变量和局部变量重名，可以用关键字this来区分。

this : 代表对象。代表哪个对象呢？当前对象。
	   this就是所在函数所属对象的引用。
	   简单说：哪个对象调用了this所在的函数，this就代表哪个对象。

this也可以用于在构造函数中调用其他构造函数。
注意：只能定义在构造函数的第一行。因为初始化动作要先执行。
*/

class Person
{
	private String name;
	private int age;	
	Person()
	{		
		name = "baby";
		age = 1;
		System.out.println("person run");
	}	
	Person(String name)	
	{
		this();
		this.name = name;
	}
	Person(String name,int age)
	{
		this.name = name;
		this.age = age;		
	}
	public void speak()
	{
		System.out.println(this.name+":"+this.age);
	}

	/*
	判断是否是同龄人。
	*/
	public boolean compare(Person p)
	{
		/*
		if(this.age==p.age)
			return true;
		else
			return false;
		*/
		return this.age==p.age;
	}

}

class ThisDemo 
{
	public static void main(String[] args) 
	{

		Person p1 = new Person("aa",30);//
		Person p2 = new Person("zz",12);

		p2.compare(p1);
//		new Person();
//		Person p = new Person("旺财",30);
//		p.speak();
//		Person p1 = new Person("小强");
//		p1.speak();
	}
}
