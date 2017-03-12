package com.icss.hr.emp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.dept.service.DeptService;
import com.icss.hr.dept.service.impl.DeptServiceImpl;
import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.emp.service.EmpService;
import com.icss.hr.emp.service.impl.EmpServiceImpl;
import com.icss.hr.job.pojo.Job;
import com.icss.hr.job.service.JobService;
import com.icss.hr.job.service.impl.JobServiceImpl;

public class ToUpdateEmpServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String empId = request.getParameter("empId");

		EmpService empService = new EmpServiceImpl();
		DeptService deptService = new DeptServiceImpl();
		JobService jobService = new JobServiceImpl();
		
		try {
			Emp emp = empService.queryById(Integer.parseInt(empId));
			ArrayList<Dept> deptList = deptService.query();
			ArrayList<Job> jobList = jobService.query();
			
			request.setAttribute("emp", emp);
			request.setAttribute("deptList", deptList);
			request.setAttribute("jobList", jobList);
			
			request.getRequestDispatcher("/UpdateEmp.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errmsg", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}
		
	}

}