package com.icss.ng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestServlet")
public class RequestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

//		设置请求和响应的编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	
		
//		获得输出流
		PrintWriter out = response.getWriter();
		
//		获得请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("username=" + username);
		System.out.println("password=" + password);
		
		out.write("hello,angularJS....");
				
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
				
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}