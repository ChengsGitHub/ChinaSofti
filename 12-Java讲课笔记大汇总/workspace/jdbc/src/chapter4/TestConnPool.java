package chapter4;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnPool {

	public static void main(String[] args) throws SQLException {
		
		final Connection conn1 = ConnPool.getConnection();
		System.out.println("conn1获得连接");
		
		new Thread() {			
			public void run() {
				try {
					Thread.sleep(5000);
					conn1.close();//还给连接池
				} catch (Exception e) {					
					e.printStackTrace();
				}
			}			
		}.start();
				
		Connection conn2 = ConnPool.getConnection();
		System.out.println("conn2获得连接");
		
		Connection conn3 = ConnPool.getConnection();
		System.out.println("conn3获得连接");
		
		Connection conn4 = ConnPool.getConnection();
		System.out.println("conn4获得连接");

	}

}