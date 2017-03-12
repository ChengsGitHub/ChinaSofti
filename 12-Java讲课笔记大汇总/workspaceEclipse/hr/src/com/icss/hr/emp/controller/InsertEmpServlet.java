package com.icss.hr.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.emp.service.EmpService;
import com.icss.hr.emp.service.impl.EmpServiceImpl;
import com.icss.hr.emp.vo.EmpVo;

public class InsertEmpServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();

		String empName = request.getParameter("empName");
		String empEmail = request.getParameter("empEmail");
		String empPhone = request.getParameter("empPhone");
		String empHiredate = request.getParameter("empHiredate");
		String jobId = request.getParameter("jobId");
		String empSalary = request.getParameter("empSalary");
		String deptId = request.getParameter("deptId");

		EmpVo vo = new EmpVo(empName, empEmail, empPhone, Date
				.valueOf(empHiredate), jobId, Integer.parseInt(empSalary),
				Integer.parseInt(deptId));
		
		EmpService service = new EmpServiceImpl();
		
		try {
			service.insert(vo);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errmsg", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}
		
		out.println("<script>alert('增加员工成功！');location.href='QueryEmpServlet';</script>");
	}

}