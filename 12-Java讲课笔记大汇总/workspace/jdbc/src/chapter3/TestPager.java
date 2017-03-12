package chapter3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.driver.OracleDriver;

/**
 * 前台分页
 */
public class TestPager {

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

		String sql = "select * from employees";
		PreparedStatement pstmt = conn.prepareStatement(sql,
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

		ResultSet rs = pstmt.executeQuery();

		// 计算总记录数
		rs.last();
		recordCount = rs.getRow();

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

		// 游标定位到起始位置
		if (rs.absolute(start)) {
			// 循环输出本页数据
			for (int i = 1; i <= pageSize; i++) {
				System.out.println(rs.getInt(1) + "," + rs.getString(3) + ","
						+ rs.getDouble(8));

				if (!rs.next())
					break;
			}
		}

		rs.close();
		pstmt.close();
		conn.close();

		System.out.println("共" + recordCount + "条数据，每页" + pageSize + "条，共"
				+ totalPage + "页，当前是第" + pageNum + "页");
	}
}