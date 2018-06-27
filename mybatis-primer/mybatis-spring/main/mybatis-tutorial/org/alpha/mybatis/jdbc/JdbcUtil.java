package org.alpha.mybatis.jdbc;

import org.junit.Test;

import java.sql.*;


public class JdbcUtil {


    public static void main(String... args){
        String database = "jdbc:mysql:///mybatis-db";
        String user = "root";
        String password = "root";

        // 数据库连接
        Connection conn = null;
        // 预编译的Statement，通过Statement向数据库发送一个SQL语句，
        // 数据库需要编译该SQL语句，将编译结果存放到数据库端的缓存中，
        // 如果下次再发送相同的SQL语句，数据库不会再次编译，而是直接执行编译好的语句
        // 提高数据库的性能
        PreparedStatement pstat = null;
        ResultSet resultSet = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(database, user, password);

            // 预编译类型的SQL，?表示占位符，从1开始计数
            String sql = "select * from user where username = ?";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, "lyz");
            resultSet = pstat.executeQuery();
            // while(resultSet.next()){}
            if (resultSet.next()) {
                String id = resultSet.getString(1);
                String username = resultSet.getString(2);
                System.out.println(id + ", " + username);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }



    }

    @Test
    public void testConn() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql:///mybatis-db", "root", "root");
        Statement stat = conn.createStatement();
        ResultSet resultSet = stat.executeQuery("select * from user where username = 'lyz'");
        while(resultSet.next()){
            // int id = resultSet.getInt(1);
            int id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            System.out.printf("id = %d, username = %s\n", id, username);
        }
    }
}
