package com.icss.hr.job.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.job.service.JobService;
import com.icss.hr.job.service.impl.JobServiceImpl;

public class DeleteJobServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String jobId = request.getParameter("jobId");
		
		JobService service = new JobServiceImpl();
		
		try {
			service.delete(jobId);			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errmsg", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}
		
		out.println("<script>alert('删除职务成功！');location.href='QueryJobServlet';</script>");
		
	}

}