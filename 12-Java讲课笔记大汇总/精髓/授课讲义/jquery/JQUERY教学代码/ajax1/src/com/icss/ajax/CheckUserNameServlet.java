package com.icss.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckUserNameServlet
 */
public class CheckUserNameServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
				
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");		
		System.out.println("username=" + username);
		
		if ("tom".equals(username) || "jack".equals(username)) {
			out.write("false");
		} else {
			out.write("true");
		}		
		
		//Ä£ÄâÍøÂçÑÓ³Ù
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}