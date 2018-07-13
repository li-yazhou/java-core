
/*
人：
属性：
	年龄。

行为：
	说话。

*/

/*
private:私有，是一个权限修饰符。用于修饰成员。
		私有的内容只在本类中有效。

注意：私有仅仅是封装的一种体现而已。


*/
class Person
{
	private /*私有*/int age;

	public void setAge(int a)//setXxx getXxx
	{
		age = a;
	}
	public int getAge()
	{
		return age;
	}
	/*
	public void haha(int a)
	{
		if(a>0 && a<130)
		{
			age = a;
			speak();
		}
		else
			System.out.println("错误的数据");
	}
	*/
	void speak()
	{
		System.out.println("age="+age);
	}
}

class  PersonDemo
{
	public static void main(String[] args) 
	{
		Person p = new Person();
//		p.age = -20;
		p.haha(-20);
//		p.speak();
	}

	public static void selectSort(int[] arr){}

	private static void swap(int[] arr,int a,int b){}
}
