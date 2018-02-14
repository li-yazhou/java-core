class ArrayTest3 
{
	public static void main(String[] args) 
	{
//		toHex(26);
		toBinary(-6);
//		toOctal(26);
		System.out.println(Integer.toBinaryString(-6));
	}

	//十进制-->十六进制。
	public static void toHex(int num)
	{
		trans(num,15,4);
	}
	//十进制-->二进制。
	public static void toBinary(int num)
	{
		trans(num,1,1);
	}
	//十进制-->八进制。
	public static void toOctal(int num)
	{
		trans(num,7,3);
	}

	public static void trans(int num,int base,int offset)
	{

		if(num==0)
		{
			System.out.println("0");
			return ;
		}
		//定义一个对应关系表。
		char[] chs = {'0','1','2','3',
						'4','5','6','7',
						'8','9','A','B',
						'C','D','E','F'};
		/*
		一会查表会查到比较的数据。
		数据一多，就先存储起来，在进行操作。
		所以定义一个数组。 临时容器。
		*/
		char[] arr = new char[32];
		int pos = arr.length;

		while(num!=0)
		{
			int temp = num & base;
			arr[--pos] = chs[temp];
			num  = num >>> offset;
		}

		for(int x=pos ;x<arr.length; x++)
		{
			System.out.print(arr[x]);
		}
		System.out.println();

	}

}
