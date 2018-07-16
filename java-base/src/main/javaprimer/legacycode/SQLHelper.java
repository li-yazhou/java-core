package edu.ccu.se.utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class SQLHelper {

	/*
	 * driver=com.mysql.jdbc.Driver url=jdbc:mysql:///liuyanban user=root
	 * password=admin
	 */
	// 定义几个需要的变量
	private static Connection ct = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;

	// 定义数据库连接的参数 url,user,password, driver
	// 在实际开发中，把下面这些信息写到一个配置文件里
	// 程序启动的时候，读取配置文件读入这些信息 java.util.Properties
	private static String driver = null;
	private static String user = "root";
	private static String password = "admin";
	private static String url = "jdbc:mysql:///liuyanban";

	private static Properties pp = null;
	private static FileInputStream fis = null;
	// 静态块加载驱动,只需加载一次
	static {

		try {
			// 从dbinfo.properties读取配置信息
			// pp = new Properties();
			// fis = new FileInputStream("dbinfo.properties");
			// // 和文件关联
			// pp.load(fis);
			// driver = pp.getProperty("driver");
			// url = pp.getProperty("url");
			// user = pp.getProperty("user");
			// password = pp.getProperty("password");
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 得到连接
	public static Connection getConnection() {
		try {
			ct = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ct;
	}

	// 写一个select的方法
	// sql="select * from emp where ename=?"
	// parameters={"SMITH"};
	public static ResultSet executeQuery(String sql, String[] parameters) {
		// ResultSet rs=null;
		try {
			// 1.得到连接
			ct = DriverManager.getConnection(url, user, password);
			// 2.创建sql对象
			ps = ct.prepareStatement(sql);
			// 3.给？赋值
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					ps.setString(i + 1, parameters[i]);
				}
			}
			// 4.执行sql
			rs = ps.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// 抛出运行异常，给调用者一个选择
			// 可以捕获，也可以放弃处理
			throw new RuntimeException(e.getMessage());
		} finally {
			// close(rs,ps,ct);
		}
		return rs;
	}

	// 写多个Insert/update/delete的方法，需要考虑事务
	// sql1="update emp set sal=sal-10 where ename=?"
	// sql2="update emp set sal=sal+10 where ename=?"
	// sql1_paras={"SMITH"}
	// sql2_paras={"ALLEN"};
	public static void executeUpdate(String[] sqls, String[][] parameters)
			throws SQLException {
		// 1.得到连接
		// 2.可能传入多个sql，需要考虑事务
		// 设置事务不自动提交
		// 3.循环创建sql对象
		// 4.针对每个sql对象给?赋值
		// 5.执行每个sql
		// 6.把多个sql看做一个事务，统一提交
		// 注意，如果出现异常，回滚事务（取消全部dml操作)

		// 1.得到连接
		try {
			ct = DriverManager.getConnection(url, user, password);
			ct.setAutoCommit(false);
			// 2.创建sql对象
			for (int i = 0; i < sqls.length; i++) {
				ps = ct.prepareStatement(sqls[i]);
				for (int j = 0; j < parameters[i].length; j++) {
					ps.setString(j + 1, parameters[i][j]);
					ps.executeUpdate();
				}
			}
			ct.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ct.rollback();
		} finally {
			// close(rs,ps,ct);
		}

	}

	// 先写一个insert/update/delete的方法
	// sql="insert into emp(empno,ename) values(9999,'LiHeng')";
	// 或者sql="insert into emp(empno,ename) values(?,?)"
	// parameters={"9999","LiHeng"}
	public static void executeUpdate(String sql, String[] parameters) {
		try {
			// 得到连接
			ct = DriverManager.getConnection(url, user, password);
			// 创建sql对象
			ps = ct.prepareStatement(sql);
			// 给?赋值
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					ps.setString(i + 1, parameters[i]);
				}
			}
			// 执行sql
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			// 抛出运行异常，给调用者一个选择
			// 可以捕获，也可以放弃处理
			throw new RuntimeException(e.getMessage());
		} finally {
			close(rs, ps, ct);
		}

	}

	// 关闭资源后创建的先关闭
	public static void close(ResultSet rs, Statement ps, Connection ct) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (ct != null) {
			try {
				ct.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static Connection getCt() {
		return ct;
	}

	public static PreparedStatement getPs() {
		return ps;
	}

	public static ResultSet getRs() {
		return rs;
	}

}
