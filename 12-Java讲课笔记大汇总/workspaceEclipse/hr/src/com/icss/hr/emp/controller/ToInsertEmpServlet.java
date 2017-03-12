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
import com.icss.hr.job.pojo.Job;
import com.icss.hr.job.service.JobService;
import com.icss.hr.job.service.impl.JobServiceImpl;

public class ToInsertEmpServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DeptService deptService = new DeptServiceImpl();
		JobService jobService = new JobServiceImpl();
		
		try {
			ArrayList<Dept> deptList = deptService.query();
			ArrayList<Job> jobList = jobService.query();
			
			request.setAttribute("deptList", deptList);
			request.setAttribute("jobList", jobList);
			
			request.getRequestDispatcher("/InsertEmp.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errmsg", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}
		
	}

}
