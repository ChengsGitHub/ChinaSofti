package chapter1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.jdbc.driver.OracleDriver;

/**
 * ����������û����룩
 * @author Administrator
 *
 */
public class TestInsert2 {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�����벿�ű�ţ�");
		int deptno = sc.nextInt();
		System.out.println("�����벿�����ƣ�");
		String dname = sc.next();
		System.out.println("�����벿�ŵ�ַ��");
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
		System.out.println("������" + i + "��");
		
		stmt.close();
		conn.close();
	}

}