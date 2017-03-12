package com.icss.hr.emp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.common.Pager;
import com.icss.hr.emp.po.Emp;
import com.icss.hr.emp.service.impl.EmpServieImpl;

@WebServlet("/QueryEmpServlet")
public class QueryEmpServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//»ñµÃÒ³Âë
		String pageNumStr = request.getParameter("pageNum");
		
		int pageNum = 1;
		
		try {
			pageNum = Integer.parseInt(pageNumStr);
		} catch (Exception e) {
			
		}

		EmpServieImpl service = new EmpServieImpl();
				
		try {
			Pager pager = new Pager(service.getCount(),pageNum);
			ArrayList<Emp> list = service.query(pager);
			
			request.setAttribute("list", list);
			request.setAttribute("pager", pager);
			
			request.getRequestDispatcher("/QueryEmp.jsp").forward(request, response);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

}