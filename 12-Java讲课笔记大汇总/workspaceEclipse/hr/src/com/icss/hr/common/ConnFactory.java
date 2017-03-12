package com.icss.hr.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class ConnFactory {
	
	public static Connection getConnection() throws SQLException {
				
		DriverManager.registerDriver(new OracleDriver());

		/* 获得数据库连接 */
		String url = "jdbc:oracle:thin:@localhost:1521:icss";
		String user = "hr";
		String password = "hr";
		Connection conn = DriverManager.getConnection(url, user, password);
		
		return conn;
	}

}