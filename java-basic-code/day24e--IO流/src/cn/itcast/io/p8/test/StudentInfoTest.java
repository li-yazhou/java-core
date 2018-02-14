package cn.itcast.io.p8.test;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

/*
有五个学生，每个学生有3门课的成绩，定义一种比较直观的文本文件格式，
输入学生姓名和成绩，输入的格式：name,30,30,30从键盘输入以上数据（包括姓名，三门课成绩），
按总分数从高到低的顺序将学生信息存放在磁盘文件"stu.txt"中。

思路：
1，3门课的成绩都是数据，为了便于操作，将其封装到学生对象中。
	学生本身就是问题领域中涉及的对象，对学生描述。 
	学生：
		姓名，语文成绩，英语成绩，数学成绩，总分.
2，数据来源于键盘录入，将这些数据都封装到每一个学生对象中。
3，按照总分排个序，很熟，但是这些数据都存储到了学生对象中，其实是学生对象排序。
	学生对象很多，先想到的就是存起来--集合-不重复排序-TreeSet。
4，将排序后的信息写入到一个文件中。定义操作文件的输出流。
 	将信息写入到文件中。 

aa,10,30,50
zz,30,60,30
qq,30,90,70
cc,70,80,90
pp,80,80,80
*/

public class StudentInfoTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		Comparator<Student> comp = Collections.reverseOrder();
		comp = Collections.reverseOrder(new ComparatorByMath());
		Set<Student> set = StudentInfoTool.getStudents(comp);
		
		
		File file = new File("stuinfo.txt");
		StudentInfoTool.write2File(set, file);
	}

}
