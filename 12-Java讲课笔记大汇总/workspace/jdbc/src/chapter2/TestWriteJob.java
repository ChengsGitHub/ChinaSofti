package chapter2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

/**
 * 查询员工编号，姓名，职务编号，职务名称，写入到硬盘文件中 
 */
public class TestWriteJob {

	public static void main(String[] args) throws SQLException, FileNotFoundException {
		
		DriverManager.registerDriver(new OracleDriver());

		String url = "jdbc:oracle:thin:@localhost:1521:icss";
		String user = "scott";
		String password = "tiger";
		Connection conn = DriverManager.getConnection(url, user, password);
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT e.employee_id,e.last_name,j.job_id,j.job_title ");
		sb.append("FROM employees e ");
		sb.append("INNER JOIN jobs j ON e.job_id=j.job_id ");
		
		PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		
		ResultSet rs = pstmt.executeQuery();
		
		PrintWriter pw = new PrintWriter("f:\\job.txt");//输出流
		
		while (rs.next()) {
			int empId = rs.getInt(1);
			String empName = rs.getString(2);
			String jobId = rs.getString(3);
			String jobName = rs.getString(4);
			
			System.out.println(empId + "," + empName + "," + jobId + "," + jobName);
			pw.println(empId + "," + empName + "," + jobId + "," + jobName);//输出数据到文件中
		}
		
		pw.close();
		
		rs.close();
		pstmt.close();
		conn.close();
	}

}