package cn.itcast.io.p8.test;

import java.util.Comparator;

public class ComparatorByMath implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {

		int temp = o1.getMa() - o2.getMa();
		
		return temp==0?o1.getName().compareTo(o2.getName()):temp;
	}

}
