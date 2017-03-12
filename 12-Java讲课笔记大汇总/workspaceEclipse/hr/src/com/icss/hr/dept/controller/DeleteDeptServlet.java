package com.icss.hr.dept.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.service.DeptService;
import com.icss.hr.dept.service.impl.DeptServiceImpl;

public class DeleteDeptServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		PrintWriter out = response.getWriter();
		
		//��ò���ID
		String deptId = request.getParameter("deptId");
		
		DeptService service = new DeptServiceImpl();
		
		try {
			service.delete(Integer.parseInt(deptId));
		}  catch (Exception e) {		
			e.printStackTrace();
			request.setAttribute("errmsg", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}
		
		out.println("<script>alert('ɾ�����ųɹ���');location.href='QueryDeptServlet';</script>");		
	}

}