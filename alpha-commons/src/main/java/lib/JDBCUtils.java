package lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtils {
    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
	
    //连接工具类
	public static void getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/courseJava","root","admin");
		} catch (Exception e) {
			e.printStackTrace();
		}
     }
	
	//进行查询操作
	public static ResultSet executeQuery(String sqlString, String[] parameters)
	{
		rs = null;         //清空结果集
		try {
			getConnection();
			ps = conn.prepareStatement(sqlString);
			if(parameters != null)
			{
				for(int i = 0; i < parameters.length; i++)
				{
					ps.setString(i+1, parameters[i]);
				}
			}
			
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	//更新数据库
	public static void executeUpdate(String sqlString)
	{
		getConnection();
		try {
			ps = conn.prepareStatement(sqlString);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void executeUpdate(String sql,String []parameters){
		try {
			//得到连接
			getConnection();
			//创建sql对象
			ps=conn.prepareStatement(sql);
			//给?赋值
			if(parameters!=null){
				for(int i=0;i<parameters.length;i++){
					ps.setString(i+1, parameters[i]);
				}
			}
			//执行sql
			ps.executeUpdate();	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
//			close(rs,ps,conn);
		}
	
	}
	
	
	
	public static void close(ResultSet rs) {
		if(rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	
	public static void close(ResultSet rs,PreparedStatement ps,Connection conn) {
		if(rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		close(conn, ps);
		
	}

	public static void close(Connection conn, PreparedStatement ps) {
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
