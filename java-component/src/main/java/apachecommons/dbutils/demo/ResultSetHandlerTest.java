package apachecommons.dbutils.demo;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

/**
 * 测试 DBUtils框架 提供九个 默认 handler
 * 
 */
public class ResultSetHandlerTest {
	// ScalarHandler 通过保存只有一行一列 结果数据 ---- 分组函数
	@Test
	public void demo9() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select count(*) from account";

		long count = (Long) queryRunner.query(sql, new ScalarHandler(1));
		System.out.println(count);
	}

	// KeyedHandler 将结果集每一行数据 保存map , 将map保存另一个map ， key 指定列
	@Test
	public void demo8() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from account";

		/*Map<Object, Map<String, Object>> map = queryRunner.query(sql,
				new KeyedHandler("id"));
		System.out.println(map);*/
	}

	// MapListHandler 将结果集每一行数据 保存map中，key列名 value数据 ---- 在讲map对象保存List集合
	@Test
	public void demo7() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from account";
		List<Map<String, Object>> list = queryRunner.query(sql,
				new MapListHandler());
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
	}

	// MapHander 将结果集第一行数据 封装Map集合，key是列名 value第一行数据
	@Test
	public void demo6() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from account";
		Map<String, Object> map = queryRunner.query(sql, new MapHandler());
		System.out.println(map);
	}

	// ColumnListHandler 作用获得结果集的某一列
	@Test
	public void demo5() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from account";

		// 因为每列类型 都不一样
		// List<Object> list = queryRunner.query(sql,
		// new ColumnListHandler("name"));
		/*List<Object> list = queryRunner.query(sql, new ColumnListHandler(2));
		System.out.println(list);*/
	}

	// BeanListHander 结果集每一条数据 ---JavaBean对象 再保存list集合
	@Test
	public void demo4() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from account";
		List<Account> accounts = queryRunner.query(sql,
				new BeanListHandler<Account>(Account.class));

		for (Account account : accounts) {
			System.out.println(account.getId());
			System.out.println(account.getName());
			System.out.println(account.getMoney());
			System.out.println("----------------");
		}
	}

	// BeanHandler 将结果集第一行数据 封装 JavaBean对象中
	@Test
	public void demo3() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from account";

		// 传入 Account.class 为了在方法中 通过反射构造Account对象
		// 使用BeanHandler 注意事项 ：表列名 与 类中属性名称一致
		Account account = queryRunner.query(sql, new BeanHandler<Account>(
				Account.class));
		System.out.println(account.getId());
		System.out.println(account.getName());
		System.out.println(account.getMoney());
	}

	// ArrayListHandler 结果集每一行数据保存Object[] ----- List
	@Test
	public void demo2() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from account";
		List<Object[]> list = queryRunner.query(sql, new ArrayListHandler());

		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}
	}

	// ArrayHandler 将结果集 第一行数据 存入Object[]
	@Test
	public void demo1() throws SQLException {
		// 使用DBUtils
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from account";

		// 数组每一个元素，第一行数据每一列
		Object[] values = queryRunner.query(sql, new ArrayHandler());
		System.out.println(Arrays.toString(values));
	}
}
