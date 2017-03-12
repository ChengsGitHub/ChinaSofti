package chapter3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OtherMethodServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
			
		// 获得WEB应用路径（重点）
		out.println("WEB应用路径：" + request.getContextPath());
		out.println("<br>");
		//获得请求方法
		out.println("请求方法：" + request.getMethod());
		out.println("<br>");
		//获得协议名
		out.println("协议名：" + request.getProtocol());
		out.println("<br>");
		//获得参数字符串（重点）
		out.println("参数字符串：" + request.getQueryString());
		out.println("<br>");
		//获得请求URI（重点）
		out.println("请求URI：" + request.getRequestURI());
		out.println("<br>");
		//获得请求URL（重点）
		out.println("请求URL：" + request.getRequestURL());
		out.println("<br>");
		//获得用户IP地址
		out.println("客户端IP：" + request.getRemoteAddr());
		out.println("<br>");
		//获得服务器IP（重点）
		out.println("服务器器IP：" + request.getLocalAddr());
		out.println("<br>");
		//获得服务器主机名
		out.println("服务器主机名：" + request.getLocalName());
		out.println("<br>");
		//获得服务器端口
		out.println("服务器端口：" + request.getLocalPort());
		out.println("<br>");
		
	}

}