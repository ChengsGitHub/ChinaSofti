package chapter3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.driver.OracleDriver;

public class EmpServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");//设置请求编码
		//response.setCharacterEncoding("utf-8");//设置响应编码
		response.setContentType("text/html;charset=utf-8");//设置MIME类型和编码
		
		PrintWriter out = response.getWriter();//输出流
		
		//获得参数值
		String keyword = request.getParameter("keyword");
		if (keyword == null)
			keyword = "";
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			
			String url = "jdbc:oracle:thin:@localhost:1521:icss";
			String user = "scott";
			String password = "tiger";
			Connection conn = DriverManager.getConnection(url, user, password);
						
			String sql = "select * from employees where lower(last_name) like ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,"%" + keyword.toLowerCase() + "%");
			
			ResultSet rs = pstmt.executeQuery();
			
			out.println("<table border=1 width=100%>");
			out.println("<tr>");
			out.println("<th>员工编号</th><th>姓名</th><th>工资</th><th>入职日期</th>");
			out.println("</tr>");
			
			while (rs.next()) {
				out.println("<tr>");
				out.println("<td>" + rs.getInt(1) + "</td>");
				out.println("<td>" + rs.getString(3) + "</td>");
				out.println("<td>" + rs.getDouble(8) + "</td>");
				out.println("<td>" + rs.getDate(6) + "</td>");
				out.println("</tr>");
			}
			
			out.println("</table>");
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}