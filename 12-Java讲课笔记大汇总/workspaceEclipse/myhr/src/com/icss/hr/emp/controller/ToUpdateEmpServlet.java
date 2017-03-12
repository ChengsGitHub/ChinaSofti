package com.icss.hr.emp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.po.Dept;
import com.icss.hr.dept.service.impl.DeptServiceImpl;
import com.icss.hr.emp.po.Emp;
import com.icss.hr.emp.service.impl.EmpServieImpl;
import com.icss.hr.job.po.Job;
import com.icss.hr.job.service.impl.JobServiceImpl;

@WebServlet("/ToUpdateEmpServlet")
public class ToUpdateEmpServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String empId = request.getParameter("empId");
		
		JobServiceImpl jobService = new JobServiceImpl();
		DeptServiceImpl deptService = new DeptServiceImpl();
		EmpServieImpl empService = new EmpServieImpl();
		
		try {
			ArrayList<Job> jobList = jobService.query();
			ArrayList<Dept> deptList = deptService.query();
			Emp emp = empService.queryById(Integer.parseInt(empId));
			
			request.setAttribute("jobList", jobList);
			request.setAttribute("deptList", deptList);
			request.setAttribute("emp", emp);
			
			request.getRequestDispatcher("/UpdateEmp.jsp").forward(request, response);
		} catch (Exception e) {			
			e.printStackTrace();
		}

	}

}