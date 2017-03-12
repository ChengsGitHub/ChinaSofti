package com.icss.hr.dept.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.dept.service.DeptService;
import com.icss.hr.dept.service.impl.DeptServiceImpl;

public class ToUpdateDeptServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String deptId = request.getParameter("deptId");
		
		DeptService service = new DeptServiceImpl();
		
		try {
			Dept dept = service.queryById(Integer.parseInt(deptId));
			request.setAttribute("dept", dept);
			request.getRequestDispatcher("/UpdateDept.jsp").forward(request, response);
		}  catch (Exception e) {			
			e.printStackTrace();
			request.setAttribute("errmsg", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
	}

}