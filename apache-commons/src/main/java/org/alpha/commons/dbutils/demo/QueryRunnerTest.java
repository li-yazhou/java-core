package cn.itcast.dbutilstest;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import cn.itcast.utils.JDBCUtils;

/**
 * 编写QueryRunner测试用例
 * 
 * @author seawind
 * 
 */
public class QueryRunnerTest {
	// 事务控制
	@Test
	public void testTransfer() throws SQLException {
		double money = 100;
		String outAccount = "aaa";
		String inAccount = "bbb";
		String sql1 = "update account set money = money - ? where name= ?";
		String sql2 = "update account set money = money + ? where name= ?";

		// QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		// 默认每条sql 一个单独事务

		QueryRunner queryRunner = new QueryRunner();// 不要传递连接池 --- 手动事务管理
		Connection conn = JDBCUtils.getConnection();
		conn.setAutoCommit(false);
		try {
			queryRunner.update(conn, sql1, money, outAccount);
			// int d = 1 / 0;
			queryRunner.update(conn, sql2, money, inAccount);

			System.out.println("事务提交！");
			DbUtils.commitAndCloseQuietly(conn);
		} catch (Exception e) {
			System.out.println("事务回滚！");
			DbUtils.rollbackAndCloseQuietly(conn);
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "delete from users where id = ?";
		queryRunner.update(sql, 3);
	}

	@Test
	public void testUpdate() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "update users set password = ? where username = ?";
		Object[] param = { "nihao", "小明" };
		queryRunner.update(sql, param);
	}

	@Test
	public void testInsert() throws SQLException {
		// 第一步 创建QueryRunner对象
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

		// 第二步 准备方法参数
		String sql = "insert into users values(null,?,?,?)";
		Object[] param = { "小丽", "qwe", "xiaoli@itcast.cn" };

		// 第三步 调用 query / update
		queryRunner.update(sql, param);
	}
}
