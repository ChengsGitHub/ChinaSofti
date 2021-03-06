package chapter4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

/**
 * 事务
 */
public class TestTransaction {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
	
			String url = "jdbc:oracle:thin:@localhost:1521:icss";
			String user = "scott";
			String password = "tiger";
			conn = DriverManager.getConnection(url, user, password);
			
			conn.setAutoCommit(false);//设置手动提交事务		
	
			String sql1 = "update employees set salary=salary-200 where employee_id=100";
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.executeUpdate();
			
			//int i = 10 / 0;//模拟断电
			
			String sql2 = "update employees set salary=salary+200 where employee_id=101";
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.executeUpdate();
			
			conn.commit();//提交事务			
		} catch (Exception e) {
			try {
				conn.rollback();//回退事务
			} catch (SQLException e1) {
				
			}
			e.printStackTrace();
		} finally {
			try {
				if (pstmt2 != null)
					pstmt2.close();
				if (pstmt1 != null)
					pstmt1.close();	
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				
			}
		}
	}

}