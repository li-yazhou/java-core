package cn.itcast.io.p1.splitfile;

import java.io.File;
import java.io.FilenameFilter;

public class SuffixFilter implements FilenameFilter {

	private String suffix;
	
	public SuffixFilter(String suffix) {
		super();
		this.suffix = suffix;
	}

	@Override
	public boolean accept(File dir, String name) {

		return name.endsWith(suffix);
	}

}
