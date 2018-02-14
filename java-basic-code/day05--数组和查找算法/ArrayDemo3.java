class ArrayDemo3
{
	public static void main(String[] args) 
	{
		//格式1
		/*
		需要一个容器，但是不明确容器的具体数据。
		*/
//		int[] arr = new int[3];


		/*
		需要一个容器，存储已知的具体数据。
		*/
		//元素类型[] 数组名 = new 元素类型[]{元素，元素，……};
//		int[] arr = new int[]{89,34,270,17};
		int[] arr = {89,34,270,17};

		/*
		对数组操作最基本的动作就是存和取。
		核心思想：就是对角标的操作。
		
		*/

		System.out.println("length:"+arr.length);
		for(int x=0; x<arr.length ; x++)
		{
			System.out.println("arr["+x+"] = "+arr[x]+";");//arr[0] = 89;
		}

		for(int x=arr.length-1; x>=0; x--)
		{
			System.out.println("arr["+x+"] = "+arr[x]+";");//arr[0] = 89;
		}
//		System.out.println(arr[1]);
//		System.out.println(arr[2]);
//		System.out.println(arr[3]);
		





	}
}
