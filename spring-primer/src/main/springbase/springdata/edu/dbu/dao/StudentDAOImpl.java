package springdata.edu.dbu.dao;

import edu.dbu.domain.Student;
import edu.dbu.util.JDBCUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-19 21:30
 */
public class StudentDAOImpl implements StudentDAO {
    public List<Student> query(){
        List<Student> students = new ArrayList<Student>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select id, name, age from student";
        try {
            conn = JDBCUtil.getConnection();
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                students.add(new Student(id, name, age));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(resultSet, statement, conn);
        }
        return students;
    }

    public void save(Student student) {
        Connection conn = null;
        PreparedStatement statement = null;
        String sql = "insert into student (name, age) values (?, ?)";
        try {
            conn = JDBCUtil.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(null, statement, conn);
        }
    }
}
