package com.icss.hr.dept.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.po.Dept;
import com.icss.hr.dept.service.impl.DeptServiceImpl;

@WebServlet("/ToUpdateDeptServlet")
public class ToUpdateDeptServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//��ò���ID
		String deptId = request.getParameter("deptId");
		
		DeptServiceImpl service = new DeptServiceImpl();
		
		try {
			//����Service���ز���PO����
			Dept dept = service.queryById(Integer.parseInt(deptId));
			
			//�洢����Χ�У�ת����JSP��ͼ
			request.setAttribute("dept",dept);
			request.getRequestDispatcher("/UpdateDept.jsp").forward(request, response);
			
		}  catch (Exception e) {			
			e.printStackTrace();
			//�洢���� ��Ϣ��ת��������ҳ 
			request.setAttribute("errmsg", e.getMessage());						
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
	}

}