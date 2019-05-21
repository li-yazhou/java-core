package javase.annotation.lombok;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author liyazhou1
 * @desc TODO
 * @date 2019/5/9
 */
@Slf4j
public class LombokDemo {

    @Test
    public void test_01() {
        Person p = new Person();
        p.setAge(10);
        p.setName("yz");

        Student s = new Student();
        s.setAge(11);
        s.setName("zz");
        s.setStudentId("CS10001");

        log.info("p, s = \n{}, \n{}", p, s);
        /*
            Person(name=yz, age=10),
            Student(super=Person(name=zz, age=11), studentId=CS10001, books=null)
         */

    }


    @Test
    public void test_02() {
//        Student student = Student.builder()
//                .age(100)
//                .name("zz")
//                .studentId("CS10001")
////                .book(new Book("Thinking in Java"))
////                .book(new Book())
//                .build();
//        log.info("student = \n{}", student);
    }
}

