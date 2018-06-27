package edu.dbu.dao;

import edu.dbu.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-27 15:59
 */
public class StudentDAOJdbcTemplateImplTest {
    private ApplicationContext ctx = null;
    private StudentDAO studentDAOJdbcTemplateImpl = null;

    @Test
    public void testQuery(){
        printCurrentMethodName();
        List<Student> studentList = studentDAOJdbcTemplateImpl.query();
        for (Student student : studentList)
            System.out.println(student);
    }

    @Test
    public void testSave(){
        printCurrentMethodName();
        Student student = new Student(100, "xxx", 100);
        studentDAOJdbcTemplateImpl.save(student);
    }


    @Before
    public void setup(){
        printCurrentMethodName();
        ctx = new ClassPathXmlApplicationContext("jdbc-beans.xml");
        studentDAOJdbcTemplateImpl = ctx.getBean("studentDAOSpringJdbcImpl", StudentDAO.class);
    }

    @After
    public void tearDown(){
        printCurrentMethodName();
        ctx = null;
    }

    private void printCurrentMethodName(){
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        System.out.println(methodName + "\n");
    }
}
