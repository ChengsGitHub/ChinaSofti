package com.icss.hr.dept.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.service.impl.DeptServiceImpl;

@WebServlet("/DeleteDeptServlet")
public class DeleteDeptServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();

		// ��ò���ID
		String deptId = request.getParameter("deptId");

		// ����Service����
		DeptServiceImpl service = new DeptServiceImpl();
		
		try {
			//ɾ������
			service.delete(Integer.parseInt(deptId));
			out.println("<script>alert('����ɾ���ɹ�');location.href='QueryDeptServlet';</script>");
		}  catch (Exception e) {			
			e.printStackTrace();
			//�洢���� ��Ϣ��ת��������ҳ 
			request.setAttribute("errmsg", e.getMessage());						
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}

	}

}