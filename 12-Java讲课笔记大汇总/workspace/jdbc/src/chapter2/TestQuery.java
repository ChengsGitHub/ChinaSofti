package chapter2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

/**
 * Ԥ����������
 * 
 */
public class TestQuery {

	public static void main(String[] args) throws SQLException {

		DriverManager.registerDriver(new OracleDriver());

		String url = "jdbc:oracle:thin:@localhost:1521:icss";
		String user = "scott";
		String password = "tiger";
		Connection conn = DriverManager.getConnection(url, user, password);
		
		//������������SQL��SQL����?���涯̬��ֵ
		String sql = "select * from employees where department_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		//����n��?������ֵ
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
