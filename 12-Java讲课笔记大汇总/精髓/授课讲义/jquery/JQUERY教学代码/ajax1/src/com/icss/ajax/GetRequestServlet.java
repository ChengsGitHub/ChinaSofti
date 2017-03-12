package com.icss.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetRequestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("usrename=" + username);
		System.out.println("password=" + password);
		
		out.write("hello,ajax");	
		
		//ģ�������ӳ�
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
	}

}