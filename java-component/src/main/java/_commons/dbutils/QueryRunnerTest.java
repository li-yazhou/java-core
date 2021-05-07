package _commons.dbutils;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;



/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-26 15:49
 */
public class QueryRunnerTest {
    private Connection conn = null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void initConnection() throws SQLException {
        printCurrentMethodName();
        conn = DriverManager.getConnection("jdbc:mysql:///dbpipe", "root", "root");
    }

    @After
    public void closeSource() throws SQLException {
        printCurrentMethodName();
        DbUtils.closeQuietly(conn);
    }

    public void printCurrentMethodName(){
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        System.out.println("--------------------------------");
        System.out.println(methodName + "\n");
    }

    /**
     * 插入数据
     * @throws SQLException
     */
    @Test
    public void insert() throws SQLException {
        printCurrentMethodName();
        QueryRunner queryRunner = new QueryRunner();
        Student student = new Student("kk", 10);
        String sql = "insert into student (name, age) values (?,?)";
        Object[] params = {student.getName(), student.getAge()};
        queryRunner.update(conn, sql, params);
    }

    /**
     * 更新数据
     * @throws SQLException
     */
    @Test
    public void update() throws SQLException {
        printCurrentMethodName();
        QueryRunner queryRunner = new QueryRunner();
        Student student = new Student(11, "kkkkkk", 110);
        String sql = "update student set name = ?, age = ? where student_id = ?";
        Object[] params = {student.getName(), student.getAge(), student.getId()};
        queryRunner.update(conn, sql, params);
    }


    /**
     * 删除数据
     * @throws SQLException
     */
    @Test
    public void delete() throws SQLException {
        printCurrentMethodName();
        QueryRunner queryRunner = new QueryRunner();
        Student student = new Student(11, "kkkkkk", 110);
        String sql = "delete from student where student_id = ?";
        // Object[] params = {student.getId()};
        queryRunner.update(conn, sql, student.getId());
    }


    // -----------------------查询数据-----------------------

    /**
     * ScalarHandler，取出结果中的第一个元素
     */
    @Test
    public void queryByScalarHandler() throws SQLException{
        printCurrentMethodName();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select count(*) from student";
        long count = (Long)queryRunner.query(conn, sql, new ScalarHandler());
        System.out.println("count = " + count);
    }

    /**
     * BeaHandler，将结果集的第一行转换为Bean
     * @throws SQLException
     */
    @Test
    public void queryByBeanHandler() throws SQLException {
        printCurrentMethodName();
        QueryRunner queryRunner = new QueryRunner();
        // Student student = new Student(11, "kkkkkk", 110);
        String sql = "select * from student where student_id = ?";
        // Object[] params = {student.getId()};
        // @Deprecated，sql的参数由数组修改为可变参数，下面的方法是过时的
        // queryRunner.query(conn, sql, student.getId(), new BeanHandler(Student.class));
        Student student = queryRunner.query(conn, sql, new BeanHandler<Student>(Student.class), 10);
        System.out.println(student);
    }

    /**
     * BeanListHandler，将结果集的每一行转换成一个Bean对象并放入List集合中
     * @throws SQLException
     */
    @Test
    public void queryByBeanListHandler() throws SQLException{
        printCurrentMethodName();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from student";
        List<Student> studentList = queryRunner.query(conn, sql, new BeanListHandler<Student>(Student.class));
        System.out.println(studentList);
    }


    /**
     * ArrayHandler，会返回一个数组，用于将结果集第一行数据转换为数组。
     */
    @Test
    public void queryByArrayHandler() throws SQLException{
        printCurrentMethodName();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from student";
        // Student[] students = (Student[])queryRunner.query(conn, sql, new ArrayHandler());
        Object[] students = queryRunner.query(conn, sql, new ArrayHandler());
        System.out.println(Arrays.toString(students));
    }


    /**
     * ArrayListHandler，会将结果的每一行转换为一个数组，并把它加入list中
     */
    @Test
    public void queryByArrayListHandler() throws SQLException{
        printCurrentMethodName();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from student";
        List<Object[]> results = queryRunner.query(conn, sql, new ArrayListHandler());
        for (Object[] result : results)
            System.out.println(Arrays.toString(result));
    }

}
