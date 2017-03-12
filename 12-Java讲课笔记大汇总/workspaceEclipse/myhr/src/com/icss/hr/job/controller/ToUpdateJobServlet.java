package com.icss.hr.job.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.po.Dept;
import com.icss.hr.job.po.Job;
import com.icss.hr.job.service.impl.JobServiceImpl;

@WebServlet("/ToUpdateJobServlet")
public class ToUpdateJobServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// ���ְ��ID
		String jobId = request.getParameter("jobId");

		JobServiceImpl service = new JobServiceImpl();
		
		try {
			//����service����ְ��po����
			Job job = service.queryById(jobId);
			
			//�洢����Χ�У�ת����JSP��ͼ
			request.setAttribute("job", job);
			request.getRequestDispatcher("/UpdateJob.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			//�洢������Ϣ��ת��������ҳ
			request.setAttribute("errmsg", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}

	}

}
