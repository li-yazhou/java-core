/*
二维数组定义的格式。
*/


class  Array2Demo
{
	public static void main(String[] args) 
	{

//		int[] arr = new int[3];  
//		System.out.println(arr);//[I@1fb8ee3  @左边是实体的类型。 @右边是实体的哈希值。

//		int[][] arr = new int[3][2];//创建一个二维数组，该数组中有3个一维数组，每一个一维数组中有2个元素。
//		System.out.println(arr);//直接打印二维数组。   [[I@c17164
//		System.out.println(arr[0]);//直接打印二维数组中的角标0的一维数组。 [I@1fb8ee3
//		System.out.println(arr[0][0]);//直接打印二维数组中的角标0的一维数组中角标为0的元素。 0



//		int[][] arr = new int[3][];
//		System.out.println(arr);//直接打印二维数组。   [[I@c17164
//		System.out.println(arr[0]);//直接打印二维数组中的角标0的一维数组。null
//		System.out.println(arr[0][0]);//直接打印二维数组中的角标0的一维数组中角标为0的元素。 NullPointerException


	
//		int[][] arr = new int[3][2];
//		System.out.println(arr.length);//打印二维数组的长度。其实就是一维数组的个数。
//		System.out.println(arr[1].length);//打印二维数组中角标为1一维数组的长度。

		int sum = 0;
		int[][] arr = {{3,1,7},{5,8,2,9},{4,1}};

		for(int x=0; x<arr.length; x++)
		{
			for(int y=0; y<arr[x].length; y++)
			{
//				System.out.print(arr[x][y]+",");
				sum += arr[x][y];
				
			}
		}
		System.out.println("sum="+sum);


//		甲：30 59 28 17
//		乙；37 60 22 19
//		int[] arr = {{30,59,28,17},{37,60,22,19}};

		int[][][] arr = new int[3][2][4];
	}
}

/*
int[] x,y[];
int[] x;
int[] y[];


a
x = y;

b
x = y[0];

c
x[0] = y[0];

d
x[0] = y[0][0];

e
x[0] = y;
*/