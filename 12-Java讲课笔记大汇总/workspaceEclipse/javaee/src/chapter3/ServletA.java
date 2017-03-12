package chapter3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletA extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("ServletA");
		System.out.println("ServletA");
		
		//在request范围中存储键值对
		request.setAttribute("username","tom");
		request.setAttribute("password",123456 );
		
		//请求转发
		request.getRequestDispatcher("/ServletB").forward(request, response);
		
		//重定向
		//response.sendRedirect("/ServletB");		
	}

}