package cn.itcast.p2.bean;

public class Worker extends Person {

	public Worker() {
		super();
		
	}

	public Worker(String name, int age) {
		super(name, age);
		
	}

	@Override
	public String toString() {
		
		return "Worker:"+getName()+":"+getAge();
	}
	
	
 
}
