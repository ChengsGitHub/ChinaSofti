package com.icss.hr.dept.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.dept.service.DeptService;
import com.icss.hr.dept.service.impl.DeptServiceImpl;

public class QueryDeptServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
		DeptService service = new DeptServiceImpl();
		
		try {
			//获得数据集合
			ArrayList<Dept> list = service.query();
			//存储到request范围
			request.setAttribute("list", list);
			//转发到JSP视图
			request.getRequestDispatcher("/QueryDept.jsp").forward(request, response);
		} catch (Exception e) {			
			e.printStackTrace();
			request.setAttribute("errmsg", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
	}

}
