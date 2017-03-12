package chapter5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Session2 extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		// 获得session对象
		HttpSession session = request.getSession();

		//从session范围中取出键值对
		String username = (String) session.getAttribute("username");
		String password = (String) session.getAttribute("password");

		out.println("sessionID=" + session.getId());
		out.println("username=" + username);
		out.println("password=" + password);

	}

}