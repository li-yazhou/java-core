package cn.itcast.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyGetDataByFile implements GetDataInter {

	@Override
	public int getNumber() {

		try{
			BufferedReader bufr = new BufferedReader(new FileReader("number.txt"));
			int num = Integer.parseInt(bufr.readLine());
			
			return num;
		}
		catch(IOException e){
			throw new RuntimeException("数据没有获取成功");
		}
	}

}
