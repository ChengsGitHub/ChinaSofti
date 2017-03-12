package com.icss.hr.job.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.job.pojo.Job;
import com.icss.hr.job.service.JobService;
import com.icss.hr.job.service.impl.JobServiceImpl;

public class QueryJobServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		JobService service = new JobServiceImpl();
		
		try {
			ArrayList<Job> list = service.query();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/QueryJob.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errmsg", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}
		
	}

}