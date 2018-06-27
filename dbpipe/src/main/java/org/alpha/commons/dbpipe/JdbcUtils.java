package org.alpha.commons.dbpipe;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.*;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-22 17:07
 */
public class JdbcUtils {
    // 获得数据库连接 --- 通过c3p0连接池
    // 自动读取c3p0-config.xml
    private static DataSource dataSource = new ComboPooledDataSource();
    private static QueryRunner queryRunner = new QueryRunner(dataSource);
    // private static QueryRunner queryRunner = new QueryRunner();


    public static QueryRunner getQueryRunner(){
        return queryRunner;
    }
    /**
     * 获取数据库连接池中的连接
     * @return 数据库的连接
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException{
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new SQLException("获取Connection对象出现异常.");
        }
    }

    public static Connection getConn() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql:///dbpipe", "root", "root");
        return conn;
    }

    /**
     * 增删改
     * @param sql 预编译SQL语句
     * @param params 参数
     * @return 受影响的记录数目
     * @throws SQLException
     */
    public static int excuteUpdate(String sql, Object[] params){
        Connection connection = null;
        PreparedStatement pstmt =null;
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i ++){
                pstmt.setObject(i+1, params[i]);
            }
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("更新数据出现异常.");
            System.out.println(e.getMessage());
        }
        return -1;  // 更新数据失败
    }


    public static ResultSet executeQuery(String sql){
        return null;
    }

    public static List<Map<String, Object>> convertResultSet(String sql){
        return null;
    }

    // TODO: 2017/7/22 事务管理

    // 释放资源
    public static void release(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }

        release(stmt, conn);
    }


    public static void release(Statement stmt, Connection conn) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }
}
