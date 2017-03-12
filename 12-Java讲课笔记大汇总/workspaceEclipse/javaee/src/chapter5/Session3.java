package chapter5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Session3 extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// 获得session对象
		HttpSession session = request.getSession();
		
		//设置超时时长（秒为单位，仅对当前会话有效，并不会影响全局）
		session.setMaxInactiveInterval(10);
		
		//返回超时时长
		out.println("超时时长：" + session.getMaxInactiveInterval());

		out.println("sessionID=" + session.getId());

	}

}