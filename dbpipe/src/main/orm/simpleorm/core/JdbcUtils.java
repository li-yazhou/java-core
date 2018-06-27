package simpleorm.core;

import java.sql.*;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-22 17:07
 */
public class JdbcUtils {

    public static Connection getConn(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///dbpipe", "root", "root");
        }catch(Exception e){
            System.out.println("获取连接对象失败.");
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 增删改
     * @param sql 预编译SQL语句
     * @param params 参数
     * @return 受影响的记录数目
     */
    public static int excuteUpdate(String sql, Object[] params){
        Connection connection = null;
        PreparedStatement pstmt =null;
        int result = -1;
        try {
            connection = getConn();
            pstmt = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i ++){
                pstmt.setObject(i+1, params[i]);
            }
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("更新数据出现异常.");
            System.out.println(e.getMessage());
        } finally {
            release(pstmt, connection);
        }
        return result;  // 更新数据失败
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
