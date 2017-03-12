package chapter1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

/**
 * 查询操作
 */
public class TestQuery {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {

		// 1.注册驱动程序
		// Class.forName("oracle.jdbc.driver.OracleDriver");
		DriverManager.registerDriver(new OracleDriver());

		// 2.获得数据库连接对象Connection
		String url = "jdbc:oracle:thin:@localhost:1521:icss";// 连接字符串
		String user = "scott";
		String password = "tiger";
		Connection conn = DriverManager.getConnection(url, user, password);

		// 3.创建语句对象
		Statement stmt = conn.createStatement();

		// 4.执行SQL查询语句，返回查询结果集ResultSet对象
		ResultSet rs = stmt.executeQuery("select * from employees");

		// 5.遍历查询结果集
		while (rs.next()) {
			int empId = rs.getInt("employee_id");// 通过列名获得列值
			String name = rs.getString(3);// 通过列索引获得列值（推荐，效率高）
			double salary = rs.getDouble(8);
			Date hiredate = rs.getDate(6);
			double comm = rs.getDouble(9);

			System.out.println(empId + "," + name + "," + salary + ","
					+ hiredate + "," + comm);
		}

		// 6.关闭对象，释放内存
		rs.close();
		stmt.close();
		conn.close();
	}

}