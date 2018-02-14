class ArrayDemo 
{

	public static void main(String[] args) 
	{
		//元素类型[] 数组名 = new 元素类型[元素个数或数组长度];

		
		{//局部代码块。限定局部变量的生命周期。
			int age = 3;
			System.out.println(age);
		}


		int[] arr = new int[3];

//		arr[0] = 89;
		System.out.println(arr[0]);
		for(int x=0; x<4; x++){}

	}
}


/*
内存的划分：
1，寄存器。
2，本地方法区。
3，方法区。
4，栈内存。
	存储的都是局部变量。
	而且变量所属的作用域一旦结束，该变量就自动释放。


5，堆内存。
	存储是数组和对象(其实数组就是对象) 凡是new建立在堆中。
	特点：
	1，每一个实体都有首地址值。
	2，堆内存中的每一个变量都有默认初始化值，根据类型的不同而不同。整数是0，小数0.0或者0.0f，boolean false char '\u0000'
	3，垃圾回收机制。 



*/