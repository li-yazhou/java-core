/*

Object:所有类的根类。

Object是不断抽取而来，具备着所有对象都具备的共性内容。

常用的共性功能：






*/
/*
class Fu // extends Object
{
	Fu()
	{
		super();
	}
}
class Zi extends Fu
{
	Zi()
	{
		super();
	}
}
*/

class Person extends Object
{
	private int age;
	Person(int age)
	{
		this.age = age;
	}
	/*
	//比较Person的年龄。是否是同龄人
	public boolean compare(Person p)
	{
		return this.age == p.age;	
	}
	*/

	/*
	一般都会覆盖此方法，根据对象的特有内容，建立判断对象是否相同的依据。
	*/

	public boolean equals(Object obj)//Object obj = p2;
	{
		if(!(obj instanceof Person))
		{
//			return false;
			throw new ClassCastException("类型错误");
		}
		Person p = (Person)obj;
		return this.age == p.age;
	}
/*
	public int hashCode()
	{
		return age;
	}
*/

	public String toString()
	{
		return "Person :"+age;
	}
}
class Demo
{
}


class  ObjectDemo
{
	public static void main(String[] args) 
	{
		Person p1 = new Person(60);
		Person p2 = new Person(20);
		Demo d = new Demo();
//		System.out.println(p1.equals(p2));

//		System.out.println(p1);
//		System.out.println(Integer.toHexString(p1.hashCode()));
			

//		Class clazz1 = p1.getClass();
//		Class clazz2 = p2.getClass();
//		System.out.println(clazz1==clazz2);
//		System.out.println(clazz1.getName());

		System.out.println(p1.toString());//Person@61de33
		System.out.println(p1.getClass().getName()+"$"+Integer.toHexString(p1.hashCode()));//Person@61de33



//		Person p3 = p1;

//		Demo d = new Demo();

//		System.out.println(p1==p2);
//		System.out.println(p1.equals(p2));
	}
}
