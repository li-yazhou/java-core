package springdata.edu.dbu.domain;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-19 21:27
 */
public class Student {
    private int id;
    private String name;
    private int age;

    public Student(){}

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString(){
        return String.format("[id = %d, name = %s, age = %d]", getId(), getName(),getAge());
    }
}

