package cn.itcast.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyGetDataByIn implements GetDataInter {

	@Override
	public int getNumber() {
		
		try{
			BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
			int num = Integer.parseInt(bufr.readLine());
			
			return num;
		}
		catch(IOException e){
			throw new RuntimeException("数据没有获取成功");
		}
		
	}

}
