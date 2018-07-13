class OperateTest2 
{
	public static void main(String[] args) 
	{

		/*
		对一个整数的最后一个字节，高四位和低四位进行换位。

		int num = 0101-1100 & 255;
		1100-0101

		61 = 0011-1101
			 1101-0011 = 211


		*/
		int num = 61;
		
		int n1 = num & 15;//低四位
		int n2 = num & (15<<4);//高四位


		int n = n1<<4 | n2>>>4;


		System.out.println("n="+n);
		

	}
}
