package com.icss.hr.photo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.photo.pojo.Photo;
import com.icss.hr.photo.service.PhotoService;
import com.icss.hr.photo.service.impl.PhotoServiceImpl;

public class QueryPhotoServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String empId = request.getParameter("empId");
		
		PhotoService service = new PhotoServiceImpl();
		
		try {
			ArrayList<Photo> list = service.query(Integer.parseInt(empId));
			request.setAttribute("list", list);
			request.getRequestDispatcher("/QueryPhoto.jsp").forward(request, response);
		}  catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errmsg", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}
		
		
	}

}