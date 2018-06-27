package springdata.edu.dbu.dao;

import edu.dbu.domain.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-27 15:45
 */
public class StudentDAOSpringJdbcImpl implements StudentDAO{

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Student> query() {
        final List<Student> students = new ArrayList<Student>();
        String sql = "select id, name, age from student";
        jdbcTemplate.query(sql, new RowCallbackHandler(){
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                students.add(new Student(id, name, age));
            }
        });
        return students;
    }

    @Override
    public void save(Student student) {
        String sql = "insert into student (name, age) values (?, ?)";
        jdbcTemplate.update(sql, new Object[]{student.getName(), student.getAge()});
    }
}

















