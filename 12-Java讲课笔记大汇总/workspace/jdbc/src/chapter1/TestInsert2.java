package chapter1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.jdbc.driver.OracleDriver;

/**
 * 插入操作（用户输入）
 * @author Administrator
 *
 */
public class TestInsert2 {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入部门编号：");
		int deptno = sc.nextInt();
		System.out.println("请输入部门名称：");
		String dname = sc.next();
		System.out.println("请输入部门地址：");
		String loc = sc.next();

		DriverManager.registerDriver(new OracleDriver());

		String url = "jdbc:oracle:thin:@localhost:1521:icss";
		String user = "scott";
		String password = "tiger";
		Connection conn = DriverManager.getConnection(url, user, password);

		Statement stmt = conn.createStatement();
		
		String sql = "insert into dept values (" + deptno + ",'" + dname + "','" + loc + "')";
		System.out.println(sql);
		int i = stmt.executeUpdate(sql);
		System.out.println("操作了" + i + "行");
		
		stmt.close();
		conn.close();
	}

}