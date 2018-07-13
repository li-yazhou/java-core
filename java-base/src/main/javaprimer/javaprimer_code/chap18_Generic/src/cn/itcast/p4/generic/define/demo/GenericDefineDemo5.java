package org.alpha.javabase.javaprimer.javaprimer_code.chap18_Generic.src.cn.itcast.p4.generic.define.demo;

public class GenericDefineDemo5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		InterImpl in = new InterImpl();
		in.show("abc");
		
		InterImpl2<Integer> in2 = new InterImpl2<Integer>();
		in2.show(5);
	}
}

//���ͽӿڣ������Ͷ����ڽӿ��ϡ� 
interface Inter<T>{
	public void show(T t);
}


class InterImpl2<Q> implements Inter<Q>{
	public void show(Q q){
		System.out.println("show :"+q);
	}
}




class InterImpl implements Inter<String>{
	public void show(String str){
		System.out.println("show :"+str);
	}
}