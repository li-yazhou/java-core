package org.alpha.javabase.javaprimer.javaprimer_code.chap21_IO.src.cn.itcast.p5.wrapper;

public class PersonDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Person p = new Person();
//		p.chifan();
		
		NewPerson p1 = new NewPerson(p);
		p1.chifan();
		
		NewPerson2 p2 = new NewPerson2();
		p2.chifan();
	}

}

class Person{
	void chifan(){
		System.out.println("�Է�");
	}
}
//�����ĳ�����Ϊ����ǿPerson�����ֵġ�
class NewPerson{
	private Person p ;
	NewPerson(Person p){
		this.p = p;
	}
	
	public void chifan(){
		System.out.println("��θ��");
		p.chifan();
		System.out.println("���");
		
	}

}

class NewPerson2 extends Person{
	public void chifan(){
		System.out.println("��θ��");
		super.chifan();
		System.out.println("���");
	}
}













