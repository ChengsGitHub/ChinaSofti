package com.icss.hr.job.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.job.po.Job;
import com.icss.hr.job.service.impl.JobServiceImpl;

@WebServlet("/QueryJobServlet")
public class QueryJobServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JobServiceImpl service = new JobServiceImpl();
		
		try {
			ArrayList<Job> list = service.query();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/QueryJob.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}