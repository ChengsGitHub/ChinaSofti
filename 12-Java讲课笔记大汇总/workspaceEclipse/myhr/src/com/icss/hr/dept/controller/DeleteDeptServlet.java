package com.icss.hr.dept.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.service.impl.DeptServiceImpl;

@WebServlet("/DeleteDeptServlet")
public class DeleteDeptServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();

		// 获得部门ID
		String deptId = request.getParameter("deptId");

		// 创建Service对象
		DeptServiceImpl service = new DeptServiceImpl();
		
		try {
			//删除数据
			service.delete(Integer.parseInt(deptId));
			out.println("<script>alert('部门删除成功');location.href='QueryDeptServlet';</script>");
		}  catch (Exception e) {			
			e.printStackTrace();
			//存储错误 消息，转发到错误页 
			request.setAttribute("errmsg", e.getMessage());						
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}

	}

}