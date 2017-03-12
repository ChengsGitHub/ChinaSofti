package chapter4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

/**
 * 批处理
 */
public class TestBatch {

	public static void main(String[] args) throws SQLException {
		
		DriverManager.registerDriver(new OracleDriver());

		String url = "jdbc:oracle:thin:@localhost:1521:icss";
		String user = "scott";
		String password = "tiger";
		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = "insert into dept values (?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		for (int i = 71;i <= 80;i ++) {
			pstmt.setInt(1, i);
			pstmt.setString(2, "nec" + i);
			pstmt.setString(3, "beijing");
			
			pstmt.addBatch();//把SQL加到批处理中
		}
		
		pstmt.executeBatch();//执行批处理
		
		pstmt.close();
		conn.close();		
	}

}