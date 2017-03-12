package chapter4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

/**
 * Ԫ����
 * @author Administrator
 *
 */
public class TestMetaData {

	public static void main(String[] args) throws SQLException {
		
		DriverManager.registerDriver(new OracleDriver());

		String url = "jdbc:oracle:thin:@localhost:1521:icss";
		String user = "scott";
		String password = "tiger";
		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = "select * from SALGRADE";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		//���Ԫ���ݶ���
		ResultSetMetaData rsmd = rs.getMetaData();
		
		for (int i = 1;i <= rsmd.getColumnCount();i ++) {
			System.out.println( rsmd.getColumnName(i) + ":" + rsmd.getColumnTypeName(i) );
		}
		
		rs.close();
		pstmt.close();
		conn.close();
	}

}