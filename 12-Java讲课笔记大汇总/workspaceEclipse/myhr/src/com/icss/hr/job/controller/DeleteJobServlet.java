package com.icss.hr.job.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.job.service.impl.JobServiceImpl;

@WebServlet("/DeleteJobServlet")
public class DeleteJobServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置请求和响应的编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		//获得部门ID
		String jobId = request.getParameter("jobId");
		
		//创建Service对象
		JobServiceImpl service = new JobServiceImpl();
		
		try {
			//删除数据
			service.delete(jobId);
			out.println("<script>alert('职务删除成功'); location.href='QueryJobServlet';</script>");
		} catch (Exception e) {
			e.printStackTrace();
			//存储错误信息，转发到错误页
			request.setAttribute("errmsg", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request,response);
		}
		
	}

}
