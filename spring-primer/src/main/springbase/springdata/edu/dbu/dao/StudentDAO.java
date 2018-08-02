package springdata.edu.dbu.dao;

import edu.dbu.domain.Student;

import java.util.List;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-19 21:29
 */
public interface StudentDAO {
    List<Student> query();

    void save(Student student);
}
