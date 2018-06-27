package springdata.edu.dbu.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * description:
 *  获取Connection
 *  释放资源
 * @author liyazhou
 * @since 2017-07-19 19:23
 */
public class JDBCUtil {

    /**
     * 获取Connection
     * @return Connection
     * @throws Exception
     */
    public static Connection getConnection() throws Exception{
        // String url = "jdbc:mysql:///spring_data";
        // String user = "root";
        // String pwd = "root";
        // String driverClass = "com.mysql.jdbc.Driver";
        // InputStream inputStream = JDBCUtil.class.getResourceAsStream("db.properties");
        InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        String driverClass = properties.getProperty("jdbc.driverClass");
        String user = properties.getProperty("jdbc.user");
        String pwd = properties.getProperty("jdbc.pwd");
        String url = properties.getProperty("jdbc.url");
        Class.forName(driverClass);
        return DriverManager.getConnection(url, user, pwd);
    }


    /**
     * 释放资源
     * @param resultSet 结果集
     * @param statement 语句
     * @param connection 连接
     */
    public static void release(ResultSet resultSet, Statement statement, Connection connection){
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}





















