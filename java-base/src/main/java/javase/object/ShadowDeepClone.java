package javase.object;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-09 16:27
 */

import org.junit.Test;

import java.io.*;

/**
 * 自定义类 School
 */
class School implements Cloneable, Serializable{
    String name;
    public School(String name){
        this.name = name;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

/**
 * 自定义类Student
 */
class Student implements Cloneable, Serializable {
    String name;
    int age;
    School school;

    public Student(){}

    public Student(String name, int age, School school){
        this.name = name;
        this.age = age;
        this.school = school;
    }

    /**
     * @return 克隆出的对象
     * @throws CloneNotSupportedException，如果当前类没有实现Cloneable类，则抛出该异常
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * 自定义的方法，通过序列化实现深克隆
     * @return
     */
    public  Object deepClone(){
        // if (src == null) return null;
        Object src = this;
        Object obj = null;
        try {
            // 序列化
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(src);  // 将该对象序列化到 baos 中

            // 反序列化
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            obj = ois.readObject();

            // 应该在finally 代码块中关闭资源
            ois.close();
            bais.close();
            oos.close();
            baos.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return obj;
    }
}

public class ShadowDeepClone {
    School school = new School("育才小学");
    Student student = new Student("小明", 10, school);

    @Test
    public void shadowClone() throws CloneNotSupportedException {
        // 克隆对象
        Student studentCopy = (Student)student.clone();

        // 验证两个对象是不是同一个对象
        System.out.println("student == studentCopy ? " + (student == studentCopy));
        // 原始类型（基本类型）的变量的值是一样的。
        System.out.println("student.age == studentCopy.age ? " + (student.age == studentCopy.age));
        // System.out.println("student == studentCopy ? " + (student.name == studentCopy.name));
        // 引用类型的成员变量的值是一样的，也就是引用同一个对象
        System.out.println("student.school == studentCopy.school ? " + (student.school == studentCopy.school));
    }

    @Test
    public void deepClone(){
        Student studentCopy = (Student) student.deepClone();
        // 验证两个对象是不是同一个对象
        System.out.println("student == studentCopy ? " + (student == studentCopy));
        // 原始类型（基本类型）的变量的值是一样的。
        System.out.println("student.age == studentCopy.age ? " + (student.age == studentCopy.age));
        // System.out.println("student == studentCopy ? " + (student.name == studentCopy.name));
        // 引用类型的成员变量的值是一样的，也就是引用同一个对象
        System.out.println("student.school == studentCopy.school ? " + (student.school == studentCopy.school));
    }
}
