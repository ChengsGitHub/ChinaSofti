package com.icss.hr.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

/**
 * 连接工厂
 * @author Administrator
 *
 */
public class ConnFactory {
	
	static {
		//注册驱动
		try {
			DriverManager.registerDriver(new OracleDriver());
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:icss";
		String user = "myhr";
		String password = "myhr";
		
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}

}