package chapter1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.driver.OracleDriver;

/**
 * 插入操作
 * @author Administrator
 *
 */
public class TestInsert {

	public static void main(String[] args) throws SQLException {

		DriverManager.registerDriver(new OracleDriver());

		String url = "jdbc:oracle:thin:@localhost:1521:icss";
		String user = "scott";
		String password = "tiger";
		Connection conn = DriverManager.getConnection(url, user, password);

		Statement stmt = conn.createStatement();
		
		String sql = "insert into dept values (51,'NEC','大连')";
		int i = stmt.executeUpdate(sql);
		System.out.println("操作了" + i + "行");
		
		stmt.close();
		conn.close();
	}

}