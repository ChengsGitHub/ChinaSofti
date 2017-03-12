package chapter4;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 连接池类
 * @author Administrator
 *
 */
public class ConnPool {
	
	private static ComboPooledDataSource dataSource;
	
	/**
	 * 初始化连接池
	 */
	static {
		try {
			dataSource = new ComboPooledDataSource();
			
			dataSource.setUser("scott");// 用户名
			dataSource.setPassword("tiger");// 密码
			dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:icss");
			dataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");// 驱动类
			
			dataSource.setInitialPoolSize(3);// 初始连接
			dataSource.setMinPoolSize(3);// 最小连接
			dataSource.setMaxPoolSize(3);// 最大连接
			dataSource.setMaxIdleTime(60);// 最大空闲时间
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获得数据库连接
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
