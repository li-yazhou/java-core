

/*
在子父类中，成员的特点体现。
1，成员变量。
2，成员函数。
3，构造函数。



*/

//1，成员变量。

/*
当本类的成员和局部变量同名用this区分。
当子父类中的成员变量同名用super区分父类。

this和super的用法很相似。

this:代表一个本类对象的引用。
super：代表一个父类空间。



*/
class Fu
{
	private int num = 4;

	public int getNum()
	{
		return num;
	}
}


class Zi extends Fu
{
	private int num = 5;


	void show()
	{
		System.out.println(this.num+"....."+super.getNum());
	}
}


class ExtendsDemo2 
{
	public static void main(String[] args) 
	{
		Zi z = new Zi();
		z.show();
	}
}
