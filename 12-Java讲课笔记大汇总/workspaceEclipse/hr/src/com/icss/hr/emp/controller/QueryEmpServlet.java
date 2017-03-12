package com.icss.hr.emp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.common.Pager;
import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.emp.service.EmpService;
import com.icss.hr.emp.service.impl.EmpServiceImpl;

public class QueryEmpServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//获得当前页码
		String pageNumStr = request.getParameter("pageNum");		
		int pageNum = 1;
		
		try {
			pageNum = Integer.parseInt(pageNumStr);
		}catch (Exception e) {
			
		}		
		
		EmpService service = new EmpServiceImpl();
				
		try {
			Pager pager = new Pager(service.getCount(),pageNum);
			ArrayList<Emp> list = service.query(pager);
			request.setAttribute("list", list);
			request.setAttribute("pager", pager);
			request.getRequestDispatcher("/QueryEmp.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errmsg", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}
		
	}

}