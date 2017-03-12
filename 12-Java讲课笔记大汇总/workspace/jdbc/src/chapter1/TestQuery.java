package chapter1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

/**
 * ��ѯ����
 */
public class TestQuery {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {

		// 1.ע����������
		// Class.forName("oracle.jdbc.driver.OracleDriver");
		DriverManager.registerDriver(new OracleDriver());

		// 2.������ݿ����Ӷ���Connection
		String url = "jdbc:oracle:thin:@localhost:1521:icss";// �����ַ���
		String user = "scott";
		String password = "tiger";
		Connection conn = DriverManager.getConnection(url, user, password);

		// 3.����������
		Statement stmt = conn.createStatement();

		// 4.ִ��SQL��ѯ��䣬���ز�ѯ�����ResultSet����
		ResultSet rs = stmt.executeQuery("select * from employees");

		// 5.������ѯ�����
		while (rs.next()) {
			int empId = rs.getInt("employee_id");// ͨ�����������ֵ
			String name = rs.getString(3);// ͨ�������������ֵ���Ƽ���Ч�ʸߣ�
			double salary = rs.getDouble(8);
			Date hiredate = rs.getDate(6);
			double comm = rs.getDouble(9);

			System.out.println(empId + "," + name + "," + salary + ","
					+ hiredate + "," + comm);
		}

		// 6.�رն����ͷ��ڴ�
		rs.close();
		stmt.close();
		conn.close();
	}

}