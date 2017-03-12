package chapter3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class TestCursor {

	public static void main(String[] args) throws SQLException {

		DriverManager.registerDriver(new OracleDriver());

		String url = "jdbc:oracle:thin:@localhost:1521:icss";
		String user = "scott";
		String password = "tiger";
		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = "select * from employees";
		PreparedStatement pstmt = conn.prepareStatement(sql,
				ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

		ResultSet rs = pstmt.executeQuery();

		rs.next();
		rs.next();
		rs.next();

		rs.previous();
		
		rs.last();		
		rs.first();
		
		rs.absolute(7);
		rs.relative(-3);
		
		System.out.println(rs.getRow());

		System.out.println(rs.getInt(1) + "," + rs.getString(3));
	}

}