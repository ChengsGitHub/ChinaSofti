package chapter3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.driver.OracleDriver;

/**
 * 后台分页（SQL分页）
 */
public class TestPager2 {

	public static void main(String[] args) throws SQLException {

		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个页码：");

		int recordCount = 0;// 总记录数
		int pageSize = 6;// 每页多少条
		int totalPage = 0;// 共几页
		int pageNum = sc.nextInt();// 当前页码

		DriverManager.registerDriver(new OracleDriver());

		String url = "jdbc:oracle:thin:@localhost:1521:icss";
		String user = "scott";
		String password = "tiger";
		Connection conn = DriverManager.getConnection(url, user, password);

		// 查询统计总记录数
		String sql = "select count(*) from employees";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		recordCount = rs.getInt(1);

		// 计算共几页
		totalPage = recordCount / pageSize;
		if (recordCount % pageSize != 0)
			totalPage++;

		// 计算当前页码
		if (pageNum < 1)
			pageNum = 1;
		if (pageNum > totalPage)
			pageNum = totalPage;
		
		// 计算起始位置
		int start = (pageNum - 1) * pageSize + 1;
		int end = pageNum * pageSize;
		
		sql = "select * from (select rownum rnum,e.* from employees e) ";
		sql += "where rnum between ? and ?";
		pstmt = conn.prepareStatement(sql);
		
		//查询输出本页数据
		pstmt.setInt(1, start);
		pstmt.setInt(2, end);
		
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			System.out.println(rs.getInt(2) + "," + rs.getString(4) + ","
					+ rs.getDouble(9));
		}		
		
		rs.close();
		pstmt.close();
		conn.close();

		System.out.println("共" + recordCount + "条数据，每页" + pageSize + "条，共"
				+ totalPage + "页，当前是第" + pageNum + "页");
	}
}