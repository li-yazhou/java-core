package cn.itcast.io.p2.filter;

import java.io.File;
import java.io.FilenameFilter;

public class FilterByJava implements FilenameFilter {

	@Override
	public boolean accept(File dir, String name) {

//		System.out.println(dir+"---"+name);
		
		return name.endsWith(".txt");
	}

}
