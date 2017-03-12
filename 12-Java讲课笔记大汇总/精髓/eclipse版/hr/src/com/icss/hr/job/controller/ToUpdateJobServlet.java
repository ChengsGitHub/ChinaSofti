package com.icss.hr.job.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.job.pojo.Job;
import com.icss.hr.job.service.JobService;
import com.icss.hr.job.service.impl.JobServiceImpl;

public class ToUpdateJobServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String jobId = request.getParameter("jobId");
		
		JobService service = new JobServiceImpl();
		
		try {
			Job job = service.queryById(jobId);
			request.setAttribute("job", job);
			request.getRequestDispatcher("/UpdateJob.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errmsg", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}
		
	}

}