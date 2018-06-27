package org.alpha.commons.dbpipe.impl;

import org.alpha.commons.dbpipe.auxiliary.Column;
import org.alpha.commons.dbpipe.auxiliary.Id;
import org.alpha.commons.dbpipe.auxiliary.Table;

import java.util.Calendar;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-22 17:31
 */
/*
    create database dbpipe;
    create table student(
        student_id int(11) not null auto_increment,
        name varchar(32) not null,
        age int(11),
        birthday date,
        primary key(student_id)
    );
 */
@Table(name="student")
public class Student {
    @Id(name = "student_id")
    private int studentNo;
    @Column(name = "name")
    private String name;
    @Column(name = "age", type = "int")
    private int age;
    @Column(name = "birthday", type = "Calendar")
    private Calendar birthday;

    public Student(){ super(); }
    public Student(int studentNo, String name, int age){
        this.studentNo = studentNo;
        this.name = name;
        this.age = age;
    }

    public int getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
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

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNo=" + studentNo +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
