package com.icss.hr.job.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.job.service.JobService;
import com.icss.hr.job.service.impl.JobServiceImpl;
import com.icss.hr.job.vo.JobVo;

public class UpdateJobServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String jobId = request.getParameter("jobId");
		String jobName = request.getParameter("jobName");
		String jobMinSalary = request.getParameter("jobMinSalary");
		String jobMaxSalary = request.getParameter("jobMaxSalary");
		
		JobVo vo = new JobVo(jobId,jobName,Integer.parseInt(jobMinSalary),Integer.parseInt(jobMaxSalary));
		
		JobService service = new JobServiceImpl();
		
		try {					
			
			service.update(vo);
			
		} catch (Exception e) {			
			e.printStackTrace();
			request.setAttribute("errmsg", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}
		
		out.println("<script>alert('修改职务成功！');location.href='QueryJobServlet';</script>");

	}

}