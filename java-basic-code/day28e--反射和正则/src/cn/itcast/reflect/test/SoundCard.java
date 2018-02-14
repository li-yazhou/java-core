package cn.itcast.reflect.test;

public class SoundCard implements PCI {
	public void open(){
		System.out.println("sound open");
	}
	public void close(){
		System.out.println("sound close");
	}

}
