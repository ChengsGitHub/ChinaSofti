package chapter3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletB extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("ServletB");
		System.out.println("ServletB");
		
		String username = (String) request.getAttribute("username");
		Integer password = (Integer) request.getAttribute("password");
		out.println("username=" + username + ",password=" + password);
		
	}

}
