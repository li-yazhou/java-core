class OperateDemo 
{
	public static void main(String[] args) 
	{

		//算术运算符。 +  -  *  /  %(取余，模运算)  +(连接符) 
		// ++(自增：就在原有数据基础上+1，在赋给原有数据)  --

		//int x = 6370;
		//x = x / 1000 * 1000;
		//System.out.println(x);

//		System.out.println(5%2);
		
//		System.out.println(3+"2");
		
		//System.out.println("5+5="+(5+5));//"5+5=5"+5 "5+5=55"

		//int a = 4,b = 5;

		//System.out.println("a="+a+",b="+b);//a=4,b=5;

		int a = 3,b;
		//a++;//a = a+1;
//		b = a++;
		b = (a++)+(++a)+(a++)+a;
			//  3    5      5   6
		System.out.println("a="+a+",b="+b);

		int i = 3;
		i = i++;
		System.out.println("i="+i);

		
	}
}
