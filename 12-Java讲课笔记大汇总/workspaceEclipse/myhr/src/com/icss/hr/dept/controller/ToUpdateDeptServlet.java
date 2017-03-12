package com.icss.hr.dept.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.po.Dept;
import com.icss.hr.dept.service.impl.DeptServiceImpl;

@WebServlet("/ToUpdateDeptServlet")
public class ToUpdateDeptServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//获得部门ID
		String deptId = request.getParameter("deptId");
		
		DeptServiceImpl service = new DeptServiceImpl();
		
		try {
			//调用Service返回部门PO对象
			Dept dept = service.queryById(Integer.parseInt(deptId));
			
			//存储到范围中，转发到JSP视图
			request.setAttribute("dept",dept);
			request.getRequestDispatcher("/UpdateDept.jsp").forward(request, response);
			
		}  catch (Exception e) {			
			e.printStackTrace();
			//存储错误 消息，转发到错误页 
			request.setAttribute("errmsg", e.getMessage());						
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
	}

}