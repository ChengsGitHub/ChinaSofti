package chapter2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

/**
 * Ԥ����������
 * 
 */
public class TestInsert {

	public static void main(String[] args) throws SQLException {

		DriverManager.registerDriver(new OracleDriver());

		String url = "jdbc:oracle:thin:@localhost:1521:icss";
		String user = "scott";
		String password = "tiger";
		Connection conn = DriverManager.getConnection(url, user, password);
		
		//������������SQL��SQL����?���涯̬��ֵ
		String sql = "insert into dept values (?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		//����n��?������ֵ
		pstmt.setInt(1, 58);
		pstmt.setString(2, "��'����");
		pstmt.setString(3, "����");
		
		int i = pstmt.executeUpdate();
		System.out.println("������" + i + "��");

		pstmt.close();
		conn.close();
	}

}
