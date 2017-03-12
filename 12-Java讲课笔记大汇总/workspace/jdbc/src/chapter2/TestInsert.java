package chapter2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

/**
 * 预编译语句对象
 * 
 */
public class TestInsert {

	public static void main(String[] args) throws SQLException {

		DriverManager.registerDriver(new OracleDriver());

		String url = "jdbc:oracle:thin:@localhost:1521:icss";
		String user = "scott";
		String password = "tiger";
		Connection conn = DriverManager.getConnection(url, user, password);
		
		//创建语句对象传入SQL，SQL中用?代替动态的值
		String sql = "insert into dept values (?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		//给第n个?参数赋值
		pstmt.setInt(1, 58);
		pstmt.setString(2, "开'发部");
		pstmt.setString(3, "北京");
		
		int i = pstmt.executeUpdate();
		System.out.println("操作了" + i + "行");

		pstmt.close();
		conn.close();
	}

}
