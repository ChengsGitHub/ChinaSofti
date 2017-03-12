package chapter2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

/**
 * 预编译语句对象
 * 
 */
public class TestQuery {

	public static void main(String[] args) throws SQLException {

		DriverManager.registerDriver(new OracleDriver());

		String url = "jdbc:oracle:thin:@localhost:1521:icss";
		String user = "scott";
		String password = "tiger";
		Connection conn = DriverManager.getConnection(url, user, password);
		
		//创建语句对象传入SQL，SQL中用?代替动态的值
		String sql = "select * from employees where department_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		//给第n个?参数赋值
		pstmt.setInt(1, 50);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "," + rs.getString(3));
		}

		rs.close();
		pstmt.close();
		conn.close();
	}

}
