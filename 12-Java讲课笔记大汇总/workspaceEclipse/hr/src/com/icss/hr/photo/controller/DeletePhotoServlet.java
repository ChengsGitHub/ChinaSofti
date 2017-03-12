package com.icss.hr.photo.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.photo.service.PhotoService;
import com.icss.hr.photo.service.impl.PhotoServiceImpl;

public class DeletePhotoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();

		ServletContext context = this.getServletContext();
		
		String photoId = request.getParameter("photoId");
		String photoPath = request.getParameter("photoPath");
		String empId = request.getParameter("empId");
		
		PhotoService service = new PhotoServiceImpl();
		
		try {
			/****删除硬盘文件******/
			File file = new File(context.getRealPath("/upload/" + photoPath));
			file.delete();
			
			/****删除表数据*******/
			service.delete(Integer.parseInt(photoId));	
			
		}  catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errmsg", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}
		
		out.println("<script>alert('删除成功!');location.href='QueryPhotoServlet?empId=" + empId + "';</script>");
	}

}