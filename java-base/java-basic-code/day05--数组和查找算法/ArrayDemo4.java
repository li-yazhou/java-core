import java.util.*;

class ArrayDemo4 
{

	//遍历数组的功能。
	public static void printArray(int[] arr)
	{
		System.out.print("[");
		for(int x=0; x<arr.length; x++)
		{
			if(x!=arr.length-1)
				System.out.print(arr[x]+", ");
			else
				System.out.println(arr[x]+"]");
		}
	}
	public static void main(String[] args) 
	{
		int[] arr = {34,19,11,109,3,56};

//		int max = getMax_2(arr);
//		System.out.println("max="+max);

		printArray(arr);

//		selectSort(arr);
//		bubbleSort(arr);
//		Arrays.sort(arr);
		selectSort_2(arr);

		printArray(arr);
	}

	public static void swap(int[] arr,int a,int b)
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	/*
	冒泡排序。
	*/
	public static void bubbleSort(int[] arr)
	{
		for(int x=0; x<arr.length-1; x++)
		{
			for(int y=0; y<arr.length-1-x; y++)
			{
				if(arr[y]>arr[y+1])	
				{
					swap(arr,y,y+1);
					/*
					int temp  = arr[y];
					arr[y] = arr[y+1];
					arr[y+1] = temp;
					*/
				}
			}	
		}
	}


	/*
	选择排序。
	*/
	public static void selectSort(int[] arr)
	{
		for(int x=0; x<arr.length-1; x++)
		{
			for(int y=x+1; y<arr.length; y++)
			{
				if(arr[x]>arr[y])
				{
					swap(arr,x,y);
					/*
					int temp  = arr[x];
					arr[x] = arr[y];
					arr[y] = temp;
					*/
				}
			}
		}
	}

	public static void selectSort_2(int[] arr)
	{
		for(int x=0; x<arr.length-1; x++)
		{
			int num = arr[x];
			int index = x;
			for(int y=x+1; y<arr.length; y++)
			{
				if(num>arr[y])
				{
					num = arr[y];
					index = y;
				}
			}
			if(index!=x)
				swap(arr,x,index);
		}
	}


	/*
	获取数组中的最大值。
	思路：
	1，需要进行比较。并定义变量记录住每次比较后较大的值。
	2，对数组中的元素进行遍历取出，和变量中记录的元素进行比较。
		如果遍历到的元素大于变量中记录的元素，就用变量记录住该大的值。 
	3，遍历结果，该变量记录就是最大值。

	定义一个功能来是实现。
	明确一，结果。
			是数组中的元素。int .
	明确二，未知内容。
			数组.
	*/
	public static int getMax(int[] arr)
	{
		//定义变量记录较大的值。
		int maxElement = arr[0];//初始化为数组中的任意一个元素。
		for(int x=1; x<arr.length; x++)
		{
			if(arr[x]>maxElement)
				maxElement = arr[x];
		}
		return maxElement;
	}
	public static int getMax_2(int[] arr)
	{
		//定义变量记录较大的值。
		int maxIndex = 0;//初始化为数组中任意一个角标。
		for(int x=1; x<arr.length; x++)
		{
			if(arr[x]>arr[maxIndex])
				maxIndex = x;
		}
		return arr[maxIndex];
	}
}
