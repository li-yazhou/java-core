package edu.dbu.dao;

import edu.dbu.domain.Student;
import org.junit.Test;

import java.util.List;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-19 21:42
 */
public class StudentDAOImplTest {

    @Test
    public void testQuery(){
        StudentDAO dao = new StudentDAOImpl();
        List<Student> students = dao.query();
        for (Student student : students){
            System.out.println(student);
        }
    }

    @Test
    public void testSave(){
        Student student = new Student();
        student.setName("nn");
        student.setAge(25);
        new StudentDAOImpl().save(student);
    }
}
