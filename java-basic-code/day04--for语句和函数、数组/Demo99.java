/*
需求：
打印一个99乘法表。

思路：
1，定义一个类。
2，为了可以运行，该类中定义一个main函数。
3，将99惩罚表的代码定义在main函数中。


步骤：
1，用class关键字定义名称Demo99为的类。
2，定义main函数。
3，
1*1=1
1*2=2 2*2=4
1*3=3 2*3=6 3*3=9
分析一下99乘法表。


*/
class Demo99
{
	public static void main(String[] args)
	{
		/*
		99乘法表的分析：
		。。。
		符合了大圈套小圈的思想。
		就是要使用 for嵌套循环。
		*/
		//int z = 1;
		for (int x = 1;x<=9 ;x++ )
		{

			 for (int y=1; y<=x ; y++)//
			 {
				 System.out.print(y+"*"+x+"="+y*x+"\t");
			 }
			 System.out.println();//

//			 z++;
		}

	}
}

