package chapter4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

/**
 * 输出scott用户下所有的表的名称，以及列名
 * 
 * @author Administrator
 * 
 */
public class TestQueryTableName {

	public static void main(String[] args) throws SQLException {

		DriverManager.registerDriver(new OracleDriver());

		String url = "jdbc:oracle:thin:@localhost:1521:icss";
		String user = "scott";
		String password = "tiger";

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = "select table_name from user_tables";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		// 输出所有的表名
		while (rs.next()) {

			String name = rs.getString(1);
			System.out.println(name);

			String sql1 = "select * from " + name;

			PreparedStatement pstmt1 = conn.prepareStatement(sql1);

			ResultSet rs1 = pstmt1.executeQuery();

			ResultSetMetaData rsmd = rs1.getMetaData();

			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				System.out.println("\t" + rsmd.getColumnName(i) + ":" + rsmd.getColumnTypeName(i));
			}
			
			rs1.close();
			
			pstmt1.close();
		}

		rs.close();
		pstmt.close();
		conn.close();

	}

}