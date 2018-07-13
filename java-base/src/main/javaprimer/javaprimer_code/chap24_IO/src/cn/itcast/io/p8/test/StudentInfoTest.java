package org.alpha.javabase.javaprimer.javaprimer_code.chap24_IO.src.cn.itcast.io.p8.test;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

/*
�����ѧ����ÿ��ѧ����3�ſεĳɼ�������һ�ֱȽ�ֱ�۵��ı��ļ���ʽ��
����ѧ�������ͳɼ�������ĸ�ʽ��name,30,30,30�Ӽ��������������ݣ��������������ſγɼ�����
���ܷ����Ӹߵ��͵�˳��ѧ����Ϣ����ڴ����ļ�"stu.txt"�С�

˼·��
1��3�ſεĳɼ��������ݣ�Ϊ�˱��ڲ����������װ��ѧ�������С�
	ѧ��������������������漰�Ķ��󣬶�ѧ�������� 
	ѧ����
		���������ĳɼ���Ӣ��ɼ�����ѧ�ɼ����ܷ�.
2��������Դ�ڼ���¼�룬����Щ���ݶ���װ��ÿһ��ѧ�������С�
3�������ܷ��Ÿ��򣬺��죬������Щ���ݶ��洢����ѧ�������У���ʵ��ѧ����������
	ѧ������ܶ࣬���뵽�ľ��Ǵ�����--����-���ظ�����-TreeSet��
4������������Ϣд�뵽һ���ļ��С���������ļ����������
 	����Ϣд�뵽�ļ��С� 

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
