package cn.itcast.io.p2.objectstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import cn.itcast.io.p2.bean.Person;

public class ObjectStreamDemo {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
			
//		writeObj();
		readObj();
	}

	public static void readObj() throws IOException, ClassNotFoundException {
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.object"));
		//对象的反序列化。 
		Person p = (Person)ois.readObject();
		
		System.out.println(p.getName()+":"+p.getAge());
		
		ois.close();
		
	}

	public static void writeObj() throws IOException, IOException {
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.object"));
		//对象序列化。  被序列化的对象必须实现Serializable接口。 
		oos.writeObject(new Person("小强",30));
		
		oos.close();
		
		
		
	}

}
