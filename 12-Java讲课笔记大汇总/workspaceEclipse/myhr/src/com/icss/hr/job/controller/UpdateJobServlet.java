package com.icss.hr.job.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.job.service.impl.JobServiceImpl;
import com.icss.hr.job.vo.JobVo;

@WebServlet("/UpdateJobServlet")
public class UpdateJobServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 设置请求和响应的编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();// 输出

		// 获得请求参数
		String jobId = request.getParameter("jobId");
		String jobName = request.getParameter("jobName");
		String jobMinSalary = request.getParameter("jobMinSalary");
		String jobMaxSalary = request.getParameter("jobMaxSalary");

		// 封装为VO对象
		JobVo vo = new JobVo(jobId, jobName, Integer.parseInt(jobMinSalary),
				Integer.parseInt(jobMaxSalary));

		// 创建servlet对象
		JobServiceImpl service = new JobServiceImpl();

		try {
			service.update(vo);
			out.println("<script>alert('职务更新成功');location.href='QueryJobServlet';</script>");

		} catch (Exception e) {
			e.printStackTrace();
			//存储错误消息，转发到错误页
			request.setAttribute("errmsg", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

}
