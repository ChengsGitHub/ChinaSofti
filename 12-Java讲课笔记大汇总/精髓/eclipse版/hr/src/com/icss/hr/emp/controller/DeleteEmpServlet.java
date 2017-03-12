package com.icss.hr.emp.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.emp.service.EmpService;
import com.icss.hr.emp.service.impl.EmpServiceImpl;
import com.icss.hr.photo.pojo.Photo;
import com.icss.hr.photo.service.PhotoService;
import com.icss.hr.photo.service.impl.PhotoServiceImpl;

public class DeleteEmpServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ServletContext context = this.getServletContext();
		
		PrintWriter out = response.getWriter();

		String empId = request.getParameter("empId");
		
		EmpService service = new EmpServiceImpl();
		PhotoService photoService = new PhotoServiceImpl();
		
		try {
			/****删除所有的员工照片文件**/
			ArrayList<Photo> list = photoService.query(Integer.parseInt(empId));
			
			for (Photo photo : list) {
				File file = new File(context.getRealPath("/upload/" + photo.getPhotoPath()));
				file.delete();
			}
						
			/****删除表数据****/
			service.delete(Integer.parseInt(empId));
			
		}  catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errmsg", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}
		
		out.println("<script>alert('删除员工成功！');location.href='QueryEmpServlet';</script>");
	}

}