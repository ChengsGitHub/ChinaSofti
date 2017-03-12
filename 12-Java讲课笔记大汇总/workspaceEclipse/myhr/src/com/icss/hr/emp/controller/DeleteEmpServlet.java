package com.icss.hr.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.emp.service.impl.EmpServieImpl;

@WebServlet("/DeleteEmpServlet")
public class DeleteEmpServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();		
		String empId = request.getParameter("empId");		
		EmpServieImpl service = new EmpServieImpl();
		
		try {
			service.delete(Integer.parseInt(empId));
			out.println("<script>alert('员工删除成功');location.href='QueryEmpServlet';</script>");			
		}  catch (Exception e) {			
			e.printStackTrace();
		}		

	}

}