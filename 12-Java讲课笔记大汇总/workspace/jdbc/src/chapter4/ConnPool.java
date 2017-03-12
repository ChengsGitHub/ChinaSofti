package chapter4;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ���ӳ���
 * @author Administrator
 *
 */
public class ConnPool {
	
	private static ComboPooledDataSource dataSource;
	
	/**
	 * ��ʼ�����ӳ�
	 */
	static {
		try {
			dataSource = new ComboPooledDataSource();
			
			dataSource.setUser("scott");// �û���
			dataSource.setPassword("tiger");// ����
			dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:icss");
			dataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");// ������
			
			dataSource.setInitialPoolSize(3);// ��ʼ����
			dataSource.setMinPoolSize(3);// ��С����
			dataSource.setMaxPoolSize(3);// �������
			dataSource.setMaxIdleTime(60);// ������ʱ��
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ������ݿ�����
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
