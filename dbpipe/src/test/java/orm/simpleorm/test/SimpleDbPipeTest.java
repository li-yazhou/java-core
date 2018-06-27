package orm.simpleorm.test;

import org.junit.Test;
import simpleorm.core.SimpleDbPipe;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-20 16:19
 */
public class SimpleDbPipeTest {
    private static SimpleDbPipe<Student> dbPipe = new SimpleDbPipe<Student>();

    @Test
    public void addTest(){
        Student student = null;
        for (int i = 0; i < 10; i ++){
            student = new Student(i, "zhouzhou_" + i, i * 2);
            dbPipe.add(student);
        }
    }

    @Test
    public void updateTest(){
        Student student = null;
        for (int i = 0; i < 10; i ++){
            student = new Student(i, "new_zhouzhou_" + i, i * 2);
            dbPipe.update(student);
        }
    }
}
