package com.icss.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckUserNameServlet")
public class CheckUserNameServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//ģ�������ӳ�
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");		
		System.out.println("username=" + username);
		
		if ("tom".equals(username) || "jack".equals(username) ) {
			out.print("true");
		} else {
			out.print("false");
		}

	}

}