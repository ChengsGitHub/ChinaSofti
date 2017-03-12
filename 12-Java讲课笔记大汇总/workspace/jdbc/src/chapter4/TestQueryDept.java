package chapter4;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class TestQueryDept {

	/**
	 * ��ѯ������еĲ��ŵĲ��ű�źͲ������ƣ��Լ�������ŵ�Ա���ı�ţ����������� 10 NEC 100,tom,24000
	 * 101,jack,17000 20 GE 102,rose,25000 40 HSW Xxx,xxx,xxx Xxx,xxx,xxx
	 * 
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		DriverManager.registerDriver(new OracleDriver());

		String url = "jdbc:oracle:thin:@localhost:1521:icss";
		String user = "scott";
		String password = "tiger";
		Connection conn = DriverManager.getConnection(url, user, password);

		//��ѯ���в���
		String sql = "select * from departments";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		//��ѯָ�����ŵ�Ա��
		String sql1 = "select * from employees where  department_id = ?";
		PreparedStatement pstmt1 = conn.prepareStatement(sql1);
		
		ResultSet rs = pstmt.executeQuery();

		//������������
		while (rs.next()) {
			int depid = rs.getInt(1);
			String pname = rs.getString(2);
			System.out.println(depid + "  " + pname);

			//���������ŵ�Ա������	
			pstmt1.setInt(1, depid);
			ResultSet rs1 = pstmt1.executeQuery();			
			while (rs1.next()) {
				int empid = rs1.getInt(1);
				String ename = rs1.getString(2);
				double sal = rs1.getDouble(8);

				System.out.println("\t" + empid + "," + ename + "," + sal);
			}
			
			rs1.close();			
		}

		rs.close();
		pstmt1.close();
		pstmt.close();
		conn.close();
	}

}
