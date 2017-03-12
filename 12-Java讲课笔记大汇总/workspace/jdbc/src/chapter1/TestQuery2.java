package chapter1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

/**
 * ²éÑ¯²Ù×÷
 */
public class TestQuery2 {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {

		DriverManager.registerDriver(new OracleDriver());
		
		String url = "jdbc:oracle:thin:@localhost:1521:icss";
		String user = "scott";
		String password = "tiger";
		Connection conn = DriverManager.getConnection(url, user, password);
		
		Statement stmt = conn.createStatement();
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT e.employee_id,e.last_name,e.salary,d.department_id,d.department_name, ");
		sb.append("       j.job_id,j.job_title ");
		sb.append("FROM   departments d,employees e,jobs j ");
		sb.append("WHERE  e.department_id=d.department_id ");
		sb.append("AND    e.job_id=j.job_id ");
		sb.append("AND    e.salary>5000 ");
		sb.append("ORDER BY e.salary DESC ");
		ResultSet rs = stmt.executeQuery(sb.toString());
		
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getString(5));
		}
		
		rs.close();
		stmt.close();
		conn.close();
	}

}