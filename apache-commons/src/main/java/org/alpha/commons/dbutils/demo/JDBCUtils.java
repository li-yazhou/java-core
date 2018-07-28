package org.alpha.commons.dbutils.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

// import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	// 获得数据库连接 --- 通过c3p0连接池
	// 自动读取c3p0-config.xml
	// private static DataSource dataSource = new ComboPooledDataSource();
	private static DataSource dataSource = null;

	// 返回数据库连接池
	public static DataSource getDataSource() {
		return dataSource;
	}

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

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

