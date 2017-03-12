package chapter5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Session1 extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		//获得session对象
		HttpSession session = request.getSession();
		
		//设置session范围的键值对
		session.setAttribute("username", "jack");
		session.setAttribute("password", "444555");
		
		out.println("sessionID=" + session.getId());		
	}

}