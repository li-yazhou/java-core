package cn.itcast.io.p8.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class StudentInfoTool {

	/**
	 * 定义功能，获取键盘录入的信息。 并将信息封装成学生对象。存储到容器中。
	 * 按照学生的自然排序完成排序动作。 
	 * @return
	 * @throws IOException
	 */
	public static Set<Student> getStudents() throws IOException {
		
		return getStudents(null);
	}
	/**
	 * 定义功能，获取键盘录入的信息。 并将信息封装成学生对象。存储到容器中。
	 * 按照指定比较器完成排序的动作。
	 * 
	 * @throws IOException
	 */

	public static Set<Student> getStudents(Comparator<Student> comp) throws IOException {

		// 获取键盘录入。
		BufferedReader bufr = new BufferedReader(new InputStreamReader(
				System.in));

		// 创建一个集合对象。TreeSet.
		Set<Student> set = null;
		
		if(comp==null)
			set = new TreeSet<Student>();
		else
			set = new TreeSet<Student>(comp);
		String line = null;

		while ((line = bufr.readLine()) != null) {

			if ("over".equals(line))// 定义键盘录入的结束标记。
				break;

			// 对获取的信息进行切割，获取指定的数据内容。
			String[] info_arr = line.split(",");
			Student stu = new Student(info_arr[0],
					Integer.parseInt(info_arr[1]),
					Integer.parseInt(info_arr[2]),
					Integer.parseInt(info_arr[3]));

			// 把学生对象存储到集合中去。
			set.add(stu);
		}

		return set;
	}

	/**
	 * 定义功能，将集合中的对象信息写入到指定文件中进行存储。
	 * 
	 * @throws IOException
	 */
	public static void write2File(Set<Student> set, File file)
			throws IOException {

		BufferedWriter bufw = null;
		try {
			bufw = new BufferedWriter(new FileWriter(file));

			for (Student stu : set) {
				bufw.write(stu.toString() + "\t"+stu.getSum());				
				bufw.newLine();
				bufw.flush();
			}
		} finally {
			if (bufw != null)
				bufw.close();
		}

	}
}
