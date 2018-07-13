package org.alpha.javabase.javabook.fkjava.ch14_annotation;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-12 20:36
 */

// @Persistent(table = "person")
@Persistent(table = "person")
public class Person {
    // @Property(column="name", type="string")
    // @Property(type="string")
    @Property()
    private String name;
    @Property(column="gender", type="String")
    private String gender;
    @Property(column="age", type="int")
    private int age;

    public Person(){}

    public Person(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
