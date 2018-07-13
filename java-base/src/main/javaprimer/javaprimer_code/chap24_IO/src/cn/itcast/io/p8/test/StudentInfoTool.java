package org.alpha.javabase.javaprimer.javaprimer_code.chap24_IO.src.cn.itcast.io.p8.test;

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
	 * ���幦�ܣ���ȡ����¼�����Ϣ�� ������Ϣ��װ��ѧ�����󡣴洢�������С�
	 * ����ѧ������Ȼ��������������� 
	 * @return
	 * @throws IOException
	 */
	public static Set<Student> getStudents() throws IOException {
		
		return getStudents(null);
	}
	/**
	 * ���幦�ܣ���ȡ����¼�����Ϣ�� ������Ϣ��װ��ѧ�����󡣴洢�������С�
	 * ����ָ���Ƚ����������Ķ�����
	 * 
	 * @throws IOException
	 */

	public static Set<Student> getStudents(Comparator<Student> comp) throws IOException {

		// ��ȡ����¼�롣
		BufferedReader bufr = new BufferedReader(new InputStreamReader(
				System.in));

		// ����һ�����϶���TreeSet.
		Set<Student> set = null;
		
		if(comp==null)
			set = new TreeSet<Student>();
		else
			set = new TreeSet<Student>(comp);
		String line = null;

		while ((line = bufr.readLine()) != null) {

			if ("over".equals(line))// �������¼��Ľ�����ǡ�
				break;

			// �Ի�ȡ����Ϣ�����и��ȡָ�����������ݡ�
			String[] info_arr = line.split(",");
			Student stu = new Student(info_arr[0],
					Integer.parseInt(info_arr[1]),
					Integer.parseInt(info_arr[2]),
					Integer.parseInt(info_arr[3]));

			// ��ѧ������洢��������ȥ��
			set.add(stu);
		}

		return set;
	}

	/**
	 * ���幦�ܣ��������еĶ�����Ϣд�뵽ָ���ļ��н��д洢��
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
