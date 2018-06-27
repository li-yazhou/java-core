package org.alpha.commons.dbpipe.impl;

import org.alpha.commons.dbpipe.DbPipe;
import simpleorm.core.SimpleDbPipe;
import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-22 17:31
 */
public class DbPipeImplTest {
    @Test
    public void add(){
        Student student = new Student(120, "zz", 25);
        // student.setBirthday(Calendar.getInstance());
        System.out.println(student);
        new DbPipe<Student>().add(student);
    }

    @Test
    public void update(){
        Student student = new Student(12001, "2017-7-31 21:50:27", 25);
        // student.setBirthday(Calendar.getInstance());
        System.out.println(student);
        int result = new SimpleDbPipe<Student>().update(student);
        System.out.println(result);
    }

    @Test
    public void delete(){
        int result = new DbPipe<Student>().delete(1200, Student.class);
    }

    @Test
    public void queryToArray(){
        String sql = "select * from student";
        // Student[] students = (Student[])new SimpleDbPipe<Student>().queryToArray(sql);
        Object[] students = new DbPipe<Student>().queryToArray(sql);
        for(Object student : students)
            System.out.println(student);
    }
}
